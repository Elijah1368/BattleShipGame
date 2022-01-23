package Model.Cells;

import Model.AttackResult.AttackResult;

/**
 * Cell.java
 * Interface class that has the following methods.
 *
 * @Boolean placeShiponCell
 * @AttackResult attackCell
 */
public interface Cell {
    Boolean placeShipOnCell();
    AttackResult attackCell();
    boolean getIsHit();
}
