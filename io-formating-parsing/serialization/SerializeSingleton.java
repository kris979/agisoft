/* 
  * ============================================================================ 
  * Name      : SerializeSingleton.java
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
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * 
 *
 */
public class SerializeSingleton implements Serializable {
    
    private static SerializeSingleton instance;
    private transient int x;
    private transient String y;
    
    private SerializeSingleton() {
        System.out.println("Constructor");
        x = 12;
        y = "bb";
    }
    
    public static SerializeSingleton getInstanceeeee() {
        if (instance == null) {
            instance = new SerializeSingleton();
        }
        return instance;
    }

    @Override
    public String toString() {
        String isNull = this.instance == null ? "null" : "not-null";
        return "SerializeSingleton [x=" + x + ", y=" + y + ", instance=" + isNull + "]";
    }
    
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    /**
     * @param args
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeSingleton singleton = SerializeSingleton.getInstanceeeee();
        
        System.out.println(singleton);
        System.out.println("Serializing");
        File f = new File("singleton.ser");
        OutputStream os = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(singleton);
        System.out.println("Deserializing");
        InputStream is = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(is);
        SerializeSingleton singleton1 = (SerializeSingleton)ois.readObject();
        System.out.println(singleton1);
        
        singleton.x = 10;
        System.out.println("Singleton equals s1:" + singleton.equals(singleton1));
        
        boolean deleted = f.delete();
        System.out.println("deleted: " + deleted);
    }

}
