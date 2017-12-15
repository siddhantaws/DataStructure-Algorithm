package com.wellsfargo.data_structure.matrix;

public class LargestRectangleOf1sWithSwappingOfColumnsAllowed {

    private int[][] matrix;
    private int[][] auxMatrix;

    public LargestRectangleOf1sWithSwappingOfColumnsAllowed(int[][] matrix) {
        this.matrix = matrix;
        this.auxMatrix = new int[matrix.length + 1][matrix[0].length + 1];
    }

    public int maxArea() {
        int R = matrix.length, C = matrix[0].length;

        // Step 1: Fill the auxiliary array hist[][]
        for (int i = 0; i < C; i++) {
            // First row in hist[][] is copy of first row in mat[][]
            auxMatrix[0][i] = matrix[0][i];

            // Fill remaining rows of hist[][]
            for (int j = 1; j < R; j++)
                auxMatrix[j][i] = (matrix[j][i] == 0) ? 0 : auxMatrix[j - 1][i] + 1;
        }

        // Step 2: Sort rows of hist[][] in non-increasing order
        for (int i = 0; i < R; i++) {
            int count[] = new int[R + 1];

            // counting occurrence
            for (int j = 0; j < C; j++)
                count[auxMatrix[i][j]]++;

            //  Traverse the count array from right side
            int col_no = 0;
            for (int j = R; j >= 0; j--) {
                if (count[j] > 0) {
                    for (int k = 0; k < count[j]; k++) {
                        auxMatrix[i][col_no] = j;
                        col_no++;
                    }
                }
            }
        }
        // Step 3: Traverse the sorted hist[][] to find maximum area
        int curr_area, max_area = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // Since values are in decreasing order,
                // The area ending with cell (i, j) can
                // be obtained by multiplying column number
                // with value of hist[i][j]
                curr_area = (j + 1) * auxMatrix[i][j];
                if (curr_area > max_area)
                    max_area = curr_area;
            }
        }

        return max_area;
    }

    public static void main(String[] args) {
        LargestRectangleOf1sWithSwappingOfColumnsAllowed largestRectangleOf1sWithSwappingOfColumnsAllowed=new LargestRectangleOf1sWithSwappingOfColumnsAllowed(new int[][]{{0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0}});
        largestRectangleOf1sWithSwappingOfColumnsAllowed.maxArea();
    }
}
