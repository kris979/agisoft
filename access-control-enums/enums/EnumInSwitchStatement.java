package enums;

public class EnumInSwitchStatement {
    
    public EnumInSwitchStatement(Employee e) {
        switch (e) {
        case WORKER: System.out.println(e);
        default: System.out.println("default");
        case MANAGER: System.out.println(e);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new EnumInSwitchStatement(Employee.DIRECTOR);
    }

}
