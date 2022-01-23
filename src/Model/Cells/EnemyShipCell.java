package Model.Cells;
import Model.AttackResult.AttackResult;
import Model.AttackResult.Hit;
import Model.AttackResult.Sunk;

/**
 * Represents an EnemyShipCell
 */
public class EnemyShipCell extends AbstractShipCell {
    public static final boolean INIT_HIT = false;

    /**
     * EnemyShipCell constructor
     */
    public EnemyShipCell() {
        super(INIT_HIT);
    }

    /**
     * This method will return an AttackResult
     *
     * if isSunk
     * @return Sunk
     * otherwise it will
     * @return Hit
     */
    public AttackResult attackCell() {
        isHit = true;
        if (isSunk) {
            return new Sunk();
        } else {
            return new Hit();
        }
    }

    /**
     * This is a void method for markShipCellSunk
     */
    public void markShipCellSunk(){
        isSunk = true;
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
        return super.hashCode() * 3 ;
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "EnemyShipCell{" +
                "isSunk=" + isSunk +
                ", isHit=" + isHit +
                '}';
    }
}

