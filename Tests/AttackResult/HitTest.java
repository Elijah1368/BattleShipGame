package AttackResult;


import Model.AttackResult.Hit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HitTest {
    Hit ar;
    Hit ar2;

    @Before
    public void setUp() throws Exception {
        ar = new Hit();
        ar2 = new Hit();
    }

    @Test
    public void hashCodeTest(){
        Assert.assertEquals(ar2.hashCode(), ar.hashCode());
        Assert.assertEquals(ar.hashCode(), ar.hashCode());
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("Hit{}", ar.toString());
    }
}