package Map;

import Model.Cells.EnemyShipCell;
import Model.Cells.OpenSeaWaterCell;
import Model.Cells.SpecificShipCell;
import Model.Map.BattleShipMap;
import Model.Ships.BattleShip;
import Model.Ships.Cruiser;
import View.BattleMapPrinter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BattleMapTest {
    BattleShipMap map;
    BattleShipMap sameRef;
    BattleShipMap sameState;
    BattleMapPrinter consolePrinter;

    @Before
    public void setUp() throws Exception {
        map = new BattleShipMap();
        sameRef = map;
        sameState = new BattleShipMap();
        consolePrinter = new BattleMapPrinter();
    }

    @Test
    public void equals() throws Exception{
        BattleShipMap b2 = new BattleShipMap();
        BattleShipMap difMap = new BattleShipMap();
        difMap.placeCell(new SpecificShipCell(new BattleShip()), "a1");
        difMap.placeCell(new SpecificShipCell(new Cruiser()),"a2");

        BattleShipMap nullMap = null;
        BattleShipMap nullCell = new BattleShipMap();
        nullCell.placeCell( null, "a1");

        Assert.assertTrue(map.equals(map));
        Assert.assertTrue(map.equals(sameRef));
        Assert.assertFalse(map.equals(nullMap));
        Assert.assertEquals(map.equals(sameState), sameState.equals(map));
        Assert.assertEquals(map.equals(sameState) && sameState.equals(b2), b2.equals(map));
        Assert.assertFalse(map.equals(difMap));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(map.hashCode(), sameRef.hashCode());
        Assert.assertEquals(map.hashCode(), map.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("Map{map=[[OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}], [OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}, OpenSeaWaterCell{isHit=false}]]}", map.toString());
    }

    @Test
    public void prettyPrint() throws Exception {
        System.setProperty("line.separator", "\n");
        ByteArrayOutputStream mapPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mapPrint));
        map.prettyPrint(consolePrinter);
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
        Assert.assertEquals(new OpenSeaWaterCell(), map.getCell('a', 1));
    }

    @Test
    public void getCell1() throws Exception {
        Assert.assertEquals(new OpenSeaWaterCell(), map.getCell("d3"));
    }

    @Test
    public void placeCell() throws  Exception {
        map.placeCell(new EnemyShipCell(), 'a', 1);
        Assert.assertEquals(new EnemyShipCell(), map.getCell("a1"));
    }

    @Test
    public void placeCell1() throws Exception {
        map.placeCell(new EnemyShipCell(), "a4");
        Assert.assertEquals(new EnemyShipCell(), map.getCell("a4") );
    }
}