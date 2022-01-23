package Map;

import Model.Map.BattleShipMap;
import View.BattleMapPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BattleMapPrinterTest {
    BattleMapPrinter consolePrinter;
    BattleMapPrinter consolePrinter2;
    BattleShipMap map;

    @Before
    public void setUp() throws Exception {
        map = new BattleShipMap();
        consolePrinter = new BattleMapPrinter();
        consolePrinter2 = new BattleMapPrinter();
    }

    @Test
    public void toConsole() throws Exception {
        System.setProperty("line.separator", "\n");
        ByteArrayOutputStream mapPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mapPrint));
        consolePrinter.printMap(map);
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
    public void equals() {
        Assert.assertTrue(consolePrinter2.equals(consolePrinter));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(consolePrinter2.hashCode(), consolePrinter.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("ConsolePrinter{}", consolePrinter.toString());
    }

}