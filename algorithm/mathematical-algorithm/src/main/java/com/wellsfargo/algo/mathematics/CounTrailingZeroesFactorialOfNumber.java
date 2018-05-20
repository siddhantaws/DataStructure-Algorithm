package com.wellsfargo.algo.mathematics;

public class CounTrailingZeroesFactorialOfNumber {

    private int n;

    public CounTrailingZeroesFactorialOfNumber(int n) {
        this.n = n;
    }

    int findTrailingZeros()
    {
        // Initialize result
        int count = 0;

        /*
        Keep dividing n by powers
        of 5 and update count
        */
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;

        return count;
    }

    public static void main(String[] args) {
        CounTrailingZeroesFactorialOfNumber count= new CounTrailingZeroesFactorialOfNumber(25);
        System.out.println(count.findTrailingZeros());
    }
}
