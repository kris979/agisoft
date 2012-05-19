/* 
 * ============================================================================ 
 * Name      : AbstractParsedItem.java
 * ============================================================================
 */
package kataIV;

/**
 * 
 *
 */
public abstract class AbstractParsedItem {

    protected String name;
    protected int max;
    protected int min;
    protected int difference;

    /**
     * @param name
     * @param max
     * @param min
     * @param difference
     */
    public AbstractParsedItem(String name, int max, int min) {
        super();
        this.name = name;
        this.max = max;
        this.min = min;
        this.difference = Math.abs(max - min);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + difference;
        result = prime * result + max;
        result = prime * result + min;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractParsedItem)) {
            return false;
        }
        AbstractParsedItem other = (AbstractParsedItem) obj;
        if (difference != other.difference) {
            return false;
        }
        if (max != other.max) {
            return false;
        }
        if (min != other.min) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public int getDifference() {
        return difference;
    }


}