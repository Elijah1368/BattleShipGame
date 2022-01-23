package Model.Ships;

/**
 * Represents a destroyer
 */
public class Destroyer extends AbstractShip{

    private static final int SIZE = 1;

    /**
     * Constructor for the Destroyer class
     */
    public Destroyer(){
        super(new Integer(SIZE));
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
        return "Destroyer{" + super.toString();
    }
}
