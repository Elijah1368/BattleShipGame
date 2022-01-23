package Controller.MapFiller;

import Model.Cells.OpenSeaWaterCell;
import Model.Cells.SpecificShipCell;
import View.BattleMapPrinter;
import View.*;
import Model.Map.BattleShipMap;
import Model.Map.ShipMap;
import Model.Ships.Ship;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * An objects that fills a map with ships
 */
public class ShipMapFiller implements  MapFiller {
    ShipMap battleMap; //map
    List<Ship> ships; //ships to fill the map with
    Scanner console; //to read user input
    int index; //keep track which ship it's at

    /**
     * Creates a shipmapfiller
     * @param battleMap a battleMap that can be filled with  ships
     */
    public ShipMapFiller(ShipMap battleMap){
        this.battleMap = battleMap;
    }

    /**
     * Empty constructor
     */
    public ShipMapFiller(){
    }

    /**
     * Randomly places the map with the given ships
     * @param map the batllemap to be filled with
     * @param ships the ships to fill the map with
     * @throws Exception
     */
    public void placeRandomShipCells(ShipMap map, List<Ship> ships) throws Exception {
        this.battleMap = map;
        this.ships = ships;
        Random rand =  new Random();

        //randomColumn to start putting the ships on
        int randomColumn = rand.nextInt(10) + 97;

        //recursive method that uses recursive backtracking to fill map with ships
        randomShips((char)(randomColumn), ships, 0);
    }

    /**
     * Asks user for coordinates then places the ships
     * @param map the map to be filled with
     * @param ships the ships to fill the map with
     * @throws Exception
     */
    public void placeShipCells(ShipMap map, List<Ship> ships) throws Exception{
        this.battleMap = map;
        this.ships = ships;
        console = new Scanner(System.in);
        index = 0;

        Printer shipPrinter = new BattleMapPrinter();

        //Will keep asking for coordinates until all ships are placed
        while(index < ships.size()) {
            battleMap.prettyPrint(shipPrinter);
            String input = chooseShips(shipPrinter);

            int shipNo = Integer.parseInt(input) + index;
            index++;

            //will keep asking for coordinates if wrong input
            while(true) {
                System.out.print("Type in coordinates and direction (up, left, down, right) separated by a space: ");
                String coordinates = console.next();
                String directions = console.next();
                if(checkIfProper(coordinates, directions, shipNo)) break;
            }

            System.out.println();

        }
    }

    /**
     * Checks if the given coordinate
     * @param coordinates
     * @param direction
     * @param shipNo
     * @return
     * @throws Exception
     */
    private boolean checkIfProper(String coordinates, String direction, int shipNo) throws Exception{

        try {
            BattleShipMap.checkIfValid(coordinates.charAt(0), BattleShipMap.getProperRowFormat(coordinates));
            battleMap.placeShip(ships.get(shipNo - 1), coordinates, direction);

        } catch (Exception e){
            System.out.println("Invalid input!");
            return false;
        }
            return true;

    }

    /**
     * Prints remaining ships to be placed
     */
    private void printOutShips(){
        System.out.print("Here are your ships: ");
        BattleMapPrinter.printOutShips(ships, index);
    }

    /**
     * Gets user input for ship to be placed
     * @param shipPrinter to print out the choices and the map after undo
     * @return the user choice for ship
     * @throws Exception
     */
    private String chooseShips(Printer shipPrinter) throws Exception{

        System.out.println("\nPress the corresponding ship number to select ship to place. Press any character to undo last placement");
        printOutShips();

        while (true) {
            String input = console.next();

            try {
                if (Integer.parseInt(input) > ships.size() - index || Integer.parseInt(input) < 1) {
                    throw new IllegalArgumentException();
                }
                return input;
            }catch (NumberFormatException e){
                    if(battleMap.isEmpty()) {
                        System.out.println("No placement to undo.");
                    } else {
                        battleMap.removeShip();
                        index--;
                        battleMap.prettyPrint(shipPrinter);
                        System.out.println("\nPress the corresponding ship number to select ship to place. Press any character to undo last placement");
                        printOutShips();
                    }
            } catch (Exception e){
                System.out.println("Number must be a corresponding ship number");
                continue;
            }

        }
    }


    /**
     * Places ships randomly on the map
     * Uses recursive method to find the right combination that fits all ships into map
     * @param column the column to start placing the ships on
     * @param ships the list of ships to place on the map
     * @param index keeps track of ships
     * @return true if there is a possible combination of ships to fit the map
     * @throws Exception
     */
    private boolean randomShips(char column, List<Ship> ships, int index)  throws Exception {
        if (ships.size() == index) {
            return true;
        } else {

            Random rand = new Random();

            for(int columnCounter = 0, col = column; columnCounter < 10; col = col >= 106 ? 97 : (char)(col + 1), columnCounter++) {
                for (int row = 1; row <= 10; row++) {
                    int flipCoin = rand.nextInt(2) + 1;

                    if (flipCoin == 1) {
                        if (isSafeVertical((char) col, row, "up", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "up");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }

                        if (isSafeVertical((char)col, row, "down", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "down");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }
                        if (isSafeHorizontal((char)col, row, "left", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "left");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }
                        if (isSafeHorizontal((char)col, row, "right", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "right");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }


                    } else {
                        if (isSafeHorizontal((char)col, row, "right", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "right");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }

                        if (isSafeHorizontal((char)col, row, "left", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "left");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }
                        if (isSafeVertical((char)col, row, "down", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "down");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }

                        if (isSafeVertical((char)col, row, "up", ships.get(index))) {
                            battleMap.placeShip(ships.get(index), (char)col, row, "up");
                            if (randomShips((char) (column), ships, index + 1)) {
                                return true;
                            }
                            battleMap.removeShip();
                        }


                    }
                }
            }
            return false;
        }
    }

    /**
     * Checks if it's safe to place ships up or down
     * @param column the column to place the ship
     * @param row the row to place the ship
     * @param direction the direction which the ship is to be placed
     * @param ship the ship to be placed
     * @return if it is safe to place up or down
     * @throws Exception
     */
    public boolean isSafeVertical(char column, int row, String direction, Ship ship) throws Exception {

        int increment = direction.equals("up") ? -1 : 1;

        if(row + (ship.getSize() - 1) *  increment > 10 || row + (ship.getSize() - 1) *  increment < 1) return false;

        //Checks the both ends of the ship
        if(!surroundingsClear(column, row)) return false;
        if(!surroundingsClear(column, row + (ship.getSize() - 1) * increment)) return false;

        //Checks the body of the ship
        for(int i = 1; i < ship.getSize() - 1; i++){
            if(!sideClear(column, row + i * increment)) return false;
        }

        return true;
    }

    /**
     * Checks if it's safe to place ships left or right
     * @param column the column to place the ship
     * @param row the row to place the ship
     * @param direction the direction which the ship is to be placed
     * @param ship the ship to be placed
     * @return if it is safe to place left or right
     * @throws Exception
     */
    public boolean isSafeHorizontal(char column, int row, String direction, Ship ship) throws Exception {

        int increment = direction.equals("right") ? 1 : -1;


        if(column + (ship.getSize() - 1) *  increment >  106 || column + (ship.getSize() - 1) *  increment < 97) return false;

        if(!surroundingsClear(column, row)) return false;
        if(!surroundingsClear((char)(column + (ship.getSize() - 1) * increment), row)) return false;

        for(int i = 1; i < ship.getSize() - 1; i++){
            if(!upDownClear((char)(column + i * increment), row )) return false;
        }

        return true;
    }

    /**
     * Checks if the adjacent side cell is clear
     * @param column the column to check
     * @param row the row to check
     * @return if the side adjavent cell is clear
     * @throws Exception
     */
    private boolean sideClear(char column, int row) throws Exception {
        //check right
        if(column + 1 > 106) {
        } else {

            if (battleMap.getCell((char) (column + 1), row).getClass() == SpecificShipCell.class) {
                return false;
            }
        }

        //check left
        if(column - 1 < 97){
        } else {
            if (battleMap.getCell((char) (column - 1), row).getClass() == SpecificShipCell.class) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the adjacent upward and downward cell is clear
     * @param column the column to check
     * @param row the row to check
     * @return if the side adjavent upward and downward cell is clear
     * @throws Exception
     */
    private boolean upDownClear(char column, int row) throws Exception {

        //check up
        if(row - 1 < 10){
        } else {
            if (battleMap.getCell(column, row - 1).getClass() == SpecificShipCell.class) {
                return false;
            }
        }


        //check down
        if(row + 1 > 10){
        } else {
            if (battleMap.getCell(column, row + 1).getClass() == SpecificShipCell.class) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if the surrounding and its place of a coordinate is clear
     * @param column the column to check
     * @param row the row to check
     * @return surrounding is clear
     * @throws Exception
     */
    private boolean surroundingsClear(char column, int row) throws Exception {

        //check cell
        if(battleMap.getCell(column, row).getClass() != OpenSeaWaterCell.class){
            return false;
        }

        //checks upwards/downwards and sideways
        if(!(sideClear(column, row) && upDownClear(column, row))) return false;

        //check upper right
        if(column + 1 > 106 || row - 1 < 1) {
        } else {
            if (battleMap.getCell((char) (column + 1), row - 1).getClass() == SpecificShipCell.class) {
                return false;
            }
        }

        //check upper left
        if(column - 1 < 97 || row - 1 < 1){
        } else {
            if (battleMap.getCell((char) (column - 1), row - 1).getClass() == SpecificShipCell.class) {
                return false;
            }
        }

        //check lower right
        if(column + 1 > 106 || row + 1 > 10) {
        } else {
            if (battleMap.getCell((char) (column + 1), row + 1).getClass() == SpecificShipCell.class) {
                return false;
            }
        }

        //check lower left
        if(column - 1 < 97 || row + 1 > 10){
        } else {
            if (battleMap.getCell((char) (column - 1), row + 1).getClass() == SpecificShipCell.class) {
                return false;
            }
        }

        return true;
    }
}
