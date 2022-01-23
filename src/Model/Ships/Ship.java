package Model.Ships;

/**
 * Ship.java
 * Interface class that has the following methods
 * void hitShip()
 * boolean isSunk()
 */
public interface Ship {
    void hitShip();
    boolean isSunk();
    int getSize();
}
