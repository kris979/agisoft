package enums;

enum Enum1 {MONDAY, TUESDAY, WEDNESDAY};


enum CoffeSize { 
    SMALL("S"), 
    MEDIUM("M"), 
    LARGE("L");
    
    private String size;

    CoffeSize(String s) {
        size = s;
    }
    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

public class PractiseEnums {

    enum Size {XS,S,M,L,XL,X23};
    
    Size tshitSize = Size.X23;
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        compareEnums();
        
        for (Enum1 e : Enum1.values()) {
            System.out.println(e);
        }
        
        System.out.println("===================================");
        
        for (CoffeSize s : CoffeSize.values()) {
            System.out.println(s + ":" + s.getSize());
        }
        
        CoffeSize size = CoffeSize.LARGE;
        System.out.println(size.getSize());
        
        System.out.println("===================================");
        
        PractiseEnums e = new PractiseEnums();
        e.tshitSize = PractiseEnums.Size.L;
        System.out.println(e.tshitSize);  
    }
    
    static void compareEnums() {
        if (Size.XL == Size.XL) {
            System.out.println("XL == XL");
        }
        
        if (Size.XL.equals(Size.XL)) {
            System.out.println("EQUALS");
        }
        
        if (CoffeSize.LARGE.equals(Size.L)) {
            System.out.println("same");
        }
    }

}
