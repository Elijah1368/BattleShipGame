package Cells;

import Model.AttackResult.Miss;
import Model.Cells.AbstractWaterCell;
import Model.Cells.OpenSeaWaterCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractWaterCellTest {
    AbstractWaterCell abstractWaterCell2;
    AbstractWaterCell abstractWaterCell;

    @Before
    public void setUp() throws Exception {
        abstractWaterCell = new OpenSeaWaterCell();
        abstractWaterCell2 = new OpenSeaWaterCell();
    }

    @Test
    public void attackCell() {
        Assert.assertEquals(new Miss(), abstractWaterCell.attackCell());
    }

    @Test
    public void equals() {
        Assert.assertTrue(abstractWaterCell.equals(abstractWaterCell));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(abstractWaterCell.hashCode(), abstractWaterCell.hashCode());
        Assert.assertEquals(abstractWaterCell2.hashCode(), abstractWaterCell.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("OpenSeaWaterCell{isHit=false}", abstractWaterCell.toString());
    }
}