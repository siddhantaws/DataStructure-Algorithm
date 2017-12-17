package com.wellsfargo.data_structure.matrix;

public class CollectMaximumPointsInGridUsingTwoTraversals {

    private int[][] matrix;
    private int[][][] tempMatrix;
    private int R;
    private int C;

    public CollectMaximumPointsInGridUsingTwoTraversals(int[][] matrix) {
        this.matrix = matrix;
        this.R = matrix.length;
        this.C = matrix[0].length;
        this.tempMatrix= new int[R][C][C];
    }


    private boolean isValid(int x, int y1, int y2) {
        return (x >= 0 && x < R && y1 >= 0 && y1 < C && y2 >= 0 && y2 < C);
    }

    private int geMaxCollection()
    {
        for(int i=0;i<tempMatrix.length;i++ )
            for(int j=0;j<tempMatrix[i].length;j++ )
                for(int k=0;k<tempMatrix[i][j].length;k++ )
                    tempMatrix[i][j][k]=-1;

        // Calculation maximum value using memoization based function
        // getMaxUtil()
        return getMaxUtil(matrix, tempMatrix, 0, 0, C-1);
    }

    // Driver function to collect max value
    private int getMaxUtil(int arr[][], int mem[][][], int x, int y1, int y2) {
        /*---------- BASE CASES -----------*/
        // if P1 or P2 is at an invalid cell
        if (!isValid(x, y1, y2)) return Integer.MIN_VALUE;

        // if both traversals reach their destinations
        if (x == R - 1 && y1 == 0 && y2 == C - 1)
            return (y1 == y2) ? arr[x][y1] : arr[x][y1] + arr[x][y2];

        // If both traversals are at last row but not at their destination
        if (x == R - 1) return Integer.MIN_VALUE;

        // If subproblem is already solved
        if (mem[x][y1][y2] != -1) return mem[x][y1][y2];

        // Initialize Integer.MIN_VALUE for this subproblem
        int ans = Integer.MIN_VALUE;

        // this variable is used to store gain of current cell(s)
        int temp = (y1 == y2) ? arr[x][y1] : arr[x][y1] + arr[x][y2];

    /* Recur for all possible cases, then store and return the
       one with max value */
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1, y2 - 1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1, y2 + 1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1, y2));

        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 - 1, y2));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 - 1, y2 - 1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 - 1, y2 + 1));

        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 + 1, y2));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 + 1, y2 - 1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x + 1, y1 + 1, y2 + 1));

        return (mem[x][y1][y2] = ans);
    }

    public static void main(String[] args) {
        CollectMaximumPointsInGridUsingTwoTraversals collectMaximumPointsInGridUsingTwoTraversals=new CollectMaximumPointsInGridUsingTwoTraversals(new int[][]{{3, 6, 8, 2},
                {5, 2, 4, 3},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
                {1, 1, 20, 10},
        });
        System.out.println(collectMaximumPointsInGridUsingTwoTraversals.geMaxCollection());
    }
}
