package Cells;

import Model.Cells.OpenSeaWaterCell;
import Model.Cells.WaterCell;
import org.junit.Before;


public class WaterCellTest {
    WaterCell waterCell;

    @Before
    public void setUp() throws Exception {
        waterCell = new OpenSeaWaterCell();
    }
}