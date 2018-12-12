package com.wellsfargo.algo.backtracking;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Fill8NumbersInGridWithGivenConditions {
    private int grid[][];
    private static int UNASSIGNED = -1;
    int row = 0, col = 0;
    public Fill8NumbersInGridWithGivenConditions(int[][] grid) {
        this.grid = grid;
    }

    // This function finds an entry  in grid that is still unassigned
    private boolean FindUnassignedLocation(int grid[][]) {
        for (row = 0; row < grid.length; row++)
            for (col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == UNASSIGNED)
                    return true;
            }
        return false;
    }

    //* Takes a grid and attempts to assign values to all unassigned locations in such a way to meet the requirements for this solution.*/
    public boolean Solve() {

        // If there is no unassigned location, we are done
        if (!FindUnassignedLocation(grid))
            return true; // success!
        // consider digits 1 to 8
        for (int num = 1; num <= 8; num++) {
            // if looks promising
            if (isSafe(row, col, num)) {
                // make tentative assignment
                grid[row][col] = num;
                // return, if success, yay!
                if (Solve())
                    return true;
                // failure, unmake & try again
                grid[row][col] = UNASSIGNED;
            }
        }
        return false;
    }

    /* A utility function to print grid */
    void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            if (i == 0 || i == grid.length - 1)
                System.out.print(" ");
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    System.out.print(" ");
                else
                    System.out.print(grid[i][j] +" ");
            }
            System.out.println(" ");
        }
    }

    /* Returns a boolean which indicates  whether any assigned entry within the specified grid matches the given number. */
    private boolean UsedInGrid(int num) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == num)
                    return true;
        }
        return false;
    }

    /* Returns a boolean which indicates  whether it will be legal to assign  num to the given row, col location. */
    private boolean isSafe(int row, int col, int num) {
        /* Check if 'num' is not already placed in Whole Grid*/
        if (row == 0 && col == 1) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row][col + 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col]) <= 1)
                    || (Math.abs(num - grid[row + 1][col - 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col + 1]) <= 1))
                return false;
        } else if (row == 0 && col == 2) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row][col - 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col]) <= 1)
                    || (Math.abs(num - grid[row + 1][col + 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col - 1]) <= 1))
                return false;
        } else if (row == 1 && col == 0) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row - 1][col + 1]) <= 1)
                    || (Math.abs(num - grid[row][col + 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col + 1]) <= 1))
                return false;
        } else if (row == 1 && col == 3) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row - 1][col - 1]) <= 1)
                    || (Math.abs(num - grid[row][col - 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col - 1]) <= 1))
                return false;
        } else if (row == 2 && col == 1) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row - 1][col - 1]) <= 1)
                    || (Math.abs(num - grid[row - 1][col]) <= 1)
                    || (Math.abs(num - grid[row - 1][col + 1]) <= 1)
                    || (Math.abs(num - grid[row][col + 1]) <= 1))
                return false;
        } else if (row == 2 && col == 2) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row][col - 1]) <= 1)
                    || (Math.abs(num - grid[row - 1][col]) <= 1)
                    || (Math.abs(num - grid[row - 1][col + 1]) <= 1)
                    || (Math.abs(num - grid[row - 1][col - 1]) <= 1))
                return false;
        } else if (row == 1 && col == 1) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row][col - 1]) <= 1)
                    || (Math.abs(num - grid[row - 1][col]) <= 1)
                    || (Math.abs(num - grid[row - 1][col + 1]) <= 1)
                    || (Math.abs(num - grid[row][col + 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col + 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col]) <= 1))
                return false;
        } else if (row == 1 && col == 2) {
            if (UsedInGrid(num)
                    || (Math.abs(num - grid[row][col - 1]) <= 1)
                    || (Math.abs(num - grid[row - 1][col]) <= 1)
                    || (Math.abs(num - grid[row + 1][col - 1]) <= 1)
                    || (Math.abs(num - grid[row][col + 1]) <= 1)
                    || (Math.abs(num - grid[row - 1][col - 1]) <= 1)
                    || (Math.abs(num - grid[row + 1][col]) <= 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, -1, -1, 0 },
            { -1, -1, -1, -1 },
            { 0, -1, -1, 0 } };
        Fill8NumbersInGridWithGivenConditions numbers =new Fill8NumbersInGridWithGivenConditions(grid);
        numbers.Solve();
        numbers.printGrid();
    }
}
