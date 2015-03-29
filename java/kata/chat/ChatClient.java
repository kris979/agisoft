/* 
 * ============================================================================ 
 * Name      : ChatClient.java
 * ============================================================================
 */
package kata.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;



/**
 * 
 *
 */
public class ChatClient {

    private SocketChannel sc;

    public ChatClient() {
    }

    /**
     * @throws IOException
     * 
     */
    /**
     * @throws IOException
     */
    private void connect() throws IOException {
        sc = SocketChannel.open();
        sc.configureBlocking(true);
        boolean connected = sc.connect(new InetSocketAddress("localhost", 666));
        if (connected) {
            System.out.println("Successfully connected.");
        }
    }

    private void close() throws IOException {
        sc.close();
    }

    private void send(String line) {
        try {
            int write = sc.write(ByteBuffer.wrap(line.getBytes()));
        } catch (IOException e) {
            System.err.println("Can't send");
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    private void sendTestMsg() {
        Random randomizer = new Random();
        StringBuilder msg = new StringBuilder();
        for (int i=0; i < 10; i++) {
            int nextInt = randomizer.nextInt(30)^90;
            msg.append((char)nextInt);
            if ((i%5)==0) {
                System.out.println(Thread.currentThread().getName() + ": " + msg);
                send(Thread.currentThread().getName());
                msg = new StringBuilder();
            }
        }
    }

    /**
     * @param br
     * @param client
     */
    private void sendFromKeyboardToChannel() {
        final Reader in = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(in);
        String msg = null;
        while (true) {
            System.out.print(">");
            msg = readFromKeyboard(br, msg);
            send(msg);
            if (msg.equals("end")) {
                return;
            }
        }
    }

    /**
     * @param br
     * @param msg
     * @return
     */
    private String readFromKeyboard(final BufferedReader br, String msg) {
        try {
            msg = br.readLine();
        } catch (IOException e) {
            System.err.println("cant read line form keyboard");
            e.printStackTrace();
        }
        return msg;
    }

    public static class Chatter implements Runnable {

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            final ChatClient client = new ChatClient();
            try {
                client.connect();
                // client.sendFromKeyboardToChannel();
                client.sendTestMsg();
            } catch (IOException e1) {
                System.err.println("Can't open SocketChannel on client");
                e1.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    System.err.println("Can't close client");
                    e.printStackTrace();
                }
                System.out.println("Client closed succesfully.");
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Chatter chatter1 = new Chatter();
        Thread t1 = new Thread(chatter1);
        Thread t2 = new Thread(chatter1);
        t1.start();
        Thread.sleep(10000);
        t2.start();
    }
}
