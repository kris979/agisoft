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
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

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
    public void openChannel() throws IOException {
            sc = SocketChannel.open();
            SocketAddress remote = new InetSocketAddress("localhost", 666);
            sc.connect(remote);
    }

    public void close() throws IOException {
        sc.close();
    }
    
    private void send(String line) {
        try {
            int write = sc.write(ByteBuffer.wrap(line.getBytes()));
            System.out.println(write + " sent");
        } catch (IOException e) {
            System.err.println("Can't send");
            e.printStackTrace();
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

    public static void main(String[] args) {
        final ChatClient client = new ChatClient();
        try {
            client.openChannel();
            client.sendFromKeyboardToChannel();
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
