package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


class Cat implements Serializable {
    static final long serialVersionUID = 0xbaba;
    int i = 1;
    
    Cat(int i) {
        this.i = i;
    }
}

public class PractiseSerialization implements Serializable{
    static final long serialVersionUID = 0xcafe;
    String fileName = "cat.ser";
    int i = 5;
    private static final Logger LOGGER = Logger.getLogger(PractiseSerialization.class.getName());
    
    public static void main(String[] args) {
        Cat c1 = new Cat(2);
        Cat c = new Cat(1);

        PractiseSerialization ps = new PractiseSerialization();
        ps.serialize(c,c1);
        ps.deserialize();
        ps.deleteFile(new File(ps.fileName));
    }
    
    void serialize(Cat...c) {
        try {
            FileOutputStream fs = new FileOutputStream(fileName); //this actually creates a file, unlike File
            ObjectOutputStream os = new ObjectOutputStream(fs);
            for (Cat cat : c) {
                LOGGER.log(Level.INFO, "Serializing:" + cat.i);
                os.writeObject(cat);
            }
            os.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    
    void deserialize() {
        try {
            FileInputStream fi = new FileInputStream("cat.ser");  //throws FileNotFoundException
            ObjectInputStream is = new ObjectInputStream(fi);     //throws IOException
            Cat c1 = (Cat)is.readObject();
            LOGGER.log(Level.INFO, "Deserialized int: " + c1.i);
            Cat c = (Cat)is.readObject();
            System.out.println("Deserialized int: " + c.i);
            is.close();
        } catch (FileNotFoundException e) {
            System.err.println("Can't find a file.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("File Found but can not read from it.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("File read but can not find a class to deserialize");
            e.printStackTrace();
        }
    }

   void deleteFile(File f) {
       try {
        boolean deleted = f.delete();
        if (deleted) 
            System.out.println("File was successfully deleted");        
    } catch (Exception e) {
        System.err.println("Exception type:" + e.getClass().getCanonicalName());
        e.printStackTrace();
    }
   }
}
