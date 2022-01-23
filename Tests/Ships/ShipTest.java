package Ships;

import Model.Ships.Cruiser;
import Model.Ships.Ship;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {
    Ship ship;

    @Before
    public void setUp() throws Exception {
        ship = new Cruiser();
    }

    @Test
    public void hitShip()  {
        ship.hitShip();
        ship.hitShip();
        ship.hitShip();
        Assert.assertTrue(ship.isSunk());
    }

    @Test
    public void isSunk() {
        Assert.assertFalse(ship.isSunk());
    }
}