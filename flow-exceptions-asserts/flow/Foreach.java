package flow;
public class Foreach {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [][] multi = new int[2][5];
        Integer[][] multi2 = new Integer[2][5];
        
        for (int[] is : multi) {
            System.out.println(is);
        }
        
        for (Object is : multi) {
            System.out.println(is);
            
        }

        for (Integer[] is : multi2) {
            System.out.println(is);
        }
        
        for (Object is : multi2) {
            System.out.println(is);
        }
        
        for (Integer is : multi[0]) {
            System.out.println(is);
        }
        
        for (int is : multi[0]) {
            System.out.println(is);
        }
    }
    
    void testForScope() {
        int i = 0;
        for(int j=0,k=0; j < 10; j++) {
//            for(int i=0; i < 10; i++) {                    //as expected this is a compilation failure
//                for(int j=0; j < 10; j++) {                // as duplicates variables are not allowed
//                    
//                }
//            }
        }
        
        for(int j=0; j<10; j++) {                           //it is ok to use j again as it is different scope
        }
        
//        for(int j=0,int k=0; j < 10; j++) {               // int in declaration should be used only once
//        }
    }

}
