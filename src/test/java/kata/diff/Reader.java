package kata.diff;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Reader {
	
	private RandomAccessFile file;
	
	private FileChannel channel;
	

	public void read() {
		try {
			String readLine = file.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
