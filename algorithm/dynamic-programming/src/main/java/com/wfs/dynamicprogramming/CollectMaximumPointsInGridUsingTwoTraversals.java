package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/13/2017.
 * Given a matrix where every cell represents points. How to collect maximum points using two traversals under following conditions? Let the dimensions of given grid be R x C.
 * 1) The first traversal starts from top left corner, i.e., (0, 0) and should reach left bottom corner, i.e., (R-1, 0). The second traversal starts from top right corner, i.e., (0, C-1) and should reach bottom right corner, i.e., (R-1, C-1)/
 * 2) From a point (i, j), we can move to (i+1, j+1) or (i+1, j-1) or (i+1, j)
 * 3) A traversal gets all points of a particular cell through which it passes. If one traversal has already collected points of a cell, then the other traversal gets no points if goes through that cell again.
 */
public class CollectMaximumPointsInGridUsingTwoTraversals {

    private int[][]arr;

    private int [][][]result;

    private int R ;

    private int C;

    public CollectMaximumPointsInGridUsingTwoTraversals(int[][] arr) {
        this.arr = arr;
        this.R=arr.length;
        this.C=arr[0].length;
        this.result =new int[R][C][C];
    }
    // checks whether a given input is valid or not
    private boolean isValid(int x, int y1, int y2) {
        return (x >= 0 && x < R && y1 >=0 && y1 < C && y2 >=0 && y2 < C);
    }

    public int getMaxUtil(int x, int y1, int y2){
        /*---------- BASE CASES -----------*/
        // if P1 or P2 is at an invalid cell
        if (!isValid(x, y1, y2)) return Integer.MIN_VALUE;

        // if both traversals reach their destinations
        if (x == R-1 && y1 == 0 && y2 == C-1)
            return (y1 == y2)? arr[x][y1]: arr[x][y1] + arr[x][y2];

        // If both traversals are at last row but not at their destination
        if (x == R-1) return Integer.MIN_VALUE;

        // If subproblem is already solved
        if (result[x][y1][y2] != -1)
            return result[x][y1][y2];
        // Initialize answer for this subproblem
        int ans = Integer.MIN_VALUE;

        // this variable is used to store gain of current cell(s)
        int temp = (y1 == y2)? arr[x][y1]: arr[x][y1] + arr[x][y2];

         /* Recur for all possible cases, then store and return the
       one with max value */
        ans = Math.max(ans, temp + getMaxUtil( x+1, y1, y2-1));
        ans = Math.max(ans, temp + getMaxUtil( x+1, y1, y2+1));
        ans = Math.max(ans, temp + getMaxUtil( x+1, y1, y2));

        ans = Math.max(ans, temp + getMaxUtil( x+1, y1-1, y2));
        ans = Math.max(ans, temp + getMaxUtil( x+1, y1-1, y2-1));
        ans = Math.max(ans, temp + getMaxUtil( x+1, y1-1, y2+1));

        ans = Math.max(ans, temp + getMaxUtil( x+1, y1+1, y2));
        ans = Math.max(ans, temp + getMaxUtil( x+1, y1+1, y2-1));
        ans = Math.max(ans, temp + getMaxUtil( x+1, y1+1, y2+1));

        return (result[x][y1][y2] = ans);

    }

    public static void main(String[] args) {
        int arr[][] = {{3, 6, 8, 2},
            {5, 2, 4, 3},
            {1, 1, 20, 10},
            {1, 1, 20, 10},
            {1, 1, 20, 10},
        };
        CollectMaximumPointsInGridUsingTwoTraversals inGridUsingTwoTraversals =new CollectMaximumPointsInGridUsingTwoTraversals(arr);
        inGridUsingTwoTraversals.getMaxUtil(0,0,arr[0].length-1);
    }

}
