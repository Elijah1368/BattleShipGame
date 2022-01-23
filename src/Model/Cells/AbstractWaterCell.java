package Model.Cells;
import Model.AttackResult.AttackResult;
import Model.AttackResult.Miss;

/**
 * Abstract class for water cells
 */
public abstract class AbstractWaterCell extends AbstractCell implements WaterCell{
    public static final boolean INIT_NOT_HIT = false;

    /**
     * Constructor for the abstract class
     */
    public AbstractWaterCell() {
        super(false);
    }

    /**
     * attacks the cell
     * @return Miss()
     */
    public AttackResult attackCell(){
        isHit = true;
        return new Miss();
    }

    /**
     * equals() checks for equality between objects
     * @param o the object being checked
     * @return boolean the result of the checks
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "AbstractWaterCell{" +
                "isHit=" + isHit +
                '}';
    }
}
