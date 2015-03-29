package com.agisoft.ikm;
/* 
  * ============================================================================ 
  * Name      : key.java
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


import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * 
 *
 */
public class key {

    /**
     * @param args
     * @throws NoSuchAlgorithmException 
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyFactory k = KeyFactory.getInstance("RSA");
        Provider p = k.getProvider();
        System.out.println(p);
    }

}
