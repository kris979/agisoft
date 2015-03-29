package com.agisoft.threads;
/* 
 * ============================================================================ 
 * Name      : JMSThreads.java
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

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

class Producer implements Runnable {
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.println("Producing a message.");
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        try {
            Connection connection = factory.createConnection();
            connection.start();
            
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            
            Queue testQueue = session.createQueue("test.queue");
            
            MessageProducer producer = session.createProducer(testQueue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            
            String text = "Hello! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
            TextMessage message = session.createTextMessage(text);
            
            System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);

            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
        
    }
    
}

class Consumer implements Runnable, MessageListener, ExceptionListener {

    private ActiveMQConnectionFactory factory;
    private Connection connection;
    private Session session;
    private MessageConsumer consumer;
    private Queue testQueue;
    
    public Consumer() {
        factory = new ActiveMQConnectionFactory();
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            testQueue = session.createQueue("test.queue");
            consumer = session.createConsumer(testQueue);
            consumer.setMessageListener(this);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    /* (non-Javadoc)
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    @Override
    public void onMessage(Message arg0) {
        if (arg0 instanceof TextMessage) {
            TextMessage msg = (TextMessage)arg0;
            try {
                System.out.println("Received message: " + msg.getText());
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("Received message is not a text message.");
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.println("Running consumer");
        for (int i=0; i < 10; i++) {
            try {
                System.out.println("Waiting for messages");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see javax.jms.ExceptionListener#onException(javax.jms.JMSException)
     */
    @Override
    public void onException(JMSException arg0) {
        System.out.println("Cought exception:" + arg0);
        System.out.println("Shutting down.");
    }
}

/**
 * 
 *
 */
public class JMSThreads {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        Thread pt1 = new Thread(producer);
        Thread pt2 = new Thread(producer);
        Thread pt3 = new Thread(producer);
        Thread ct = new Thread(consumer);
        pt1.start();
        pt2.start();
        pt3.start();
        ct.start();
    }
}
