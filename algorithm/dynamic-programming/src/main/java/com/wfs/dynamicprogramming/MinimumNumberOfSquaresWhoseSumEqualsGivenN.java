package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/12/2017.
 */
public class MinimumNumberOfSquaresWhoseSumEqualsGivenN {

    private int num;

    public MinimumNumberOfSquaresWhoseSumEqualsGivenN(int num) {
        this.num = num;
    }

    public int getMinSquares()
    {
        return getMinSquares(num);
    }

    private int getMinSquares(int num)
    {
        // Create a dynamic programming table
        // to store sq
        int dp[] = new int[num+1];

        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // getMinSquares rest of the table using recursive
        // formula
        for (int i = 4; i <= num; i++)
        {
            // max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;

            // Go through all smaller numbers to
            // to recursively find minimum
            int temp=0;
            for (int x = 1; (temp= x*x) <= i; x++)
                dp[i] = Math.min(dp[i], 1+dp[i-temp]);
        }

        // Store result and free dp[]
        int res = dp[num];

        return res;
    }
    public static void main(String args[])
    {
        MinimumNumberOfSquaresWhoseSumEqualsGivenN  minimumNumberOfSquaresWhoseSumEqualsGivenN=new MinimumNumberOfSquaresWhoseSumEqualsGivenN(6);
        System.out.println(minimumNumberOfSquaresWhoseSumEqualsGivenN.getMinSquares());
    }
}
