/* 
 * ============================================================================ 
 * Name      : Producer.java
 * Part of     :  NEON
 * 
 * Copyright (c) 2007-2011 Nokia.  All rights reserved.
 * This material, including documentation and any related computer
 * programs, is protected by copyright controlled by Nokia.  All
 * rights are reserved.  Copying, including reproducing, storing,
 * adapting or translating, any or all of this material requires the
 * prior written consent of Nokia.  This material also contains
 * confidential information which may not be disclosed to others
 * without the prior written consent of Nokia.
 * 
 * ============================================================================
 */
package com.agisoft.jms;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.jms.BytesMessage;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

//Difference between BytesMessage and StreamMessage!!!!
// BytesMessage stores the primitive data types by converting them to their byte representation. Thus the message is
// one contiguous stream of bytes. While the StreamMessage maintains a boundary between the different data types
// stored because it also stores the type information along with the value of the primitive being stored.
// BytesMessage allows data to be read using any type. Thus even if your payload contains a long value, you can
// invoke a method to read a short and it will return you something. It will not give you a semantically correct
// data but the call will succeed in reading the first two bytes of data. This is strictly prohibited in the
// StreamMessage. It maintains the type information of the data being stored and enforces strict conversion rules on
// the data being read.

/**
 * 
 *
 */
public class Producer extends JMSBase implements Runnable {

    private MessageProducer producer;
    private Random generator;

    static enum MsgType {
        TEXT(0), OBJECT(1);

        final int type;

        MsgType(int type) {
            this.type = type;
        }

        int getType() {
            return type;
        }
    }

    public static class TestObj implements Serializable {
        public String toString() {
            return getClass().getName();
        }
    }

    /**
     * @throws JMSException
     * 
     */
    public Producer(Paradigm paradigm) throws JMSException {
        super(paradigm);
        generator = new Random();
        try {
            producer = session.createProducer(destination);
        } catch (JMSException e) {
            System.out.println("Failed to create a producer.");
            close();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {
        try {
            for (int j = 0; j < 10; j++) {
                Message message = createRandomMessage(j);
                /*
                 * Most JMS headers are automatically assigned; their value is set by the JMS provider when the message
                 * is delivered, so that values assigned by the developer using the setJMS<HEADER>( ) methods are
                 * ignored. In other words, for headers that are automatically assigned, using the mutator methods
                 * explicitly is fruitless.
                 */
                message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
                /*
                 * A more common use of the JMSCorrelationID is not for the sake of establishing identity; it is for
                 * correlating the asynchronous reception of a message with a message that had been previously sent. A
                 * message consumer wishing to create a message to be used as a response may place the JMSMessageID of
                 * the original message in the JMSCorrelationID of the response message.
                 */
                message.setJMSCorrelationID("id");
                message.setIntProperty("number", j);
                producer.send(message);
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            }
        } catch (JMSException e) {
            System.out.println("Sending message failed.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("My sleep has been interrupted");
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private Message createRandomMessage(int number) throws JMSException {
        int msgType = generator.nextInt(4);
        Message msg = null;
        switch (msgType) {
        case 0:
            msg = createTextMessage(number);
            break;
        case 1:
            msg = createObjectMessage();
            break;
        case 2:
            msg = createBytesMessage();
            break;
        case 3:
            msg = createStreamMessage();
            break;
        default:
            System.out.println("Msg type: " + msgType + ". This should never happen.");
            throw new IllegalArgumentException();
        }
        return msg;
    }

    /**
     * @param number
     * @return
     * @throws JMSException
     */
    private ObjectMessage createObjectMessage() throws JMSException {
        ObjectMessage message = session.createObjectMessage();
        // message.setObject(MsgType.OBJECT);
        message.setObject(new TestObj());
        return message;
    }

    /**
     * @param j
     * @return
     * @throws JMSException
     */
    private TextMessage createTextMessage(int j) throws JMSException {
        TextMessage message = session.createTextMessage();
        message.setText("message " + j);
        return message;
    }

    /**
     * BytesMessage contains an array of primitive bytes in it's payload. Thus it can be used for transfer of data
     * between two applications in their native format which may not be compatible with other Message types. It is also
     * useful where JMS is used purely as a transport between two systems and the message payload is opaque to the JMS
     * client. Whenever you store any primitive type, it is converted into it's byte representation and then stored in
     * the payload. There is no boundary line between the different data types stored. Thus you can even read a long as
     * short. This would result in erroneous data and hence it is advisable that the payload be read in the same order
     * and using the same type in which it was created by the sender.
     */
    private BytesMessage createBytesMessage() throws JMSException {
        BytesMessage message = session.createBytesMessage();
        message.setBooleanProperty("bool", true);
        message.setIntProperty("int", 1);
        return message;
    }

    /**
     * StreamMessage carries a stream of Java primitive types as it's payload. It contains some conveient methods for
     * reading the data stored in the payload. However StreamMessage prevents reading a long value as short, something
     * that is allwed in case of BytesMessage. This is so because the StreamMessage also writes the type information
     * alonwgith the value of the primitive type and enforces a set of strict conversion rules which actually prevents
     * reading of one primitive type as another.
     * 
     * @return
     * @throws JMSException
     */
    private javax.jms.StreamMessage createStreamMessage() throws JMSException {
        javax.jms.StreamMessage message = session.createStreamMessage();
        message.setBooleanProperty("bool", true);
        message.setIntProperty("int", 1);
        return message;
    }

}
