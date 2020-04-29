package com.google.question;

public class BestTimeBuySellStockWithTransactionFee {
    private int[] prices;
    private int fee;

    public BestTimeBuySellStockWithTransactionFee(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
    }

    public int maxProfit() {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        BestTimeBuySellStockWithTransactionFee withTransactionFee =new BestTimeBuySellStockWithTransactionFee(new int[]{1, 3, 2, 8, 4, 9} , 2);
        System.out.println(withTransactionFee.maxProfit());
    }
}
