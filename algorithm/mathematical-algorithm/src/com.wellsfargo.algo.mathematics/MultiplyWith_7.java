package com.wellsfargo.algo.mathematics;

/**
 * Created by Suryasnata on 4/25/2017.
 *
 * We can multiply a number by 7 using bitwise operator. First left shift the number by 3 bits
 * (you will get 8n) then subtract the original numberfrom the shifted number and return the difference (8n – n).
 */

public class MultiplyWith_7 {

    public static void main(String[] args) {
        System.out.println(new MultiplyWith_7().multiplyWith7(20));
    }
    private long multiplyWith7(int num)
    {
        return (num <<3 ) - num ;
    }
}
