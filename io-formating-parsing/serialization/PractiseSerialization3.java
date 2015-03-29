 package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//will cause runtime exception NotSerializableException because it's an object that does not implement Serializable
class Dupa {
    int d = 6555;
}

class Cat1 implements Serializable {
    static final long serialVersionUID = 0xbaba;
    int i = 1;
    Dupa d;
    
    Cat1(int i) {
        this.i = i;
        d = new Dupa();
    }
}

public class PractiseSerialization3 implements Serializable{
    static final long serialVersionUID = 0xcafe;
    String fileName = "cat.ser";
    int i = 5;

    public static void main(String[] args) {
        Cat1 c1 = new Cat1(2);
        Cat1 c = new Cat1(1);

        PractiseSerialization3 ps = new PractiseSerialization3();
        ps.ser(c,c1);
        ps.deSer();
        ps.deleteFile(new File(ps.fileName));
    }
    
    void ser(Cat1...c) {
        try {
            FileOutputStream fs = new FileOutputStream("Cat1.ser"); //this actually creates a file, unlike File
            ObjectOutputStream os = new ObjectOutputStream(fs);
            for (Cat1 cat : c) {
                System.out.println("Serializing:" + cat.i + "," + cat.d.d );
                os.writeObject(cat); //<--- tu polegnie z runtime exception java.io.NotSerializableException
            }
            os.close();
        } catch (Exception e) {
        }
    }
    
    void deSer() {
        try {
            FileInputStream fi;
            ObjectInputStream is;
            fi = new FileInputStream("Cat1.ser");  //throws FileNotFoundException
            is = new ObjectInputStream(fi); //throws IOException
            Cat1 c1 = (Cat1)is.readObject();
            System.out.println("Deserialized int: " + c1.i + "," + c1.d.d);
            Cat1 c = (Cat1)is.readObject();
            System.out.println("Deserialized int: " + c.i + "," + c.d.d);
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
