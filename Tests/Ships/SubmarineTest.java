package Ships;

import Model.Ships.Submarine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SubmarineTest {
    Submarine submarine;

    @Before
    public void setUp() throws Exception {
        submarine = new Submarine();
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(submarine.hashCode(), submarine.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("Submarine{size=2, numOfHitCells=0}", submarine.toString());
    }
}