package kata.wordstophonenumber;

import java.util.Set;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Encoder {

	private CompletionService<Set<String>> service;
	private Reader reader;
	
	public Encoder(CompletionService<Set<String>> service, Reader reader) {
		super();
		this.service = service;
		this.reader = reader;
	}

	public void go() throws Exception {

	}

	public static Encoder getInstance(CompletionService<Set<String>> service, Reader reader) {
		return new Encoder(service, reader);
	}
	
	
	public void encode() throws InterruptedException, ExecutionException {
		int processedChunks = 0;
		while (!reader.isDone()) {
			Future<Set<String>> result = service.take();
			Set<String> set = result.get();
			processedChunks++;
//			System.out.println("Encoding " + processedChunks + " chunk");

		}
		
		int remainingChunks = reader.getCounter() - processedChunks;
		for (int i = 0; i < remainingChunks; i++) {
			Future<Set<String>> result = service.take();
			Set<String> set = result.get();
			processedChunks++;
//			System.out.println(set);
//			System.out.println("Encoding " + processedChunks + " chunk");
			System.out.println("!!!!!" + set);
		}
		
		if (processedChunks == reader.getCounter()) {
			System.out.println("All chunks processed successfully");
		} else {
			System.out.println("Chunks: " + reader.getCounter() + "Proccessed chunks: " + processedChunks);
		}
	}

	public void start() throws InterruptedException, ExecutionException {
		encode();
	}


}
