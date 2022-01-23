package Cells;

import Model.AttackResult.Hit;
import Model.Cells.SpecificShipCell;
import Model.Ships.Ship;
import Model.Ships.Submarine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpecificShipCellTest {
    SpecificShipCell specificShipCell;
    SpecificShipCell specificShipCell2;
    Ship ship;

    @Before
    public void setUp() throws Exception {
        ship = new Submarine();
        specificShipCell = new SpecificShipCell(ship);
        specificShipCell2 = new SpecificShipCell(ship);
    }

    @Test
    public void attackCell() {
        Assert.assertEquals(new Hit(), specificShipCell.attackCell());
    }

    @Test
    public void markShipCellSunk() {
        specificShipCell.markShipCellSunk();
        Assert.assertTrue(specificShipCell.getIsSunk());
    }

    @Test
    public void getShip() {
        Assert.assertEquals(new Submarine(), specificShipCell.getShip());
    }

    @Test
    public void equals() {
        Assert.assertTrue(specificShipCell2.equals(specificShipCell));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(specificShipCell2.hashCode(), specificShipCell.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("SpecificShipCell{ship=Submarine{size=2, numOfHitCells=0}, isSunk=false, isHit=false}", specificShipCell.toString());
    }
}