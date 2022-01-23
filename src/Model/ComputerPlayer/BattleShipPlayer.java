package Model.ComputerPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleShipPlayer implements Player {
    List moveList;

    public BattleShipPlayer() {
        moveList = new ArrayList<String>();
    }

    public String nexTurn() throws Exception {
        Random rand = new Random();
        char randCol;
        int randRow;

        while (true) {
            randCol = (char) (rand.nextInt(10) + 97);
            randRow = rand.nextInt(10) + 1;
            String move = randCol + "" + randRow;
            if (moveList.contains(move)) continue;
            moveList.add(move);
            return randCol + "" + randRow;
        }
    }
}