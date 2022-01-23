package Model.Cells;

import java.util.Objects;

/**
 * Abstract class for ship cells
 */
public abstract class AbstractShipCell extends AbstractCell implements ShipCell{
    protected Boolean isSunk;

    /**
     * Constructor for abstract cell
     * @param isSunk is a boolean that is true if the shp is sunk
     */
    public AbstractShipCell(Boolean isSunk) {
        super(false);
        this.isSunk = isSunk;
    }

    /**
     * Accessory method retrieves value of isSunk
     * @return isSunk
     */
    public Boolean getIsSunk(){return isSunk;}

    /**
     * Checks whether a ship can be placed on the cell
     * @return false
     */
    public Boolean placeShipOnCell(){return false;}

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
        AbstractShipCell that = (AbstractShipCell) o;
        return Objects.equals(isSunk, that.isSunk);
    }

    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), isSunk);
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "Cells.AbstractShipCell{" +
                "isSunk=" + isSunk +
                '}';
    }
}
