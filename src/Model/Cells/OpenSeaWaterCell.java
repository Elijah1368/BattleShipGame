package Model.Cells;

/**
 * Represents an OpenSeaWaterCell
 */
public class OpenSeaWaterCell extends AbstractWaterCell{

    /**
     * This method returns a Boolean true when called
     * @return true
     */
    public Boolean placeShipOnCell(){
        return true;
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
        return super.hashCode() * 5;
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "OpenSeaWaterCell{" +
                "isHit=" + isHit +
                '}';
    }
}
