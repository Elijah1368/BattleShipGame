package Model.Cells;
import java.util.Objects;

/**
 * Abstract class for cells
 */
public abstract class AbstractCell implements Cell {
    protected Boolean isHit;

    /**
     * Constructor for abstract cell
     * @param isHit is a boolean that is true if the cell is hit
     */
    public AbstractCell(Boolean isHit) {
        this.isHit = isHit;
    }

    /**
     * Accessory method
     * @return isHit
     */
    public boolean getIsHit(){return isHit;};

    /**
     * equals() checks for equality between objects
     * @param o the object being checked
     * @return boolean the result of the checks
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCell that = (AbstractCell) o;
        return Objects.equals(isHit, that.isHit);
    }

    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(isHit);
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "Cells.AbstractCell{" +
                "isHit=" + isHit +
                '}';
    }
}
