/* 
  * ============================================================================ 
  * Name      : StackMax.java
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
package google;

/**
 * 
 *
 */
public class StackMax {

    int[] data  = new int[100]; // 4 -3     // -3 4           // -1 -2   
    int[] max   = new int[100]; // 4  4     //  4 -           // -1 -1
    int index = -1;
    int total_max_value = Integer.MIN_VALUE;
    
    void push(int elem) {
        index+=1;
        data[index] = elem;
        if (elem > total_max_value) {
            total_max_value = elem;
        }
        max[index] = total_max_value;
    }
    
    void pop() {
        if (! isEmpty()) {
            index-=1;
            if (index >= 0) {
                total_max_value = max[index];
            } else {
                total_max_value = Integer.MIN_VALUE;
            }
        }
    }
    
    int top() {
        if (index >= 0)
            return data[index];
        else
            return Integer.MIN_VALUE;
    }
    
    int max() {
        return total_max_value;
    }
    
    
    boolean isEmpty() {
       return index < 0; 
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        StackMax max = new StackMax();
        max.push(4);
        System.out.println(max.max() + " push " + max.top());
        max.push(3);
        System.out.println(max.max() + " push  " + max.top());
        max.pop();
        System.out.println(max.max() + " pop  " + max.top());
        max.pop();
        System.out.println(max.max() + " pop  " + max.top());
        System.out.println("=================================");
        max.push(-4);
        System.out.println(max.max() + " push " + max.top());
        max.push(-3);
        System.out.println(max.max() + " push " + max.top());
        max.pop();
        System.out.println(max.max() + " pop  " + max.top());
        max.pop();
        System.out.println(max.max() + " pop  " + max.top());
        
    }

}
