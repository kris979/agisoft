/* 
  * ============================================================================ 
  * Name      : PractiseSerialization4.java
  * Part of     :  NEON
  * 
  * Copyright (c) 2007-2011 Nokia.  All rights reserved.
  * This material, including documentation and any related computer
  * programs, is protected by copyright controlled by Nokia.  All
  * rights are reserved.  Copying, including reproducing, storing,
  * adapting or translating, any or all of this material requires the
  * prior written consent of Nokia.  This material also contains
  * confidential information which may not be disclosed to others
  * without the prior written consent of Nokia.
 * 
  * ============================================================================
  */
package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Collar implements Serializable {
    private static final long serialVersionUID = -6962869161129684770L;
    int size = 5;
    
    public Collar(int s) {
        this.size = s; 
    }
    
    public Collar() {
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Collar))
            return false;
        Collar other = (Collar) obj;
        if (size != other.size)
            return false;
        return true;
    }

}

class Kitten implements Serializable {
    private static final long serialVersionUID = -1707343982260902251L;
    static int hmmm = 10;
    String name;
    Collar collar;
    
    public Kitten(String name, Collar collar) {
        this.name = name;
        this.collar = collar;
    }

//    private void writeObject(ObjectOutputStream os) {
//        try {
//            os.defaultWriteObject();
//            os.writeInt(collar.size);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    private void readObject(ObjectInputStream is) {
//        try {
//            is.defaultReadObject();
//            int size = is.readInt();
//            this.collar = new Collar(size);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Kitten))
            return false;
        Kitten other = (Kitten) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
}

public class PractiseSerialization4 {

    /**
     * @param args
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Collar c = new Collar(1);
        Kitten k = new Kitten("Alfred", c);
        
        System.out.println(k.hmmm);
         
        File file = new File("kitten.ser");
        FileOutputStream out = new FileOutputStream(file); //throws FileNotFoundException which is a subclass of IOException
        ObjectOutputStream os = new ObjectOutputStream(out); //throws IOException
        os.writeObject(k);
        
        Kitten.hmmm = 5;
        
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream is = new ObjectInputStream(in);
        Kitten deserializedKitten = (Kitten)is.readObject();   //throws ClassNotFoundException
        

        System.out.println(deserializedKitten.hmmm);
        
        if (k.equals(deserializedKitten)) {
            System.out.println("Bravo!");
        } else {
            System.out.println("Dupa!");
            System.out.println("before: " + k.name + " " + k.collar.size);
            System.out.print("after: " + deserializedKitten.name + " ");
            System.out.println(deserializedKitten.collar.size);
        }
    }
}
