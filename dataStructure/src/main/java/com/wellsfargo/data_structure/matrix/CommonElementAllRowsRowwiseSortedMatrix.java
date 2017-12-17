package com.wellsfargo.data_structure.matrix;

public class CommonElementAllRowsRowwiseSortedMatrix {

    private int[][] matrix;
    private int[] tempMatrix;

    public CommonElementAllRowsRowwiseSortedMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.tempMatrix = new int[matrix.length];
    }

    public int getCommonElement() {
        for (int i = 0; i < tempMatrix.length; i++)
            tempMatrix[i] = matrix[0].length;
        int min = getColumnMin(matrix[0].length-1);
        while (min > 0) {
            //Do Binary Search for all rows
            for (int i = 0; i < matrix.length; i++) {
                tempMatrix[i] = getLastIndex(i, tempMatrix[i], min);
                min = Math.min(min, matrix[i][tempMatrix[i]]);
            }
        }
        return min;
    }

    private int getColumnMin(int j) {
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++)
            MIN = Math.min(MIN, matrix[i][j]);
        return MIN;
    }

    private int getLastIndex(int row, int last, int min) {
        int start = 0;
        int end = last, mid = 0;
        while (end > start) {
            mid = (start + end) / 2;
            if (matrix[row][mid] == min)
                return mid;
            else if (matrix[row][mid] > min)
                end = mid;
             else if(start==mid || end ==mid)
                return mid;
             else
                 start =mid;
        }
        return mid;
    }

    public static void main(String[] args) {
        CommonElementAllRowsRowwiseSortedMatrix commonElementAllRowsRowwiseSortedMatrix = new CommonElementAllRowsRowwiseSortedMatrix(new int[][]{
                {1, 2, 3, 4, 8},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
        });
        commonElementAllRowsRowwiseSortedMatrix.getCommonElement();
    }
}
