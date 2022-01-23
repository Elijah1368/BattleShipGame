package Ships;

import Model.Ships.AbstractShip;
import Model.Ships.Cruiser;
import Model.Ships.Destroyer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AbstractShipTest {
    AbstractShip abstractShip;
    AbstractShip abstractShip2;

    @Before
    public void setUp() throws Exception {
         abstractShip = new Destroyer();
         abstractShip2 = new Cruiser();
    }

    @Test
    public void hitShip() {
        abstractShip.hitShip();
        Assert.assertTrue(abstractShip.isSunk());
    }

    @Test
    public void isSunk() {
        abstractShip.hitShip();
        Assert.assertTrue(abstractShip.isSunk());
    }

    @Test
    public void equals() {
        Assert.assertTrue(abstractShip.equals(abstractShip));
        Assert.assertFalse(abstractShip2.equals(abstractShip));
    }

    @Test
    public void hashCodeTest() {
        abstractShip2 = new Destroyer();
        Assert.assertEquals(abstractShip.hashCode(), abstractShip.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("Destroyer{size=1, numOfHitCells=0}", abstractShip.toString());
    }
}