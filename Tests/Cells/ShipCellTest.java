package Cells;

import Model.Cells.EnemyShipCell;
import Model.Cells.ShipCell;
import org.junit.Before;
import org.junit.Test;


public class ShipCellTest {
    ShipCell shipCell;

    @Before
    public void setUp() throws Exception {
        shipCell = new EnemyShipCell();
    }

    @Test
    public void markShipCellSunk() {
        shipCell.markShipCellSunk();
    }
}