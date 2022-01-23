package Model.Cells;

/**
 * Represents a GapWaterCell
 */
public class GapWaterCell extends AbstractWaterCell{

    /**
     * This method returns a Boolean false when called
     * @return false
     */
    public Boolean placeShipOnCell(){
        return false;
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
        return super.hashCode() * 4;
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "GapWaterCell{" +
                "isHit=" + isHit +
                '}';
    }
}
