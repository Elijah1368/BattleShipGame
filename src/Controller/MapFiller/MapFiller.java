package Controller.MapFiller;

import Model.Map.ShipMap;
import Model.Ships.Ship;

import java.util.List;

/**
 * Contract in order to be considered a mapfiller
 */
public interface MapFiller {
    //Must be able to randomly place ships on the map
    void placeRandomShipCells(ShipMap map, List<Ship> ships) throws Exception;

    //Must be able to place ships given the user input on the map
    void placeShipCells(ShipMap map, List<Ship> ships) throws Exception;

    //Must be able to tell if it's safe to place ship up or down
    boolean isSafeVertical(char column, int row, String direction, Ship ship) throws Exception;

    //Must be able to tell if it's safe to place ship left or right
    boolean isSafeHorizontal(char column, int row, String direction, Ship ship) throws Exception;
}
