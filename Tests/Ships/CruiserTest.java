package Ships;

import Model.Ships.BattleShip;
import Model.Ships.Cruiser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CruiserTest {
    Cruiser cruiser;
    BattleShip cruiser2;

    @Before
    public void setUp() throws Exception {
        cruiser = new Cruiser();
        cruiser2 = new BattleShip();
    }

    @Test
    public void equals() {
        Assert.assertFalse(cruiser.equals(cruiser2));
        Assert.assertTrue(cruiser.equals(cruiser));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(cruiser.hashCode(), cruiser.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("Cruiser{size=3, numOfHitCells=0}", cruiser.toString());
    }
}