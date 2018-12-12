package com.wellsfargo.algo.backtracking;

import com.wellsfargo.data_structure.matrix.Point;

public class Sudoku {

    private int arr[][];

    private static final int UNASSIGNED = 0;

    public Sudoku(int[][] arr) {
        this.arr = arr;
    }

    public boolean isSafe(int row, int col, int num) {
        // row has the unique (row-clash)
        for (int d = 0; d < arr.length; d++) {
            // if the number we are trying to place is already present in that row, return false;
            if (arr[row][d] == num) {
                return false;
            }
        }
        // column has the unique numbers (column-clash)
        for (int r = 0; r < arr.length; r++) {
            // if the number we are trying to place is already present in that column, return false;
            if (arr[r][col] == num) {
                return false;
            }
        }
        // corresponding square has unique number (box-clash)
        int sqrt = (int) Math.sqrt(arr.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (arr[r][d] == num) {
                    return false;
                }
            }
        }
        // if there is no clash, it's safe
        return true;
    }
    public boolean solveSudoku(){
        return solveSudoku(arr.length);
    }
    public boolean solveSudoku(int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == UNASSIGNED) {
                    row = i;
                    col = j;
                    // we still have some remaining  missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        // no empty space left
        if (isEmpty) {
            return true;
        }
        // else for each-row backtrack
        for (int num = 1; num <= n; num++) {
            if (isSafe(row, col, num)) {
                arr[row][col] = num;
                if (solveSudoku(n)) {
                    // print(board, n);
                    return true;
                } else {
                    arr[row][col] = 0; // replace it
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };

        Sudoku sudoku = new Sudoku(board);
        sudoku.solveSudoku();
    }
}
