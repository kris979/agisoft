package kata.wordstophonenumber;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Reader {

	private final FileChannel channel;
	private ByteBuffer buffer;
	private byte[] dst = new byte[8192];
	private long total = 0;
	private CompletionService<Set<String>> service;
	private boolean done = false;
	private int counter = 0;
	
	public static Reader getReader(CompletionService<Set<String>> service, FileChannel channel) {
		return new Reader(service, channel);
	}

	public Reader(CompletionService<Set<String>> service, FileChannel channel) {
		this.channel = channel;
		this.buffer = ByteBuffer.allocate(8192);
		this.service = service;
	}

	public void start() throws Exception {
		try {
			int read = 0;
			while (read != -1) {
				//read
				buffer.clear();
				read = channel.read(buffer);
				System.out.println(++counter + ") chunk: " + read + " bytes");
				total += read;
				buffer.rewind();
				buffer.get(dst);
				//pass for processing
				Splitter splitterTask = new Splitter(dst, counter);
				service.submit(splitterTask);
			}
		} catch (IOException e) {
		} finally {
			System.out.println("Done! Total read: " + total/1024 + " KB in " + counter + " chunks.");
			channel.close();
			done  = true;
		}

	}

	public boolean isDone() {
		return done;
	}

	public int getCounter() {
		return counter;
	}

}
