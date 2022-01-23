package Cells;

import Model.Cells.AbstractCell;
import Model.Cells.EnemyShipCell;
import Model.Cells.GapWaterCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractCellTest {
    AbstractCell abstractCell;
    AbstractCell abstractCell2;
    @Before
    public void setUp() throws Exception {
        abstractCell = new EnemyShipCell();
        abstractCell2 = new GapWaterCell();
    }

    @Test
    public void getIsHit() {
        Assert.assertFalse(abstractCell.getIsHit());
    }

    @Test
    public void equals() {
        Assert.assertFalse(abstractCell.equals(abstractCell2));
        Assert.assertTrue(abstractCell.equals(abstractCell));
    }

    @Test
    public void hashCodeTest() {
        abstractCell2 = new EnemyShipCell();
        Assert.assertEquals(abstractCell2.hashCode(), abstractCell.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("EnemyShipCell{isSunk=false, isHit=false}", abstractCell.toString());
    }
}