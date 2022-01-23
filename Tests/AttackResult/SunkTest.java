package AttackResult;

import Model.AttackResult.Sunk;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SunkTest {
    Sunk sunk;
    Sunk sunk2;

    @Before
    public void setUp() throws Exception {
        sunk = new Sunk();
        sunk2 = new Sunk();
    }

    @Test
    public void hashCodeTest(){
        Assert.assertEquals(sunk.hashCode(), sunk2.hashCode());
        Assert.assertEquals(sunk.hashCode(), sunk.hashCode());
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("Sunk{}", sunk.toString());
    }
}