package com.amazon.question;

public class SudokuSolver {

    private char[][] board;

    private final int N;

    public SudokuSolver(char[][] board) {
        this.board = board;
        this.N = board.length;
    }

    public void solveSudoku() {
        solve(0, 0);
    }

    private boolean solve(int i, int j) {
        if (i == N - 1 && j == N - 1)
            return true;
        if (j == N - 1)
            j = 0;
        for (int i1 = i; i1 < N; i1++)
            for (int j1 = j; j1 < N; j1++) {
                if (board[i1][j1] == '.') {
                    for (int a = 1; a <= 9; a++)
                        if (isSafe(i1, j1, a)) {
                            board[i1][j1] = (char) a;
                        }
                    if (!solve(i1, j1))
                        board[i1][j1] = '.';
                }
            }
        return false;
    }

    private boolean isSafe(int i, int j, int a) {
        //search in row
        for (int k = 0; k < 9; k++) {
            if (k == j)
                continue;
            if (board[i][k] == a)
                return false;
        }
        //search in Cl
        for (int k = 0; k < 9; k++) {
            if (k == i)
                continue;
            if (board[k][j] == a)
                return false;
        }
        return true;
    }
}
