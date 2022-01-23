package Ships;

import Model.Ships.Destroyer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {
    Destroyer destroyer;

    @Before
    public void setUp() throws Exception {
        destroyer = new Destroyer();
    }

    @Test
    public void equals() {
        Assert.assertTrue(destroyer.equals(destroyer));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(destroyer.hashCode(), destroyer.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("Destroyer{size=1, numOfHitCells=0}", destroyer.toString());
    }
}