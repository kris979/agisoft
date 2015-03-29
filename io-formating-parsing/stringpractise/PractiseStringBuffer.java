package stringpractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class PractiseStringBuffer implements Serializable {
    private static final long serialVersionUID = 1L;

    StringBuilder sb = new StringBuilder("kris");
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    
    transient int x = 10; 
    
    void go() {
        sb.append(" ");
        sb.append("bliszczak agisoft").reverse().reverse();
        System.out.println(sb); // thre is no reference reassignment needed like with normal String

        sb1.append("test");
        sb2.append("test");

        String s = "kris";
        System.out.println(s.substring(1, 4));
        System.out.println(sb.substring(1, 4));
        if (s.substring(1, 4).equals(sb.substring(1, 4))) {
            System.out.println("eq");
        }

        if (sb1 == sb2) {
            System.out.println("sb==sb1");
        } else {
            System.out.printf("%s, %s not equal \n", sb1, sb2);
        }

        if (sb2.equals(sb1)) {
            System.out.println("sb equals sb1");
        } else {
            System.out.println("not equal");
        }
    }

    
    private void writeObject(ObjectOutputStream o) {
        try {
            o.defaultWriteObject();
            o.writeInt(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void readObject(ObjectInputStream o) {
        try {
            o.defaultReadObject();
            x = o.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        PractiseStringBuffer p = new PractiseStringBuffer();
        // p.go();

        System.out.printf("before: %s,%s,%d\n", p.sb,p.sb1,p.x);
        try {
            FileOutputStream os = new FileOutputStream("test.ser");
            ObjectOutputStream out = new ObjectOutputStream(os);
            out.writeObject(p);
        } catch (IOException e) {

        } finally {
            File f = new File("test.ser");
            System.out.printf("Serialized file exists: %b\n", f.exists());
            long timestamp = f.lastModified();
            Date d = new Date(timestamp);
            DateFormat df = DateFormat.getTimeInstance();
            System.out.printf("Serialized at: %s\n", df.format(d));
        }
        
        try {
            FileInputStream fin = new FileInputStream("test.ser");
            ObjectInputStream in = new ObjectInputStream(fin);
            p = (PractiseStringBuffer)in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("test.ser not found.");
        } catch (IOException e) {
            System.out.println("Can't read from the test.ser file");
        } catch (ClassNotFoundException e) {
            System.out.println("Serialized object is not " + PractiseStringBuffer.class.getCanonicalName());
            e.printStackTrace();
        }
        finally {
            Locale l = Locale.GERMAN;
            DateFormat df = DateFormat.getTimeInstance();
            System.out.println("Deserialized at: " + df.format(new Date()));
        }
        
        System.out.printf("after: %s,%s,%d\n", p.sb,p.sb1,p.x);

    }

}



/*
serialization again:
    
    import java.io.ObjectOutputStream;
    import java.io.ObjectInputStream;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    
    
    FileOutputStream fout = new FileOutputStream("file.ser"); //throws FileNotFoundException
    ObjectOutputStream out = new ObjectOutputStream(fout); //throws IOException
    out.writeObject(p);
    
    FileInputStream fin = new FileInputStream("file.ser");
    ObjectInputStream in = new ObjectInputStream(fin);
    p = (PractiseStringBuffer)in.readObject(); //throws ClassNotFoundException
    

*/