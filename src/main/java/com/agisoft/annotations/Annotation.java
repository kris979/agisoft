/* 
 * ============================================================================ 
 * Name      : Annotation.java
 * ============================================================================
 */
package com.agisoft.annotations;

/* 
 * Annotations provide data about data.
 * 
 * Can be used to:
 * 
 *  - provide information to the compiler: can be used by compiler to detect errors or supress warnings
 *  
 *  - compiler time and deployment time processing: some tools can process annotations to generate code etc.
 *  
 *  - runtime processing: can be examined at runtime
 */

/**
 * 
 *
 */
@Author(name = "Kris", company = "Agisoft")
public class Annotation {

    @Author(name = "Kris", company = "Agisoft")
    public static void main(String[] args) {
        System.out.println(".");
    }

    /**
     * @deprecated annotation indicates that the marked element is deprecated and should no longer be used. The compiler
     *             generates a warning whenever a program uses a method, class, or field with the @Deprecated
     *             annotation. When an element is deprecated, it should also be documented using the Javadoc @deprecated
     *             tag, as shown in the following example. The use of the "@" symbol in both Javadoc comments and in
     *             annotations is not coincidental — they are related conceptually. Also, note that the Javadoc tag
     *             starts with a lowercase "d" and the annotation starts with an uppercase "D".
     */
    @Deprecated
    public void deprecatedMethod() {

    }

    /**
     * annotation tells the compiler to suppress specific warnings that it would otherwise generate. In the example
     * below, a deprecated method is used and the compiler would normally generate a warning. In this case, however, the
     * annotation causes the warning to be suppressed.
     */
    public void suppressedWarning() {
        deprecatedMethod();
    }

    /**
     * annotation informs the compiler that the element is meant to override an element declared in a superclass 
     * @see java.lang.Object#hashCode() 
     */
    @Override
    public int hashCode() {
        return 0;
    }
}
