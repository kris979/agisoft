package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Animal {
    static final long serialVersionUID = 0xbaba;
    int a;
    //becase Animal does not implement Serializable it isn't going to be serialized but its constructor 
    //is going to be run during deserialization process..
    Animal() {
        a = 8;
    }
}

class Dog extends Animal implements Serializable {
    int d = 2;
    //because it is transient it is going to get a default value when deserialized.
    //but the Dog() constructor won't run.
    
    //I am going to get it serialized with 
    //private void writeObject(ObjectOutputStream os) method.
    //and deserialized with 
    //pricate void readObject(ObjectInputStream is)
    transient int x = 111;  
    
    Dog() {
        x = 222;
    }
    
    //allows proper serialization of x
    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeInt(x);
        System.out.println("writing dog x: " + x);
     }
    //allows proper serialization of x
     private void readObject(ObjectInputStream is) throws Exception {
         is.defaultReadObject();
         x = is.readInt();
         System.out.println("read dog x: " + x);         
     }
}

public class PractiseSerialization2 implements Serializable{
    static final long serialVersionUID = 0xcafe;
    static String fileName = "dog.ser";
    private Dog d;

    /**
     * 
     */
    public PractiseSerialization2() {
        Dog d = new Dog();
        System.out.println("Dog: " + d.a + " " + d.d + " " + d.x);
        this.d = d;
    }
    
    public static void main(String[] args) {
        PractiseSerialization2 ps = new PractiseSerialization2();
        ps.serialize(ps.d);
        ps.deSerialize();
        ps.deleteFile(new File(fileName));
    }
    
    void serialize(Dog d) {
        try {
            FileOutputStream fs = new FileOutputStream(fileName); //this actually creates a file, unlike File
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(d);
            os.close();
        } catch (Exception e) {
        }
    }
    
    void deSerialize() {
        try {
            FileInputStream fi;
            ObjectInputStream is;
            fi = new FileInputStream(fileName);  //throws FileNotFoundException
            is = new ObjectInputStream(fi); //throws IOException
            Dog d = (Dog)is.readObject();
            System.out.println("Deserialized dog: " + d.a + " " + d.d + " " + d.x);
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
