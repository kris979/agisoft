/* 
  * ============================================================================ 
  * Name      : ReadersWriters.java
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
package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * 
 *
 */
public class ReadersWriters {

    static Logger logger = Logger.getLogger("ReadersWriters");
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        File dir = createDir("testDir");
        File file = createFile(dir, "test.txt");
        String msg = constructMessage();
        boolean successfull = writeMsgToFile(file, msg);
        String returnedMsg = readMsgFromFile(file);
        logger.info(msg);
        logger.info(returnedMsg);
        assert(msg.equals(returnedMsg)) : "messages are not the same!";
    }

    static File createDir(String dirName) {
        File dir = new File(dirName);
        if (dir.mkdirs()) {
            logger.info("Directory successfully created.");
            return dir;
        }
        else if (dir.exists()) {
            logger.info("Directory already exists");
            return dir;
        }
        return null;
    }
    
    static File createFile(File dir, String fileName) {
        File file = new File (dir, fileName);
        try {
            if (file.createNewFile()) {
                logger.info("File successfully created.");
            } else if (file.exists()){
                logger.info("File already exists");
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            logger.info(file.getAbsolutePath());
        }
        return null;
    }
    
    static String constructMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kris");
        sb.append("Bliszczak");
        return sb.toString();
    }
    
    static boolean writeMsgToFile(File file, String msg) {
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(msg);
            bw.flush();
            bw.close();
            return true;
        } catch (IOException e) {
            if (file.delete()) {
                logger.info("Write failed. File deleted.");
            }
            e.printStackTrace();
            return false;
        } finally {
        }

    }
    
    
    static String readMsgFromFile(File file) {
        FileReader fr;
        try {
            fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
