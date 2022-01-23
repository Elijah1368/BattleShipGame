package Map;

import Model.Cells.EnemyShipCell;
import Model.Cells.OpenSeaWaterCell;
import Model.Map.BattleShipMap;
import Model.Map.ShipMap;
import View.BattleMapPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BattleMapInterfaceTest {
    BattleMapPrinter consolePrinter;
    ShipMap mapInterface;

    @Before
    public void setUp() throws Exception {
        mapInterface = new BattleShipMap();
        consolePrinter = new BattleMapPrinter();
    }

    @Test
    public void prettyPrint() throws Exception {
        System.setProperty("line.separator", "\n");
        ByteArrayOutputStream mapPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mapPrint));
        mapInterface.prettyPrint(consolePrinter);
        Assert.assertEquals("   A  B  C  D  E  F  G  H  I  J\n" +
                "1  -  -  -  -  -  -  -  -  -  -\n" +
                "2  -  -  -  -  -  -  -  -  -  -\n" +
                "3  -  -  -  -  -  -  -  -  -  -\n" +
                "4  -  -  -  -  -  -  -  -  -  -\n" +
                "5  -  -  -  -  -  -  -  -  -  -\n" +
                "6  -  -  -  -  -  -  -  -  -  -\n" +
                "7  -  -  -  -  -  -  -  -  -  -\n" +
                "8  -  -  -  -  -  -  -  -  -  -\n" +
                "9  -  -  -  -  -  -  -  -  -  -\n" +
                "10 -  -  -  -  -  -  -  -  -  -\n", mapPrint.toString());
    }

    @Test
    public void getCell() throws Exception {
        Assert.assertEquals(new OpenSeaWaterCell(), mapInterface.getCell('a', 2));
    }

    @Test
    public void getCell1() throws  Exception {
        Assert.assertEquals(new OpenSeaWaterCell(), mapInterface.getCell("a2"));
    }

    @Test
    public void placeCell() throws Exception {
        mapInterface.placeCell(new EnemyShipCell(),"a3");
        Assert.assertEquals(new EnemyShipCell(), mapInterface.getCell("a3"));
    }
}