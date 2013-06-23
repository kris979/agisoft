package kata.wordstophonenumber;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Set;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.collections.functors.NotNullPredicate;
import org.hamcrest.core.IsNot;

public class WordsToNumber {
	

	public static void main(String[] args) throws IOException {
		
		ExecutorService splitters = Executors.newCachedThreadPool();
		CompletionService<Set<String>> service = new ExecutorCompletionService<Set<String>>(splitters);
		
		RandomAccessFile dict = null;
		try {
		dict = new RandomAccessFile(
				"src/test/java/kata/wordbuilder/en-GB.dic", "r");
		FileChannel channel = dict.getChannel();

		
		Reader reader = Reader.getReader(service, channel);
		reader.start();
		
		Encoder encoder = Encoder.getInstance(service, reader);
		
		encoder.start();
		
		splitters.shutdownNow();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dict != null) {
				dict.close();
			}
		}
	}

}
