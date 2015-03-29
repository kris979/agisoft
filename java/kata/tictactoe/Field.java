/* 
  * ============================================================================ 
  * Name      : Field.java
  * ============================================================================
  */
package kata.tictactoe;

/**
 * 
 *
 */
public class Field {

    private int id;
    private boolean isTaken = false;

    /**
     * @param i
     */
    public Field(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public boolean isTaken() {
        return isTaken;
    }

    /**
     * @param isTaken the isTaken to set
     */
    public void setTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Field [id=" + id + ", isTaken=" + isTaken + "]";
    }

}
