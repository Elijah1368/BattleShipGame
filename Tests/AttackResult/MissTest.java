package AttackResult;

import Model.AttackResult.Miss;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissTest {
    Miss miss;
    Miss miss2;

    @Before
    public void setUp() throws Exception {
        miss = new Miss();
        miss2 = new Miss();
    }

    @Test
    public void hashCodeTest(){
        Assert.assertEquals(miss.hashCode(), miss2.hashCode());
        Assert.assertEquals(miss.hashCode(), miss.hashCode());
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("Miss{}", miss.toString());
    }
}