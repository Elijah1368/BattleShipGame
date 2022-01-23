package Cells;

import Model.AttackResult.Hit;
import Model.Cells.EnemyShipCell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EnemyShipCellTest {
    EnemyShipCell enemyShipCell;
    EnemyShipCell enemyShipCell2;

    @Before
    public void setUp() throws Exception {
        enemyShipCell = new EnemyShipCell();
        enemyShipCell2 = new EnemyShipCell();
    }

    @Test
    public void attackCell() {
        Assert.assertEquals(new Hit(), enemyShipCell.attackCell());
    }

    @Test
    public void markShipCellSunk() {
        enemyShipCell.markShipCellSunk();
        Assert.assertTrue(enemyShipCell.getIsSunk());
    }

    @Test
    public void equals() {
        Assert.assertTrue(enemyShipCell2.equals(enemyShipCell));
    }

    @Test
    public void hashCodeTest() {
        Assert.assertEquals(enemyShipCell.hashCode(), enemyShipCell.hashCode());
        Assert.assertEquals(enemyShipCell.hashCode(), enemyShipCell2.hashCode());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("EnemyShipCell{isSunk=false, isHit=false}", enemyShipCell.toString());
    }
}