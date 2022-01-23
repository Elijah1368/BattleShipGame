package View;
import Model.Map.BattleShipMap;


/**
 * Contract for mapprinters
 *
 * void toConsole
 * String identifier
 */
public interface Printer {

    //Must have the ability to printout map
    void printMap(BattleShipMap map) throws Exception;

}
