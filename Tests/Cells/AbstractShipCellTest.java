package Cells;

import Model.Cells.AbstractShipCell;
import Model.Cells.SpecificShipCell;
import Model.Ships.BattleShip;
import Model.Ships.Ship;
import Model.Ships.Submarine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipCellTest {
    AbstractShipCell abstractShipCell;
    Ship ship;
    Ship ship2;
    AbstractShipCell abstractShipCell2;

    @Before
    public void setUp() throws Exception {
        ship = new Submarine();
        ship2 = new BattleShip();
        abstractShipCell = new SpecificShipCell(ship);
        abstractShipCell2 = new SpecificShipCell(ship2);
    }

    @Test
    public void getIsSunk() {
        Assert.assertFalse(abstractShipCell.getIsSunk());
    }

    @Test
    public void placeShipOnCell() {
        Assert.assertFalse(abstractShipCell.placeShipOnCell());
    }

    @Test
    public void equals() {
        Assert.assertTrue(abstractShipCell.equals(abstractShipCell));
        Assert.assertFalse(abstractShipCell.equals(abstractShipCell2));
    }

    @Test
    public void hashCodeTest() {
        abstractShipCell2 = new SpecificShipCell(ship);
        Assert.assertEquals(abstractShipCell2.hashCode(), abstractShipCell.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("SpecificShipCell{ship=Submarine{size=2, numOfHitCells=0}, isSunk=false, isHit=false}", abstractShipCell.toString());
    }
}