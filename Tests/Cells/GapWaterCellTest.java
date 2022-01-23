package Cells;

import Model.Cells.GapWaterCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GapWaterCellTest {
    GapWaterCell gapWaterCell;
    GapWaterCell gapWaterCell2;

    @Before
    public void setUp() throws Exception {
        gapWaterCell = new GapWaterCell();
        gapWaterCell2 = new GapWaterCell();
    }

    @Test
    public void placeShipOnCell() {
        Assert.assertFalse(gapWaterCell.placeShipOnCell());
    }

    @Test
    public void equals() {
        Assert.assertTrue(gapWaterCell.equals(gapWaterCell));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(gapWaterCell2.hashCode(), gapWaterCell.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("GapWaterCell{isHit=false}", gapWaterCell.toString());
    }
}