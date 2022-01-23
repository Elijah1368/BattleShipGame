package Ships;

import Model.Ships.BattleShip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleShipTest {
    BattleShip battleShip;
    BattleShip battleShip2;

    @Before
    public void setUp() throws Exception {
        battleShip = new BattleShip();
        battleShip2 = new BattleShip();
    }

    @Test
    public void equals() {
        Assert.assertTrue(battleShip.equals(battleShip));
    }

    @Test
    public void hashCodeTest() throws Exception {
        Assert.assertEquals(battleShip.hashCode(), battleShip2.hashCode());
        Assert.assertEquals(battleShip.hashCode(), battleShip.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("BattleShip{size=4, numOfHitCells=0}", battleShip.toString());
    }
}