package View;
import Model.Cells.Cell;
import Model.Cells.SpecificShipCell;
import Model.Map.BattleShipMap;
import Model.Ships.Ship;

import java.util.List;

/**
 * This class is to print out the map to the console
 */
public class BattleMapPrinter implements Printer {
    private static final int A_CHAR_VALUE = 97;
    private static final int CELL_DIMENSIONS = 10;

    /**
     * This method is to print the map to console and use the identifier method to get symbol of a class
     *
     * @param map is the Map object to be printed out
     * @throws Exception for the getCell method if the entered parameter is invalid data
     */
    public void printMap(BattleShipMap map) throws Exception{

        System.out.print(" ");

        for(int i = 0; i < 10; i++){
            System.out.print("  " + Character.toUpperCase((char)(A_CHAR_VALUE + i)));
        }

        System.out.println();

        for(int i = 1; i <= CELL_DIMENSIONS; i++){
            System.out.print(i);
            for(int j = A_CHAR_VALUE; j  < A_CHAR_VALUE + CELL_DIMENSIONS; j++){
                if(i == 10 && j == A_CHAR_VALUE) {
                    System.out.print(" " + identifier(map.getCell(((char)j), i)));
                } else {
                    System.out.print("  " + identifier(map.getCell(((char) j), i)));
                }
            }
            System.out.println();
        }
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
     * hashCode() creates a unique hashcode for the class
     * @return int the hashcode
     */
    @Override
    public int hashCode(){
        return 420;
    }

    /**
     * toString() creates a string representation of the class
     * @return String the string representation of the class
     */
    @Override
    public String toString() {
        return "ConsolePrinter{}";
    }

    /**
     * This method tells the corresponding symbol for a particular cell
     * @param cell is the cell to be identified
     * @return
     */
    protected String identifier(Cell cell){
        if (cell.getIsHit()) {
            if(cell.getClass() == SpecificShipCell.class) return "X";
                return "x";
        } else if (cell.getClass() == SpecificShipCell.class){
          return "+";
        }

        return "_";

    }

    public static void printOutShips(List<Ship> ships, int index){

        System.out.print("(1 ");
        for (int j = 0; j < ships.get(index).getSize(); j++) {
            System.out.print("+");
        }
        for(int i = index + 1, k = 2; i < ships.size(); i++, k++) {
            System.out.print(", " + (k) + " ");
            for (int j = 0; j < ships.get(i).getSize(); j++) {
                System.out.print("+");
            }
        }
        System.out.println(")");
    }
}
