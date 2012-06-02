/* 
  * ============================================================================ 
  * Name      : Player.java
  * ============================================================================
  */
package kata.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Player {
    
    private String name;
    private List<Field> fields = new ArrayList<Field>();
    
    /**
     * @param name
     */
    
    public Player(String name) {
        super();
        this.name = name;
    }


    /**
     * @param field
     * @return 
     */
    public boolean take(Field field) {
        return fields.add(field);
    }

    /**
     * @return
     */
    public int totalNumberOfFieldsTaken() {
        return fields.size();
    }

    /**
     * @return
     */
    public boolean hasTakenColumn() {
        int fieldsTakenInColumn1 = 0;
        int fieldsTakenInColumn2 = 0;
        int fieldsTakenInColumn3 = 0;
        for (Field field : fields) {
            int id = field.getId();
            switch(id){
            case 1:
            case 4:
            case 7: fieldsTakenInColumn1++; break;
            case 2:
            case 5:
            case 8: fieldsTakenInColumn2++; break;
            case 3:
            case 6:
            case 9: fieldsTakenInColumn3++; break;
            }
        }
        if (fieldsTakenInColumn1 >= 3 || fieldsTakenInColumn2 >= 3 || fieldsTakenInColumn3 >= 3) {
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    public boolean hasTakenRow() {
        int fieldsTakenInRow1 = 0;
        int fieldsTakenInRow2 = 0;
        int fieldsTakenInRow3 = 0;
        for (Field field : fields) {
            int id = field.getId();
            switch(id){
            case 1:
            case 2:
            case 3: fieldsTakenInRow1++; break;
            case 4:
            case 5:
            case 6: fieldsTakenInRow2++; break;
            case 7:
            case 8:
            case 9: fieldsTakenInRow3++; break;
            }
        }
        if (fieldsTakenInRow1 >= 3 || fieldsTakenInRow2 >= 3 || fieldsTakenInRow3 >= 3) {
            return true;
        }
        return false;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
