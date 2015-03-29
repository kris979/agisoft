package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PractisePrintWriter {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        fileReaderWriter();
    }

    /**
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void fileReaderWriter() {
        File f = new File("test.txt");
        try {
            FileWriter fw = new FileWriter(f); // this actually creates a file, unlike File
            PrintWriter pw = new PrintWriter(fw);
            pw.append("krzysztof");
            pw.println("Bliszczak");
            pw.println("is learning...");
            pw.append("JAVA.");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader fr;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String readLine;
            do {
                readLine = br.readLine();
                System.out.println(readLine);
            } while (readLine != null);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (f.delete()) {
            System.out.println("File deleted.");
        }
    }

}
