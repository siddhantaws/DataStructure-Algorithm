package com.wellsfargo.algo.backtracking;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PlaceKKnightsTheyDoNotAttackEachOther {

    private int row, col, k, count;

    public PlaceKKnightsTheyDoNotAttackEachOther(int row, int col, int k) {
        this.row = row;
        this.col = col;
        this.k = k;
    }

    private String[][] makeBoard() {
        String board[][] = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = "_";
            }
        }
        return board;
    }

    private void displayBoard(String board[][]) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\t" + board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    /* If the position is empty,  place the knight */
    private boolean canPlace(int i, int j, String board[][]) {
        return board[i][j] == "_";
    }

    /* This function marks all the attacking  position of a knight placed at board[i][j] position */
    private void attack(int i, int j, String a, String board[][]) {
        /* conditions to ensure that the block to be checked is inside the board */
        if ((i + 2) < row && (j - 1) >= 0) {
            board[i + 2][j - 1] = a;
        }
        if ((i - 2) >= 0 && (j - 1) >= 0) {
            board[i - 2][j - 1] = a;
        }
        if ((i + 2) < row && (j + 1) < col) {
            board[i + 2][j + 1] = a;
        }
        if ((i - 2) >= 0 && (j + 1) < col) {
            board[i - 2][j + 1] = a;
        }
        if ((i + 1) < row && (j + 2) < col) {
            board[i + 1][j + 2] = a;
        }
        if ((i - 1) >= 0 && (j + 2) < col) {
            board[i - 1][j + 2] = a;
        }
        if ((i + 1) < row && (j - 2) >= 0) {
            board[i + 1][j - 2] = a;
        }
        if ((i - 1) >= 0 && (j - 2) >= 0) {
            board[i - 1][j - 2] = a;
        }
    }

    /* Place the knight at [i][j] position  on board */
    void place(int i, int j, String k, String a, String board[][], String[][] new_board) {
        /* Copy the configurations of old board to new board */
        for (int y = 0; y < row; y++) {
            for (int z = 0; z < col; z++) {
                new_board[y][z] = board[y][z];
            }
        }
        /* Place the knight at [i][j] position on new board */
        new_board[i][j] = k;
        /* Mark all the attacking positions of newly placed knight on the new board */
        attack(i, j, a, new_board);
    }

    public void kkn() {
        kkn(k, 0, 0, makeBoard());
    }
    /* Function for placing knights on board such that they don't attack each other */
    private void kkn(int k, int sti, int stj, String[][] board) {
        /* If there are no knights left to be placed, display the board and increment the count */
        if (k == 0) {
            displayBoard(board);
            count++;
        } else {
            /* Loop for checking all the positions on m*n board */
            for (int i = sti; i < row; i++) {
                for (int j = stj; j < col; j++) {
                    /* Is it possible to place knight at [i][j] position on board? */
                    if (canPlace(i, j, board)) {
                        /* Create a a new board and place the new knight on it */
                        String[][] new_board = new String[row][col];
                        place(i, j, "K", "A", board, new_board);
                        /* Call the function recursively for (k-1) leftover knights */
                        kkn(k - 1, i, j, new_board);
                    }
                }
                stj = 0;
            }
        }
    }

    public static void main(String[] args) {
        PlaceKKnightsTheyDoNotAttackEachOther attackEachOther = new PlaceKKnightsTheyDoNotAttackEachOther(4, 3, 6);
        attackEachOther.kkn();
        System.out.println(attackEachOther.count);
    }
}
