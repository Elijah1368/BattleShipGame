package Model.Map;

import Model.Cells.Cell;
import Model.Cells.GapWaterCell;
import Model.Cells.OpenSeaWaterCell;
import Model.Cells.SpecificShipCell;
import View.Printer;
import Controller.MapFiller.MapFiller;
import Controller.MapFiller.ShipMapFiller;
import Model.Ships.Ship;

import java.util.*;

/**
 * This class creates a map
 */
public class BattleShipMap implements ShipMap {
    private Stack<List<String>> shipCellsLocation;
    private final static int INDEX_DIFFERENCE = 97;
    private final static int CELL_DIMENSIONS = 10;
    //fields
    private Cell[][] map;
    private MapFiller shipMapFiller;

    /**
     * Constructor for the Map
     */
    public BattleShipMap(){
        shipCellsLocation = new Stack<List<String>>();
        map = new Cell[CELL_DIMENSIONS][CELL_DIMENSIONS ];
        for(int i = 0; i < CELL_DIMENSIONS ; i++){
            for(int j = 0; j < CELL_DIMENSIONS; j++){
                map[i][j] = new OpenSeaWaterCell();
            }
        }
        shipMapFiller = new ShipMapFiller(this);
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
        BattleShipMap map1 = (BattleShipMap) o;
        return Arrays.deepEquals(map, map1.map);
    }

    /**
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(map);
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "Map{" +
                "map=" + Arrays.deepToString(map) +
                '}';
    }

    /**
     * prettyPrint() calls toConsole() on a ConsolePrinter object
     * @param printer the object having toConsole called on
     * @throws Exception for the getCell method if the entered parameter is invalid data
     */
    public void prettyPrint(Printer printer) throws Exception {
        printer.printMap(this);
    }

    /**
     * getCell() retrieves the cell from the map arrays
     * @param column the character for the columns
     * @param rows the integer for the rows
     * @return Cell
     * @throws Exception for if the entered parameter is invalid data
     */
    public Cell getCell(char column, int rows)throws Exception {

        int iColumn = Character.toLowerCase(column) - INDEX_DIFFERENCE;
        checkIfValid((char)column, rows);


        return map[rows-1][iColumn];
    }

    public static void checkIfValid(char column, int row) throws Exception {

        column = Character.toLowerCase(column);

        if(!Character.isLetter(column)) throw new IllegalAccessException("First character must be a letter!");

        if (column > CELL_DIMENSIONS + 96 || column < 97) throw new IllegalAccessException("COLUMN MUST BE A TO J");

        if (row > CELL_DIMENSIONS || row < 1) throw new IllegalAccessException("Row must not exceed " + CELL_DIMENSIONS);

    }

    public static int getProperRowFormat(String input){
        if(input.length() > 3) throw new IllegalArgumentException("Enter two character, a column and a row");

        int iRow = 0;

        try {
            iRow = Integer.parseInt(input.substring(1));
            if(iRow > 10 || iRow < 1) throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException("Row must be a number between 1 to 10");
        }

        return iRow;
    }
    /**
     * getCell() retrieves the cell from the map arrays
     * @param rowColumn the String for the row and column
     * @return Cell
     * @throws Exception for if the entered parameter is invalid data
     */
    public Cell getCell(String rowColumn) throws Exception {

        int iRow = getProperRowFormat(rowColumn);

        Cell cell = getCell(Character.toLowerCase(rowColumn.charAt(0)), iRow);

        return  cell;
    }


    /**
     * placeCell() places a cell in the map
     * @param cell the cell being placed
     * @param column the column being placed at
     * @param row the row being placed at
     */
    public void placeCell(Cell cell, char column, int row) throws Exception{
        String rowColumn = column + "" + row;

        int iColumn = Character.toLowerCase(column) - INDEX_DIFFERENCE;

        checkIfValid(column, row);
       // System.out.println(row);
        map[row-1][iColumn] = cell;
    }

    /**
     * placeCell() places a cell in the map
     * @param cell the cell being placed
     * @param rowColumn the String representing the row and column being placed at
     * @throws Exception for if the entered parameter is invalid data
     */
    public void placeCell(Cell cell, String rowColumn) throws Exception {

        int iRow = getProperRowFormat(rowColumn);

        placeCell(cell, Character.toLowerCase(rowColumn.charAt(0)), iRow);

    }

    private void placeGapCellVertical(Ship ship, char column, int row, String direction, List<String> cellLocation) throws  Exception {
        int increment = direction.equals("up") ? -1 : 1;

        //place sideways
        for (int i = 0; i < 3; i++) {

            int horizontal = column - 1 + i;

            if ((horizontal >= 97 && horizontal <= 106) && (row + ship.getSize() * increment >= 1 && row + ship.getSize() * increment <= 10)) {
                placeCell(new GapWaterCell(), (char) (horizontal), row + ship.getSize() * increment);
                cellLocation.add((char) (horizontal) + "" + (row + ship.getSize() * increment));
            }

            if ((horizontal >= 97 && horizontal <= 106) && (row - increment >= 1 && row - increment <= 10)) {
                placeCell(new GapWaterCell(), (char) (horizontal), row - increment);
                cellLocation.add((char) (horizontal) + "" + (row - increment));
            }


        }

        //place up
        for (int i  =0; i<ship.getSize (); i++){
            if (column - 1 >= 97 && (row + i * increment >= 1 && row + i * increment <= 10)) {
                placeCell(new GapWaterCell(), (char) (column - 1), row + i * increment);
                cellLocation.add((char) (column - 1) + "" + (row + i * increment)); }

            if (column + 1 <= 106 && (row + i * increment >= 1 && row + i * increment <= 10)) {
                placeCell(new GapWaterCell(), (char) (column + 1), row + i * increment);
                cellLocation.add((char) (column + 1) + "" + (row + i * increment));
            }
        }

    }


    private void placeGapCellHorizontal(Ship ship, char column, int row, String direction, List<String> cellLocation) throws  Exception{

        int increment = direction.equals("right") ? 1 : -1;

        //place side
        for (int i = 0; i < 3; i++) {
            int wall = row - 1 + i;
            if ((wall >= 1 && wall <= 10) && (column + ship.getSize() * increment >= 97 && column + ship.getSize() * increment <= 106)) {
                placeCell(new GapWaterCell(), (char) (column + ship.getSize() * increment), row - 1 + i);
            }
            if ((wall >= 1 && wall <= 10) && (column - increment >= 97 && column - increment <= 106)) {
                placeCell(new GapWaterCell(), (char) (column - increment), row - 1 + i);
                }
        }

        //place up
        for (int i = 0; i < ship.getSize(); i++) {
            if (row + 1 <= 10 && (column + i * increment >= 97 && column + i * increment >= 10)) {
                placeCell(new GapWaterCell(), (char) (column + i * increment), row + 1);
                }
                if (row - 1 >= 1 && (column + i * increment >= 97 && column + i * increment >= 10)) {
                placeCell(new GapWaterCell(), (char) (column + i * increment), row - 1);
                }
        }

    }

    public void placeShip(Ship ship, String coordinates, String direction) throws  Exception {

        char column = coordinates.charAt(0);

        int row = getProperRowFormat(coordinates);

        placeShip(ship, column, row, direction);
    }

    public void placeShip(Ship ship, char column, int row, String direction) throws Exception{

        column = Character.toLowerCase(column);
        List<String> cellLocation = new ArrayList<String>();
        direction = direction.replaceAll(" ", "");

        if(Character.isLetter(column)){
            if(column < 97 || column > 106 || row < 1 || row > 10) throw new IllegalArgumentException("Column must be a to j and row must be 1 to 10");
        } else {
            throw new IllegalArgumentException("Column must be a letter");
        }

        if(direction.equalsIgnoreCase("up") || direction.equalsIgnoreCase("down")){
            if(!shipMapFiller.isSafeVertical(column, row, direction, ship)) throw new IllegalArgumentException("Not allowed to place ship here");
            int increment = direction.equals("up") ? -1 : 1;
            placeGapCellVertical(ship, column, row, direction, cellLocation);
            for(int i = 0; i < ship.getSize(); i++){
              placeCell(new SpecificShipCell(ship), column, row + i * increment);
              cellLocation.add(column + "" + (row + i * increment));
            }

        } else if (direction.equalsIgnoreCase("right") || direction.equalsIgnoreCase("left")) {
            if(!shipMapFiller.isSafeHorizontal(column, row, direction, ship)) throw new IllegalArgumentException("Not allowed to place ship here");
            int increment = direction.equals("right") ? 1 : -1;
            placeGapCellHorizontal(ship, column, row, direction, cellLocation);
            for(int i = 0; i < ship.getSize(); i++){
                placeCell(new SpecificShipCell(ship), (char)(column + i * increment), row);
                cellLocation.add((char)(column + i * increment) + "" + row);
            }
        } else {
            throw new IllegalArgumentException("Direction must be up, left, right, down.");
        }

        shipCellsLocation.push(cellLocation);
    }

    public boolean isEmpty(){
        return shipCellsLocation.isEmpty();
    }

    public void removeShip() throws Exception{
        if(shipCellsLocation.peek() == null) throw new IllegalStateException();
        List<String> cellLocation = shipCellsLocation.pop();
        for(String location: cellLocation){
            placeCell(new OpenSeaWaterCell(), location);
        }
    }

    public void fillRandom(MapFiller mapFiller, List<Ship> ships) throws Exception {
        mapFiller.placeRandomShipCells(this, ships);
    }

    public void fill(MapFiller mapFiller, List<Ship> ships) throws Exception {
        mapFiller.placeShipCells(this, ships);
    }

}
