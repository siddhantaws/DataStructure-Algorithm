package com.wellsfargo.data_structure.matrix;

/**
 * Given an n x n matrix mat[n][n] of integers, find the maximum value of mat(c, d) – mat(a, b) over all choices of indexes such that both c > a and d > b.
 */
public class FindASpecificPairInMatrix {
    private int[][]matrix;
    private int[][]tempMatrix;
    private int n;

    public FindASpecificPairInMatrix(int[][] matrix , int n) {
        this.matrix = matrix;
        this.tempMatrix=new int[matrix.length][matrix[0].length];
        this.n=n;
    }

    public int findMaxDiff()
    {
        int maxValue = Integer.MIN_VALUE;
        tempMatrix[n-1][n-1] = matrix[n-1][n-1];

        // preprocess last row
        int maxv = matrix[n-1][n-1];  // Initialize max
        for (int j = n - 2; j >= 0; j--)
        {
            if (matrix[n-1][j] > maxv)
                maxv = matrix[n - 1][j];
            tempMatrix[n-1][j] = maxv;
        }

        // preprocess last column
        maxv = matrix[n - 1][n - 1];  // Initialize max
        for (int i = n- 2; i >= 0; i--)
        {
            if (matrix[i][n - 1] > maxv)
                maxv = matrix[i][n - 1];
            tempMatrix[i][n - 1] = maxv;
        }

        for (int i = n-2; i >= 0; i--)
        {
            for (int j = n-2; j >= 0; j--)
            {
                // Update maxValue
                if (tempMatrix[i+1][j+1] - matrix[i][j] > maxValue)
                    maxValue = tempMatrix[i + 1][j + 1] - matrix[i][j];

                // set maxArr (i, j)
                tempMatrix[i][j] = Math.max(matrix[i][j],
                        Math.max(tempMatrix[i][j + 1],
                                tempMatrix[i + 1][j]) );
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        FindASpecificPairInMatrix findASpecificPairInMatrix=new FindASpecificPairInMatrix(new int[][]{
                { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 6, 1, 3 },
                { -4, -1, 1, 7, -6 },
                { 0, -4, 10, -5, 1 }
        } , 5);
        System.out.println(findASpecificPairInMatrix.findMaxDiff());
    }
}

