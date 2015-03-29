package com.agisoft.jms;

import javax.jms.JMSException;

import com.agisoft.jms.JMSBase.Paradigm;

/**
 * Q: What are the core JMS-related objects required for each JMS-enabled application?
 * 
 * A: : Each JMS-enabled client must establish the following: 
 * 
 * • A connection object provided by the JMS server (the message broker) 
 * • Within a connection, one or more sessions, which provide a context for message sending and receiving 
 * • Within a session, either a queue or topic object representing the destination (the message staging area)
 *   within the message broker 
 * • Within a session, the appropriate sender or publisher or receiver or subscriber object
 *   (depending on whether the client is a message producer or consumer and uses a point-to-point or publish/subscribe
 *   strategy, respectively) 
 * . Within a session, a message object (to send or to receive)
 * 
 * 
 * Q: What is the advantage of persistent message delivery compared to nonpersistent delivery?
 * 
 * A: If the JMS server experiences a failure, for example, a power outage, any message that it is holding in primary
 * storage potentially could be lost. With persistent storage, the JMS server logs every message to secondary storage.
 * (The logging occurs on the front end, that is, as part of handling the send operation from the message producing
 * client.) The logged message is removed from secondary storage only after it has been successfully delivered to all
 * consuming clients .
 * 
 * JMS API messaging provides guaranteed delivery via the once-and-only-once delivery semantics of PERSISTENT messages.
 * In addition, message consumers can ensure reliable processing of messages by using either CLIENT_ACKNOWLEDGE mode or
 * transacted sessions. This achieves reliable delivery with minimum synchronization and is the enterprise messaging
 * model most vendors and developers prefer.
 * 
 * The JMS API does not define a schema of systems messages (such as delivery notifications). If an application requires
 * acknowledgment of message receipt, it can define an application-level acknowledgment message.
 * 
 * Durable subscription:
 * A durable subscription is one that outlasts a client's connection with a message server. While a durable subscriber
 * is disconnected from the JMS server, it is the responsibility of the server to store messages the subscriber misses.
 * When the durable subscriber reconnects, the message server sends it all the unexpired messages that accumulated. This
 * behavior is commonly referred to as store-and-forward messaging. Store-and-forward messaging is a key component of
 * the guaranteed messaging solution. Durable subscriptions make a JMS consumer tolerant of disconnections,
 */
public class App {

//    @Inject
    public App() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        JMS();
    }

    /**
     * 
     */
    public static void JMS() {
        try {
            Thread queueProducer = new Thread(new Producer(Paradigm.P2P));
            queueProducer.start();
            Thread queueConsumer1 = new Thread(new Consumer(Paradigm.P2P, "queueConsumer1"), "queueConsumer1");
            queueConsumer1.start();
            Thread queueConsumer2 = new Thread(new Consumer(Paradigm.P2P, "queueConsumer2"), "queueConsumer2");
            queueConsumer2.start();

            Thread topicProducer = new Thread(new Producer(Paradigm.PUBLISH_SUBSCRIBE));
            topicProducer.start();
            Thread topicConsumer1 = new Thread(new Consumer(Paradigm.PUBLISH_SUBSCRIBE, "topicConsumer1"),
                    "topicConsumer1");
            topicConsumer1.start();
            Thread topicConsumer2 = new Thread(new Consumer(Paradigm.PUBLISH_SUBSCRIBE, "topicConsumer2"),
                    "topicConsumer2");
            topicConsumer2.start();

        } catch (JMSException e) {
            System.out.println("Failed to establish connection with JMS broker.");
            e.printStackTrace();
        } finally {
            // System.out.println("Terminated.");
        }
    }
}
