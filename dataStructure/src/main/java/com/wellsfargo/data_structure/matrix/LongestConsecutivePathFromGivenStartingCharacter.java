package com.wellsfargo.data_structure.matrix;

public class LongestConsecutivePathFromGivenStartingCharacter {

    private char[][] matrix;

    private int[][] tempMatrix;

    private char initialChar;

    public LongestConsecutivePathFromGivenStartingCharacter(char[][] matrix, char initialChar) {
        this.matrix = matrix;
        this.initialChar = initialChar;
        this.tempMatrix = new int[matrix.length][matrix[0].length];
    }

    public void setInitialChar(char initialChar) {
        this.initialChar = initialChar;
    }

    public int getLongestPath() {
        return getLongestPath(matrix ,  initialChar);
    }

    private boolean isvalid(int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
            return false;
        return true;
    }

    private boolean isadjacent(char prev, char curr) {
        return ((curr - prev) == 1);
    }

    private int getLongestPath(char[][] matrix, char s) {
        //assigning all dp values to -1
        for (int i = 0; i < matrix.length; ++i)
            for (int j = 0; j < matrix[0].length; ++j)
                tempMatrix[i][j] = -1;

        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // check for each possible starting point
                if (matrix[i][j] == s) {

                    // recur for all eight adjacent cells
                    ans = Math.max(ans, 1 + getLenUtil(matrix, i, j + 1, s));
                    ans = Math.max(ans, 1 + getLenUtil(matrix, i + 1, j + 1, s));
                    ans = Math.max(ans, 1 + getLenUtil(matrix, i + 1, j, s));
                    ans = Math.max(ans, 1 + getLenUtil(matrix, i + 1, j - 1, s));
                    ans = Math.max(ans, 1 + getLenUtil(matrix, i, j - 1, s));
                    ans = Math.max(ans, 1 + getLenUtil(matrix, i - 1, j - 1, s));
                    ans = Math.max(ans, 1 + getLenUtil(matrix, i - 1, j, s));
                }
            }
        }
        return ans;
    }

    private int getLenUtil(char mat[][], int i, int j, char prev) {
        if (!isvalid(i, j) || !isadjacent(prev, mat[i][j]))
            return 0;
        // If this subproblem is already solved , return the answer
        if (tempMatrix[i][j] != -1)
            return tempMatrix[i][j];
        int ans = 0;  // Initialize answer
        // recur for paths with differnt adjacent cells and store the length of longest path.
        ans = Math.max(ans, 1 + getLenUtil(matrix, i, j + 1, mat[i][j]));
        ans = Math.max(ans, 1 + getLenUtil(matrix, i + 1, j + 1, mat[i][j]));
        ans = Math.max(ans, 1 + getLenUtil(matrix, i + 1, j, mat[i][j]));
        ans = Math.max(ans, 1 + getLenUtil(matrix, i + 1, j - 1, mat[i][j]));
        ans = Math.max(ans, 1 + getLenUtil(matrix, i, j - 1, mat[i][j]));
        ans = Math.max(ans, 1 + getLenUtil(matrix, i - 1, j - 1, mat[i][j]));
        ans = Math.max(ans, 1 + getLenUtil(matrix, i - 1, j, mat[i][j]));
        // save the answer and return
        return tempMatrix[i][j] = ans;
    }

    public static void main(String[] args) {
        LongestConsecutivePathFromGivenStartingCharacter longestConsecutivePathFromGivenStartingCharacter= new LongestConsecutivePathFromGivenStartingCharacter(new char [][] {
                {'a','c','d'},
                { 'h','b','a'},
                { 'i','g','f'}}, 'a');
        System.out.println(longestConsecutivePathFromGivenStartingCharacter.getLongestPath() );
    }
}
