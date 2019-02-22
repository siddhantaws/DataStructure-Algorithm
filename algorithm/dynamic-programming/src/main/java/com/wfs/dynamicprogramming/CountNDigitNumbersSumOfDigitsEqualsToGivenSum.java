package com.wfs.dynamicprogramming;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CountNDigitNumbersSumOfDigitsEqualsToGivenSum {
    private int sum;

    private int n;

    public CountNDigitNumbersSumOfDigitsEqualsToGivenSum(int sum, int n) {
        this.sum = sum;
        this.n = n;
    }

    public void findCount() {

        //in case n = 2 start is 10 and end is (100-1) = 99
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n) - 1;

        int count = 0;
        int i = start;

        while (i < end) {
            int cur = 0;
            int temp = i;

            while (temp != 0) {
                cur += temp % 10;
                temp = temp / 10;
            }

            if (cur == sum) {
                count++;
                i += 9;
            } else
                i++;

        }
    }

    public static void main(String[] args) {
        CountNDigitNumbersSumOfDigitsEqualsToGivenSum givenSum =new CountNDigitNumbersSumOfDigitsEqualsToGivenSum(2,2);
        System.out.println(true ^ true);
        givenSum.findCount();
    }
}
