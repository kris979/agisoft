/* 
  * ============================================================================ 
  * Name      : Contract.java
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
package com.agisoft.collections.contract;

import java.util.HashMap;
import java.util.Map;

class Chilli {

    private int hotness;
    private String color;
        
    public Chilli(int hotness, String color) {
        super();
        this.hotness = hotness;
        this.color = color;
    }
    
    public String toString() {
        return color + ":" + hotness;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + hotness;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Chilli)) {
            return false;
        }
        Chilli other = (Chilli) obj;
        if (color == null) {
            if (other.color != null) {
                return false;
            }
        } else if (!color.equals(other.color)) {
            return false;
        }
        if (hotness != other.hotness) {
            return false;
        }
        return true;
    }
    
}
/**
 * 
 *
 */
public class Contract {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Chilli red = new Chilli(1, "red");
        Chilli green = new Chilli(3, "green");
        
        Map<Chilli, String> chillis = new HashMap<Chilli,String>();
        chillis.put(red, "red");
        chillis.put(green, "green");
        System.out.println(chillis);
        
        Chilli retrieve = new Chilli(1, "red");
        String name = chillis.get(retrieve);
        System.out.println("retrieved: " + name);
    }

}
