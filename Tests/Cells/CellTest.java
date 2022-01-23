package Cells;

import Model.AttackResult.Miss;
import Model.Cells.Cell;
import Model.Cells.GapWaterCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellTest {

    Cell cell;
    Cell cell2;

    @Before
    public void setUp() throws Exception {
        cell = new GapWaterCell();
    }

    @Test
    public void placeShipOnCell() {
        Assert.assertFalse(cell.placeShipOnCell());
    }

    @Test
    public void attackCell() {
        Assert.assertEquals(new Miss(), cell.attackCell());
    }
}