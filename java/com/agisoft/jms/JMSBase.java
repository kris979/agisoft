/* 
 * ============================================================================ 
 * Name      : JMSBase.java
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

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 *
 */
public abstract class JMSBase {

    public enum Paradigm {
        PUBLISH_SUBSCRIBE, P2P
    }
    
    public static final String INTERVIEW_TOPIC = "interview_topic";
    public static final String INTERVIEW_QUEUE = "interview_queue";
    protected Session session;
    protected Destination destination;
    protected Connection connection;

    /**
     * @param session
     * @param destination
     * @param connection
     * @throws JMSException 
     */
    protected JMSBase(Paradigm paradigm) throws JMSException {
        super();
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        this.connection = factory.createConnection();
        this.connection.start();
        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        switch (paradigm) {
        case PUBLISH_SUBSCRIBE:
            destination = session.createTopic(INTERVIEW_TOPIC);
            break;
        case P2P:
            destination = session.createQueue(INTERVIEW_QUEUE);
            break;
       default: 
           throw new IllegalArgumentException(paradigm + " not supported");
        }
    }

    /**
     * @param connection
     * @throws JMSException
     */
    protected void close() {
        try {
            session.close();
            connection.close();
        } catch (JMSException e) {
            System.out.println("Closing connection failed.");        
        }
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#finalize()
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }

}