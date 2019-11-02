package com.amazon.question;

import java.util.Arrays;

public class CoinChangeII {
    private int amount;

    private int[] coins;

    public CoinChangeII(int amount, int[] coins) {
        this.amount = amount;
        this.coins = coins;
    }

    public int change() {
        int arr[] =new int[amount+1];
        arr[0] =1 ;
        Arrays.sort(coins);
        for(int i=0;i<coins.length;i++)
            for(int j=1;j<arr.length;j++)
                if(j<coins[i])
                    continue;
                else
                    arr[j] +=arr[j-coins[i]];
        return arr[arr.length-1];
    }


    public static void main(String[] args) {
        CoinChangeII coinChangeII =new CoinChangeII(10,new int[]{10});
        System.out.println(coinChangeII.change());
    }
}
