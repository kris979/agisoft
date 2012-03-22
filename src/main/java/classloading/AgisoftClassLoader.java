/* 
  * ============================================================================ 
  * Name      : AgisoftClassLoader.java
  * ============================================================================
  */
package classloading;


class Kris {
    
}

/**
 * 
 *
 */
public class AgisoftClassLoader extends ClassLoader {
    
    public AgisoftClassLoader() {
        super(AgisoftClassLoader.class.getClassLoader());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println(AgisoftClassLoader.class.getSimpleName() + " is looking for a class " + name);
        return null;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
       
        AgisoftClassLoader myClassLoader = new AgisoftClassLoader();
        myClassLoader.loadClass("java.lang.String");
        myClassLoader.loadClass("memory.MemoryGenerations");
    }
}
