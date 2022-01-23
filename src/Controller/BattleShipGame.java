package Controller;

import Model.AttackResult.AttackResult;
import Model.AttackResult.Miss;
import Model.AttackResult.Sunk;
import Model.ComputerPlayer.BattleShipPlayer;
import Model.ComputerPlayer.Player;
import Model.Map.BattleShipMap;
import Model.Map.ShipMap;
import Model.Ships.*;
import View.BattleMapPrinter;
import View.Printer;
import View.FleetMapPrinter;
import Controller.MapFiller.MapFiller;
import Controller.MapFiller.ShipMapFiller;

import java.util.*;

/**
 * Controller for battleshhip, managest he model and view
 */
public class BattleShipGame {
    private static final int MAXIMUM_SHIP_CELLS = 80;
    public static void main(String[] args) throws Exception{


        Scanner console = new Scanner(System.in);
        //obtains modechoice from user
        String modeChoice = getMode(console);

        //Create map and ships for computer and player
        List<Ship> playerShips = setup();
        List<Ship> computerShip = new ArrayList<>(playerShips);
        ShipMap computerMap = new BattleShipMap();
        ShipMap playerMap = new BattleShipMap();

        //creates mapprinter for computer and player
        Printer playerMapPrinter = new BattleMapPrinter();
        Printer computerMapPrinter;

        //chooses
        if(modeChoice.equals("1")){
            prepare(getSortChoice(console), computerMap, playerMap, playerShips, computerShip);
            computerMapPrinter = new FleetMapPrinter();
        } else {
            debug(playerShips, console);
            computerShip = new ArrayList<>(playerShips);
            prepare(getSortChoice(console), computerMap, playerMap, playerShips, computerShip);
            computerMapPrinter = new BattleMapPrinter();
        }

        printMap(computerMapPrinter, computerMap);
        printMap(playerMapPrinter, playerMap);

        int sunkenPlayerShips = 0;
        int sunkenComputerShips = 0;
        int shipCount = playerShips.size();

        Player computer = new BattleShipPlayer();

        String attackCoordinates;
        AttackResult playerAttackResult = null;
        AttackResult computerAttackResult = null;
        String computerAttack;
        boolean gameOver = false;
        int attackCount = 0;
        while(!gameOver){
            while(true) {
                System.out.println("\n");
                printMap(computerMapPrinter, computerMap);
                printMap(playerMapPrinter, playerMap);
                if(playerAttackResult != null)System.out.println("Your attack " + playerAttackResult);
                if(computerAttackResult != null)
                    if(attackCount != 0) {
                        System.out.println("Computer's attack hit " + attackCount + " times.");
                    } else {
                        System.out.println("Computer's attack " + computerAttackResult);
                    }
                attackCoordinates = getAttackCoordinates(console);
                playerAttackResult = computerMap.getCell(attackCoordinates).attackCell();

                if (playerAttackResult.getClass() == Sunk.class)
                    sunkenComputerShips++;
                if (sunkenComputerShips == shipCount){
                    gameOver = true;
                    break;
                }
                if(playerAttackResult.getClass() == Miss.class) break;;

            }

            attackCount = 0;

            if(gameOver) break;
            while(true){
                computerAttack = computer.nexTurn();
                computerAttackResult = playerMap.getCell(computerAttack).attackCell();
                if(computerAttackResult.getClass() == Sunk.class) sunkenPlayerShips++;
                if (sunkenPlayerShips == shipCount){
                    gameOver = true;
                    break;
                }
                if(computerAttackResult.getClass() == Miss.class) break;
                attackCount++;
            }

            printMap(computerMapPrinter, computerMap);
            printMap(playerMapPrinter, playerMap);
        }

        if(sunkenPlayerShips > sunkenComputerShips){
            System.out.println("You just got rekt. Good game loser.");
        } else {
            System.out.println("Congratulations! You have won!");
        }


    }

    private static String getAttackCoordinates(Scanner console) throws Exception{
        String attackCoordinates;
        while(true) {
            System.out.print("Enter attack coordinates: ");
            attackCoordinates = console.next();
            try {
                BattleShipMap.checkIfValid(attackCoordinates.charAt(0), BattleShipMap.getProperRowFormat(attackCoordinates));
                return attackCoordinates;
            } catch (Exception e){
                System.out.println("Improper row format");
                continue;
            }
        }
    }

    private static void prepare(String choice, ShipMap computerMap, ShipMap playerMap, List<Ship> playerShips, List<Ship> computerShips)throws Exception{
        MapFiller mapFiller = new ShipMapFiller();
        MapFiller mapFiller1 = new ShipMapFiller();
        computerMap.fillRandom(mapFiller, computerShips);


        if(choice.equals("1")){
            playerMap.fillRandom(mapFiller1, playerShips);

        } else {
            playerMap.fill(mapFiller1, playerShips);
        }

    }


    private static void printMap(Printer consolePrinter, ShipMap battleMap) throws Exception {
        battleMap.prettyPrint(consolePrinter);
    }

    private static void debug(List<Ship> ships, Scanner console) throws Exception {


        System.out.println("Press 1 to change number of ships. Press 2 to change ship types. Press any other button to play game");
        String input = console.next();

        if (input.equals("1")) {
            int shipCount = getNumberOfShips(console);
            assignShipTypes(ships, shipCount, console);
        } else if (input.equals("2")) {
            assignShipTypes(ships, ships.size(), console);
        } else {
            return;
        }

    }

    private static int getNumberOfShips(Scanner console){

        while(true) {
            System.out.print("Enter number of ships (1 <= ships <= 25): ");
            try {
                int shipAmount = Integer.parseInt(console.next());
                if (shipAmount > 25 || shipAmount < 1) {
                    System.out.println("Ship Amount must be between 12 and 1 inclusive");
                    continue;
                }
                System.out.println();
                return shipAmount;
            } catch (Exception e) {
                System.out.println("Please enter valid number!");
                continue;
            }
        }
    }

    private static boolean withinLimit(List<Ship> shipRoster) {
        int currentCount = 0;
        int size = shipRoster.size();
        for(int i = 0; i < size; i++){
            currentCount += shipRoster.get(i).getSize() * 2 + 2 ;
        }

        return  currentCount <= 100;
    }

    private static void assignShipTypes(List<Ship> shipRoster, int count, Scanner console){
        shipRoster.clear();

        for (int i = 1; i <=  count; i++) {
            System.out.print("Ship type for #" + i + " (Press 1 for destroyer, 2 for submarine, 3 for cruiser, 4 for battleship or press any other character to reset): ");
            Ship ships = distinguishShip(console.next());
            System.out.println();

            if(ships == null){
                i--;
                continue;
            }

            if(!withinLimit(shipRoster)){
                System.out.println("Ship cell capacity for the board is exceeded. Try choosing smaller ships.");
                shipRoster.clear();
                i = 0;
                continue;
            }

            shipRoster.add(ships);
        }

        System.out.println("All ships are assigned.");
    }

    private static Ship distinguishShip(String choice){
        switch (choice){
            case "1":
                return new Destroyer();
            case "2":
                return new Submarine();
            case "3":
                return new Cruiser();
            case "4":
                return new BattleShip();
            default:
                return null;
        }
    }

    private static String getSortChoice(Scanner console){
        System.out.print("How would you like to sort your ship? (Press 1 for random, press 2 to do it yourself): ");

        String input;

        while(true) {
            input = console.next().replaceAll(" ", "");
            if (!input.equals("1") && !input.equals("2")) {
                System.out.println("Enter 1 for random, 2 to do it yourself.");
                continue;
            }
            break;
        }

        System.out.println();
        return input;
    }

    public static List<Ship> setup() {
        Ship[] ship = {new BattleShip(), new Cruiser(), new Cruiser(), new Submarine(), new Submarine(), new Submarine(), new Destroyer(), new Destroyer(), new Destroyer(),new Destroyer()};
        return new ArrayList(Arrays.asList(ship));
    }

    public static String getMode(Scanner console){
        System.out.println("Would you like to debug or play? (Select 1 to play, press any other character for debug)");
        String input = console.next().replaceAll(" ", "");
        return input;
    }
}
