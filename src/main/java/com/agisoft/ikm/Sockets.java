package com.agisoft.ikm;
/* 
 * ============================================================================ 
 * Name      : Sockets.java
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


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 *
 */
public class Sockets {

    public static void main(String[] args) {

//        for (int i = 1; i < 100; i++) {
//            try {
//                System.out.print(".");
//                Socket s = new Socket("localhost", i);
//                System.out.println("An Application is running on port number " + i);
//
//            } catch (UnknownHostException ex) {
//                break;
//            } catch (IOException ex) {
//            }
//        }
        
        
        try {
            InetAddress theAddress = InetAddress.getByName("localhost");
            for (int i = 1; ;i++) {
                Socket s = new Socket(theAddress, i);
                System.out.println("An Application is running on port number " + i );
            }
       }catch (UnknownHostException e) {
           System.out.println(e);
       }catch (IOException e) {
           System.out.println(e);
       } 
    }
}
