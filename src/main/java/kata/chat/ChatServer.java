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
            serverSocketChannel.configureBlocking(true);
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 666));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     */
    private void listen() {
            try {
                while(true) {
                System.out.println("Accepting connection.");
                SocketChannel connection = serverSocketChannel.accept();
//                System.out.println(connection.isConnected());
//                System.out.println(connection.isConnectionPending());
//                System.out.println(connection.isOpen());
                long transfered = fc.transferFrom(connection, 0, 1024*1024*1024);
                System.out.println("Transfered: " + transfered);
                System.out.println("Closing connection " + connection.toString());
                connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
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
