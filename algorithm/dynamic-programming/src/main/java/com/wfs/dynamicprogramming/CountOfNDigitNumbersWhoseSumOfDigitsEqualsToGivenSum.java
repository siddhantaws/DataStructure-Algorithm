package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/18/2017.
 */
public class CountOfNDigitNumbersWhoseSumOfDigitsEqualsToGivenSum {

    private int n ;
    private int sum ;

    public CountOfNDigitNumbersWhoseSumOfDigitsEqualsToGivenSum(int n, int sum) {
        this.n = n;
        this.sum = sum;
    }

    public  int finalCount()
    {
        return  finalCount(n,sum);
    }

    public  int finalCount(int n, int sum)
    {
        // Initialize final answer
        int ans = 0;

        // Traverse through every digit from 1 to
        // 9 and count numbers beginning with it
        for (int i = 1; i <= 9; i++)
            if (sum-i >= 0)
                ans += countRec(n-1, sum-i);

        return ans;
    }

    private int countRec(int n, int sum)
    {
        // Base case
        if (n == 0)
            return sum == 0 ?1:0;

        // Initialize answer
        int ans = 0;

        // Traverse through every digit and count
        // numbers beginning with it using recursion
        for (int i=0; i<=9; i++)
            if (sum-i >= 0)
                ans += countRec(n-1, sum-i);

        return ans;
    }

    public static void main(String[] args) {
        CountOfNDigitNumbersWhoseSumOfDigitsEqualsToGivenSum countOfNDigitNumbersWhoseSumOfDigitsEqualsToGivenSum=new CountOfNDigitNumbersWhoseSumOfDigitsEqualsToGivenSum(2 ,5);
        countOfNDigitNumbersWhoseSumOfDigitsEqualsToGivenSum.finalCount();
    }
}
