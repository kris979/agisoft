/* 
  * ============================================================================ 
  * Name      : PractiseStringComparison.java
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
package stringpractise;

public class PractiseStringComparison {

    void compareStringBuffer() {
        String s = "hello";
        String s1 = new String("hello");
        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("hello");
        StringBuilder sbuilder = new StringBuilder("hello");
        
        System.out.println(s==s1);                   //false - comparing literal to an object reference
        System.out.println(s.toString() == s1.toString()); //it returns this which means it will return litreal or an string object
        System.out.println(sb1 == sb2);             // false - different references 
        System.out.println(s.equals(s1));           // true - meaningfully equal
        System.out.println(s.equals(sb1));          // false - as isinstaceof fails
        System.out.println(s.equals(sbuilder));     // false - as above
        System.out.println(sb1.equals(sbuilder));   // false - dont override equls and default equals compares references
        System.out.println(sb1.equals(sb2));        // false - as above
        System.out.println(sbuilder.equals(sb1));   // failse - StringBuilder doesn't override equals  
        
    }
    
    void compareStrings() {
        String strings[] = new String[1];
        strings[0] = new String("hello");
        String a = "hello";
        String a1 = "hello";
        String b = new String("hello");
        String c = new String("hello");
        String c1 = new String(a);
        String d = a;
        String e = b;
        System.out.println(strings[0] == "hello");  //false
        System.out.println(a == a1); //true because when you construct a string from the same string literal without using new then Java creates only one string object.
        System.out.println(a == b); //false because those are diffrent objects
        System.out.println(b==c);   //false becasue those are different objects
        System.out.println(e == b); //true as e is a reference to object b
        System.out.println(c==c1); //false because those are different objects
        System.out.println(b.equals(c));  // true as strings are meaningfully equal and String class overrides equals() method
        System.out.println(a == "hello"); //true because if we dont use new JAVA points to the same literal string
        System.out.println(b == "hello"); //false
        System.out.println(d==a);
    }
    
    public static void main(String[] args) {
        new PractiseStringComparison().compareStringBuffer();
//        new PractiseStringComparison().compareStrings();
    }

}
