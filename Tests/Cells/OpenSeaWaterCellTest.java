package Cells;

import Model.Cells.OpenSeaWaterCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenSeaWaterCellTest {
    OpenSeaWaterCell openSeaWaterCell;
    OpenSeaWaterCell openSeaWaterCell2;

    @Before
    public void setUp() throws Exception {
        openSeaWaterCell = new OpenSeaWaterCell();
        openSeaWaterCell2 = new OpenSeaWaterCell();
    }

    @Test
    public void placeShipOnCell() {
        Assert.assertTrue(openSeaWaterCell.placeShipOnCell());
    }

    @Test
    public void equals() {
        Assert.assertTrue(openSeaWaterCell2.equals(openSeaWaterCell));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(openSeaWaterCell2.hashCode(), openSeaWaterCell.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("OpenSeaWaterCell{isHit=false}", openSeaWaterCell.toString());
    }
}