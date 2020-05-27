package com.wfs.dynamicprogramming;

public class MinimumInitialPointsReachDestination {
    private int points[][];

    private int R;

    private int C;

    private int dpArr[][];
    public MinimumInitialPointsReachDestination(int[][] points) {
        this.points = points;
        this.R=points.length;
        this.C=points.length;
        this.dpArr =new int[R][C];
    }

    public int getInitialPoint(){
        int m = R, n = C;
        // Base case
        dpArr[m-1][n-1] = dpArr[m-1][n-1] > 0? 1: Math.abs(points[m-1][n-1]) + 1;
        // Fill last row and last column as base to fill entire table
        for (int i = m-2; i >= 0; i--)
            dpArr[i][n-1] = Math.max(dpArr[i+1][n-1] - points[i][n-1], 1);
        for (int j = n-2; j >= 0; j--)
            dpArr[m-1][j] = Math.max(dpArr[m-1][j+1] - points[m-1][j], 1);

        // fill the table in bottom-up fashion
        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                int min_points_on_exit = Math.min(dpArr[i+1][j], dpArr[i][j+1]);
                dpArr[i][j] = Math.max(min_points_on_exit - points[i][j], 1);
            }
        }

        return dpArr[0][0];
    }

    public static void main(String[] args) {
        int points[][] = { {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        MinimumInitialPointsReachDestination reachDestination =new MinimumInitialPointsReachDestination(points);
        System.out.println("Minimum Initial Points Required: "+ reachDestination.getInitialPoint() );
    }
}
