package View;

import Model.Cells.Cell;
import Model.Cells.SpecificShipCell;

/**
 * This printer is for printing without revealing ship location
 */
public class FleetMapPrinter extends BattleMapPrinter {
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        return o.getClass() == FleetMapPrinter.class;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "F";
    }

    /**
     * Gives the symbol for each cell
     * @param cell is the cell to be identified
     * @return the string symbol of a cell to be printed
     */
    @Override
    protected String identifier(Cell cell){
        if (cell.getIsHit()) {
            if(cell.getClass() == SpecificShipCell.class) {
                return "x";
            } else {
                return "o";
            }
        } else {
            return "_";
        }
    }
}
