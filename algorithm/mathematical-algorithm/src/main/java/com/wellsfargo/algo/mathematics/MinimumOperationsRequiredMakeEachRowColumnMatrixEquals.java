package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumOperationsRequiredMakeEachRowColumnMatrixEquals {
    private int n;

    private int matrix [][];
    int count=1;

    public MinimumOperationsRequiredMakeEachRowColumnMatrixEquals(int n) {
        this.n = n;
        this.matrix =new int[n][n];
        fill();
    }

    private void fill(){

        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++)
                matrix[i][j] =count++;
    }

    public int minNumberOfOperation(){
        // Initialize the sumRow[] and sumCol[] array to 0
        int[] sumRow = new int[n];
        int[] sumCol = new int[n];
        // Calculate sumRow[] and sumCol[] array
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                sumRow[i] += matrix[i][j];
                sumCol[j] += matrix[i][j];
            }
        // Find maximum sum value in either row or in column
        int maxSum = 0;
        for (int i = 0; i < n; ++i) {
            maxSum = Math.max(maxSum, sumRow[i]);
            maxSum = Math.max(maxSum, sumCol[i]);
        }
        count = 0;
        for (int i = 0, j = 0; i < n && j < n;) {
            // Find minimum increment required in either row  or column
            int diff = Math.min(maxSum - sumRow[i],
                    maxSum - sumCol[j]);
            // Add difference in corresponding cell, sumRow[] and sumCol[] array
            matrix[i][j] += diff;
            sumRow[i] += diff;
            sumCol[j] += diff;
            // Update the count variable
            count += diff;

            // If ith row satisfied, increment ith value for next iteration
            if (sumRow[i] == maxSum)
                ++i;
            // If jth column satisfied, increment jth value for next iteration
            if (sumCol[j] == maxSum)
                ++j;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumOperationsRequiredMakeEachRowColumnMatrixEquals rowColumnMatrixEquals =new MinimumOperationsRequiredMakeEachRowColumnMatrixEquals(2);
        System.out.println(rowColumnMatrixEquals.minNumberOfOperation());
    }

}
