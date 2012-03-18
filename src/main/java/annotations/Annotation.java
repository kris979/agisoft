/* 
  * ============================================================================ 
  * Name      : Annotation.java
  * ============================================================================
  */
package annotations;

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

@CreatedBy("agisoft")
public class Annotation {

    @Author(name="Kris",company="Agisoft")
    public static void main(String[] args) {

    }

}
