package kata.wordstophonenumber;

import java.util.*;
import java.util.concurrent.Callable;

public class Splitter implements Callable<Set<String>> {
	
	private final byte[] src;
	private final String name;
	
	

	public Splitter(byte[] src, int counter) {
		super();
		this.src = src;
		this.name = "Chunk " + counter;
	}



	@Override
	public Set<String> call() throws Exception {
		System.out.println("Processing " + name);
		String source = new String(src);
		Scanner scanner = new Scanner(source);
		Set<String> list = new HashSet<String>();
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			list.add(nextLine);
		}
		return list;
	}

}
