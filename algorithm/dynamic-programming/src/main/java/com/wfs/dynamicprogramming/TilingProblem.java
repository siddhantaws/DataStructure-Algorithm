package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/11/2017.
 * Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 tiles.
 * A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.
 */
public class TilingProblem {

    private int tileColumn ;

    public TilingProblem(int tileColumn) {
        this.tileColumn = tileColumn;
    }

    public int getTotalNumberOfWays()
    {
       return  getTotalNumberOfWays(tileColumn);
    }

    private int getTotalNumberOfWays(int tileColumn)
    {
        return 0;
    }

}
