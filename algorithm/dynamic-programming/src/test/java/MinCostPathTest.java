import com.wfs.dynamicprogramming.MinCostPath;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Suryasnata on 5/22/2017.
 */
public class MinCostPathTest
{
    @Test
    public void testMinCostpath()
    {
        MinCostPath  minCostPath =new MinCostPath(new int[][]{
                { 1 , 2 , 3 },
                { 4 , 8 , 2 },
                { 1 , 5 , 3 }
        });
        List l =new ArrayList();l.add(1);l.add(2);l.add(2);l.add(3);
        Assert.assertArrayEquals(l.toArray(), minCostPath.getMinCostPath().toArray());
        minCostPath.getMinCostPath();
    }
}
