/* 
 * ============================================================================ 
 * Name      : ChatServer.java
 * ============================================================================
 */
package kata.chat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 
 *
 */
public class ChatServer {

    private final File logFile = new File("log.log");
    private RandomAccessFile raf;
    private FileChannel fc;
    private ServerSocketChannel serverSocketChannel;

    /**
     * 
     */
    private ChatServer() {
        super();
    }

    /**
     * @throws FileNotFoundException 
     * 
     */
    private void start() throws FileNotFoundException {
        openFileChannel();
        openSocketChannel();
        listen();
    }

    /**
     * @throws FileNotFoundException 
     * 
     */
    private void openFileChannel() throws FileNotFoundException {
        raf = new RandomAccessFile(logFile, "rw");
        fc = raf.getChannel();
    }

    /**
     * 
     */
    private void openSocketChannel() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            SocketAddress endpoint = new InetSocketAddress("localhost", 666);
            serverSocketChannel.socket().bind(endpoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     */
    private void listen() {
        while (true) {
            try {
                SocketChannel accept = serverSocketChannel.accept();
                if (accept != null) {
                    fc.transferFrom(accept, 0, 1024);
//                    fc.
//                    ByteBuffer buf = ByteBuffer.allocate(20);
//                    buf.clear();
//                    while(accept.read(buf) >=0 || buf.position() != 0) {
//                        buf.flip();
//                        System.out.println(new String(buf.array()));
//                        buf.compact();
//                    }
                } else {
//                    System.out.print(".");
                    Thread.sleep(500);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @throws IOException 
     * 
     */
    private void close() throws IOException {
        serverSocketChannel.close();
        raf.close();
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        try {
            server.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
