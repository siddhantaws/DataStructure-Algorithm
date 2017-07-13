package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/10/2017.
 * Find length of the longest path from a given character, such that all characters in the path are consecutive to each other,
 * i.e., every character in path is next to previous in alphabetical order.
 * It is allowed to move in all 8 directions from a cell.
 */
public class LongestConsecutivePathFromGivenStartingCharacter {

    static int x[] = {0, 1, 1, -1, 1, 0, -1, -1};
    static int y[] = {1, 0, 1, 1, -1, -1, 0, -1};
    static int R = 3;
    static int C = 3;
    // dp[i][j] Stores length of longest consecutive path
    // starting at arr[i][j].
    static int dp[][] = new int[R][C];

    public static void main(String[] args) {
        char mat[][] = { {'a','c','d'},
                { 'h','b','e'},
                { 'i','g','f'}};
        System.out.println(getLen(mat, 'e') );
    }


    static int getLen(char mat[][], char s)
    {
        //assigning all dp values to -1
        for(int i = 0;i<R;++i)
            for(int j = 0;j<C;++j)
                dp[i][j] = -1;

        int ans = 0;

        for (int i=0; i<R; i++)
        {
            for (int j=0; j<C; j++)
            {
                // check for each possible starting point
                if (mat[i][j] == s) {

                    // recur for all eight adjacent cells
                    for (int k=0; k<8; k++)
                        ans = Math.max(ans, 1 + getLenUtil(mat,
                                i + x[k], j + y[k], s));
                }
            }
        }
        return ans;
    }

    static int getLenUtil(char mat[][], int i, int j, char prev)
    {
        // If this cell is not valid or current character is not
        // adjacent to previous one (e.g. d is not adjacent to b )
        // or if this cell is already included in the path than return 0.
        if (!isvalid(i, j) || !isadjacent(prev, mat[i][j]))
            return 0;

        // If this subproblem is already solved , return the answer
        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;  // Initialize answer

        // recur for paths with differnt adjacent cells and store
        // the length of longest path.
        for (int k=0; k<8; k++)
            ans = Math.max(ans, 1 + getLenUtil(mat, i + x[k],
                    j + y[k], mat[i][j]));

        // save the answer and return
        return dp[i][j] = ans;
    }

    static boolean isvalid(int i, int j)
    {
        if (i < 0 || j < 0 || i >= R || j >= C)
            return false;
        return true;
    }

    // Check whether current character is adjacent to previous
    // character (character processed in parent call) or not.
    static boolean isadjacent(char prev, char curr)
    {
        return ((curr - prev) == 1);
    }
}
