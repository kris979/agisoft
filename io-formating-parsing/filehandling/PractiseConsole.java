package filehandling;

import java.io.Console;
import java.io.PrintWriter;

public class PractiseConsole {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.out.println("Dupa, console is null");
        }
        char[] pw;
        pw = c.readPassword("%s", "pw: ");
        String line = c.readLine();
        PrintWriter writer = c.writer();
        writer.println();
        for (char d : pw) {
            c.format("%c", d);
        }
    }

}
