package com.wfs.devideConqur;

public class PeakElementIn2DArray {

    private int[][] matrix;

    public PeakElementIn2DArray(int[][] matrix) {
        this.matrix = matrix;
    }

    public  int findPeak() {
        return findPeakRec( matrix.length, matrix[0].length, matrix[0].length/2);
    }

    private int findMax(int rows, int mid) {
        int max_index = 0;
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            if (max < matrix[i][mid]) {
                // Saving global maximum and its index to check its neighbours
                max = matrix[i][mid];
                max_index = i;
            }
        }
        return max_index;
    }

    private int findPeakRec(int rows, int columns, int mid) {

        int max_index = findMax(rows, mid);
        // If we are on the first or last column, max is a peak
        int max = matrix[max_index][mid];
        if (mid == 0 || mid == columns-1)
            return max;
        // If mid column maximum is also peak
        if (max >= matrix[max_index][mid-1] &&
                max >= matrix[max_index][mid+1])
            return max;
        // If max is less than its left
        if (max < matrix[max_index][mid-1])
            return findPeakRec(rows, columns, mid - mid/2);
        // If max is less than its left if (max < arr[max_index][mid+1])
        return findPeakRec(rows, columns, mid+mid/2);
    }

    public static void main(String[] args) {
        int arr[][] = { { 10, 8, 10, 10 },
                        { 14, 13, 12, 11 },
                        { 15, 9, 11, 21 },
                        { 16, 17, 19, 20 } };
        PeakElementIn2DArray element =new PeakElementIn2DArray(arr);
        System.out.println(element.findPeak());
    }
}
