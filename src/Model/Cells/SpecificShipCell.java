package Model.Cells;
import Model.AttackResult.AttackResult;
import Model.AttackResult.Hit;
import Model.AttackResult.Sunk;
import Model.Ships.Ship;


import java.util.Objects;

/**
 * Represents a SpecificShipCell
 */
public class SpecificShipCell extends AbstractShipCell {
    // constants
    public static final boolean INIT_NOT_HIT = false;
    // fields
    private Ship ship;

    /**
     * Given a Ship of a ship creates a SpecificShipCell
     *
     * @param ship type of ship
     */
    public SpecificShipCell(Ship ship) {
        super(INIT_NOT_HIT);
        this.ship = ship;
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
        ship.hitShip();
        isHit = true;
        if (ship.isSunk()) {
            this.markShipCellSunk();
            return new Sunk();
        } else {
            return new Hit();
        }
    }

    /**
     * This method returns isSunk as true
     */
    public void markShipCellSunk(){isSunk = true;}

    /**
     * Getter for property 'ship'.
     *
     * @return Value for property 'ship'.
     */
    public Ship getShip(){return ship;}

    /**
     * equals() checks for equality between objects
     * @param o the object being checked
     * @return boolean the result of the checks
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpecificShipCell that = (SpecificShipCell) o;
        return Objects.equals(ship, that.ship);
    }

    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode() {
        return super.hashCode() * 6;
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "SpecificShipCell{" +
                "ship=" + ship +
                ", isSunk=" + isSunk +
                ", isHit=" + isHit +
                '}';
    }
}

