package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/6/2017.
 * In a daily share trading, a buyer buys shares in the morning and sells it on same day.
 * If the trader is allowed to make at most 2 transactions in a day, where as second transaction can only start after first one is complete (Sell->buy->sell->buy).
 * Input:   price[] = {10, 22, 5, 75, 65, 80}
 * Output:  87
 * Trader earns 87 as sum of 12 and 75
 * Buy at price 10, sell at 22, buy at 5 and sell at 80
 */
public class MaximumProfitBuyingSellingShareAtMostTwice {

    private int numberOfTransaction ;

    private int priceArrays[];

    private int tempProfitStore [][];

    public MaximumProfitBuyingSellingShareAtMostTwice(int numberOfTransaction, int priceArrays[]) {
        this.numberOfTransaction = numberOfTransaction;
        this.priceArrays = priceArrays;
        this.tempProfitStore =new int[numberOfTransaction][priceArrays.length];
    }

    public int getMaxProfit()
    {
        for(int i=1;i<=numberOfTransaction;i++)
        {
            for(int j=1;i<priceArrays.length;j++)
            {
                int k=0;
                while(k<j)
                {
                    int profitNotDoingAnyTransaction = tempProfitStore[i][k];
                    tempProfitStore[i][j] = Math.max( tempProfitStore[i][j] , (priceArrays[j] - priceArrays[k] ) + tempProfitStore[i-1][j-1]) ;
                    k++;
                }
            }

        }
        return 0;
    }

}
