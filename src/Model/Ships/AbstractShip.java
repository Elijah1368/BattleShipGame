package Model.Ships;

import java.util.Objects;

/**
 * Abstract class for ships
 */
public abstract class AbstractShip implements Ship{
    private static final int ZERO_HIT_CELLS = 0;
    private Integer size;
    private Integer numOfHitCells;

    /**
     * Constructor for the abstract class
     * @param size the size of the ship
     */
    public AbstractShip(Integer size){
        this.size = size;
        numOfHitCells = ZERO_HIT_CELLS;
    }


    /**
     * Constructor for the abstract class
     * @param size the size of the ship
     * @param numOfHitCells the number of cells that can be hit
     */
    public AbstractShip(Integer size, Integer numOfHitCells){
        this.size = size;
        this.numOfHitCells = numOfHitCells;
    }

    /**
     * hitShip() hits the ship
     */
    public void hitShip(){
        if (size.equals(numOfHitCells)) return;
        numOfHitCells += 1;
    }

    /**
     * isSunk() checks if ship is sunk
     * @return boolean value of the check
     */
    public boolean isSunk(){
        if(size.equals(numOfHitCells)) return true;
        return false;
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
        AbstractShip that = (AbstractShip) o;
        return Objects.equals(size, that.size) &&
                Objects.equals(numOfHitCells, that.numOfHitCells);
    }

    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(size, numOfHitCells);
    }

    public int getSize(){
        return size;
    }
    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "size=" + size +
                ", numOfHitCells=" + numOfHitCells +
                '}';
    }
}
