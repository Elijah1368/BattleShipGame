package Model.Ships;

/**
 * Represents a cruiser
 */
public class Cruiser extends AbstractShip {

    private static final int SIZE = 3;

    /**
     * Constructor for the Cruiser class
     */
    public Cruiser(){
        super(SIZE);
    }

    /**
     * equals() checks for equality between objects
     * @param o the object being checked
     * @return boolean the result of the checks
     */
    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode(){
        return super.hashCode();
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "Cruiser{" + super.toString();
    }

}
