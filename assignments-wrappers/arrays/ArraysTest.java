package arrays;

public class ArraysTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //arrays are objects
        int[] a = {3,4,5,6,7};
        System.out.println("Arrays are objects: " + a);
        
        int[][] b = {{1,23,4},{234,23,4,34,23}};
        System.out.println(b[0]); //returns a reference to an array
        System.out.println(b[1][1]);
//        System.out.println(b[1,1]); this is illegal

    }
    
    void testCopyConstructor() {
        Integer i = 2;
        Integer j = new Integer(i);
        
        A a = new A();
//        A b = new A(a);                          JAVA does not create a copy constructor by default
    }

    
}


class A {}
