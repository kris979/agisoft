package com.agisoft.ikm;
/* 
  * ============================================================================ 
  * Name      : FileIO.java
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


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Reader;

/**
 * 
 *
 */
public class FileIO {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        String f="file1.java";

        File f1 = new File(f) ;
        
        //Reader is an abstract class
        Reader iout1 = new FileReader(f1);
        
        FileOutputStream iout2 = new FileOutputStream(f1);
        
        RandomAccessFile rf = new RandomAccessFile(f1, "rw");

        
        //InputStream is an abstract class
//        InputStream iout3 = new InputStream(f1);
        
        InputStream iout4 = new FileInputStream(f1);
    }

}




