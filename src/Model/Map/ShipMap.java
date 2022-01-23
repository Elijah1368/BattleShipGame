package Model.Map;
import Model.Cells.Cell;
import View.Printer;
import Controller.MapFiller.MapFiller;
import Model.Ships.Ship;

import java.util.List;

/**
 * MapInteface.java
 * Interface class that has the following methods.
 *
 * void prettyPrint()
 * Cell getCell()
 * void placeCell()
 */
public interface ShipMap {
    public boolean isEmpty();
    void prettyPrint(Printer printer) throws Exception;
    Cell getCell(char column, int rows) throws Exception;
    Cell getCell(String rowColumn) throws Exception;
    void placeCell(Cell cell, char column, int row) throws Exception;
    void placeCell(Cell cell, String rowColumn) throws Exception;
    void placeShip(Ship ship, char column, int row, String direction) throws Exception;
    void removeShip() throws Exception;
    public void fillRandom(MapFiller mapFiller, List<Ship> ships) throws Exception;
    public void fill(MapFiller mapFiller, List<Ship> ships) throws Exception;
    public void placeShip(Ship ship, String coordinates, String direction) throws  Exception;
}
