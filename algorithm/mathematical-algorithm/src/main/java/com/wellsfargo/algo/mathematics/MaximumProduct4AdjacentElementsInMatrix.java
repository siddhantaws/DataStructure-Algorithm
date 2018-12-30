package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumProduct4AdjacentElementsInMatrix {
    private int arr[][];

    public MaximumProduct4AdjacentElementsInMatrix(int[][] arr) {
        this.arr = arr;
    }

    public int getMaxProduct() {
        int max = 0, result;
        // iterate the rows.
        for (int i = 0; i < arr.length; i++) {
            // iterate the columns.
            for (int j = 0; j < arr[i].length; j++) {
                // check the maximum product in horizontal row.
                if ((j - 3) >= 0) {
                    result = arr[i][j] * arr[i][j - 1] *
                            arr[i][j - 2] * arr[i][j - 3];
                    if (max < result)
                        max = result;
                }
                // check the maximum product in vertical row.
                if ((i - 3) >= 0) {
                    result = arr[i][j] * arr[i - 1][j] *
                            arr[i - 2][j] * arr[i - 3][j];
                    if (max < result)
                        max = result;
                }
                // check the maximum product in diagonal and anti - diagonal
                if ((i - 3) >= 0 && (j - 3) >= 0) {
                    result = arr[i][j] * arr[i - 1][j - 1] *
                            arr[i - 2][j - 2] * arr[i - 3][j - 3];
                    if (max < result)
                        max = result;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 1},
                {2, 3, 4, 5, 6},
                {7, 8, 9, 1, 0},
                {9, 6, 4, 2, 3}};
        MaximumProduct4AdjacentElementsInMatrix elementsInMatrix =new MaximumProduct4AdjacentElementsInMatrix(arr);
        elementsInMatrix.getMaxProduct();
    }
}
