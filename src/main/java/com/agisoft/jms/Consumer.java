/* 
 * ============================================================================ 
 * Name      : Consumer.java
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

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

/**
 * 
 *
 */
public class Consumer extends JMSBase implements Runnable, MessageListener {

    private MessageConsumer consumer;
    private String name;

    /**
     * @param session
     * @param destination
     * @param connection
     * @throws JMSException 
     */
    public Consumer(Paradigm paradigm, String name) throws JMSException {
        super(paradigm);
        try {
            this.consumer = session.createConsumer(destination);
        } catch (JMSException e) {
            System.out.println("Failed to create consumer");
            close();
            e.printStackTrace();

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    public void onMessage(Message message) {
        try {
            int number = message.getIntProperty("number");
            final String out = " Message #" + number + "corelationID: " + message.getJMSCorrelationID() + " type: ";
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                System.out.println(out + msg.getClass().getSimpleName() + " payload: " + msg.getText());
            } else if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                System.out.println(out + msg.getClass().getSimpleName() + " payload: " + msg.getObject());
            } else if (message instanceof BytesMessage) {
                BytesMessage msg = (BytesMessage) message;
                System.out.println(out + msg.getClass().getSimpleName() + " payload: " + " bool = " + msg.getBooleanProperty("bool") + "int = "
                        + msg.getIntProperty("int"));
            } else if (message instanceof StreamMessage) {
                StreamMessage msg = (StreamMessage)message;
                System.out.println(out + msg.getClass().getSimpleName() + " payload: " + ": bool = " + msg.getBooleanProperty("bool") + "int = "
                        + msg.getIntProperty("int"));
            }
        } catch (JMSException e) {
            try {
                System.err.println("Failed to read a " + message.getJMSType() + " message.");
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public void run() {
        try {
            consumer.setMessageListener(this);
        } catch (JMSException e) {
            System.out.println("Failed to set message listener.");
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished."); 
    }
}
