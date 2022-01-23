package Model.AttackResult;

/**
 * Hit is used when a ship has been hit
 */
public class Hit implements AttackResult {
    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode(){
        return 1234;
    }

    /**
     * equals() checks for equality between objects
     * @param o the object being checked
     * @return boolean the result of the checks
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "hit a ship!";
    }
}
