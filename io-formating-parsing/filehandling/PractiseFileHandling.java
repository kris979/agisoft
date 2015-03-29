package filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PractiseFileHandling {

       File f = new File("test.txt"); //there is no real file yet, just a handle.
       
    /**
     * @param args
     */
    public static void main(String[] args) {
        PractiseFileHandling p = new PractiseFileHandling();
        p.createFile();
        p.writeToFile();
        p.writeWithBufferedWriter();
        p.readFile();
        p.deleteFile();
    }
    
    void createFile() {
       System.out.println("Creating file");
       System.out.println(f.getAbsolutePath());
       System.out.println(f.exists());
       try{
           System.out.println(f.createNewFile());
       } catch (IOException e) {
       } finally {
           System.out.println(f.exists());           
       }
    }

    void deleteFile() {
        System.out.println("Deleting file " + f);
        System.out.println(f.delete());
        System.out.println(f.exists());
    }
    
    void writeToFile() {
        try {
            FileWriter fw1 = new FileWriter(f);
            fw1.write("kris bliszczak");
            fw1.flush();
            fw1.close();
            
        } catch (IOException e) {
            System.err.println("Can not write to a file.");
            e.printStackTrace();
        }
    }

    void readFile() {        
        try {
            FileReader fr = new FileReader(f);
            long size = f.length();
            System.out.println("File size: " + size);
            int i=0;
            do {
                try {
                    char c = (char)fr.read();
                    System.out.println(c);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    i++;
                }
            } while ( i < size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    void writeWithBufferedWriter() {
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("buffered writer");
            bw.newLine();
            bw.write("new line");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
