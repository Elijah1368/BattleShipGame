package Map;

import Model.Map.BattleShipMap;
import View.BattleMapPrinter;
import View.Printer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BattleMapPrinterInterfaceTest {
    Printer consolePrinterInterface;
    BattleShipMap map;

    @Before
    public void setUp() throws Exception {
        consolePrinterInterface = new BattleMapPrinter();
        map = new BattleShipMap();
    }

    @Test
    public void toConsole() throws Exception {
        System.setProperty("line.separator", "\n");
        ByteArrayOutputStream mapPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mapPrint));
        consolePrinterInterface.printMap(map);
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


}