package com.wfs.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suryasnata on 6/1/2017.
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4
 * price    | 2   5   7   8
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1) length 5
 */
public class CuttingARod {

    private int lenghtArr[];

    private int priceArr[];

    private int length;

    private int[] tempLengthArray;

    private int[][] tempLengthArray2;

    public CuttingARod(int[] lenghtArr, int[] priceArr, int length) {
        this.lenghtArr = lenghtArr;
        this.priceArr = priceArr;
        this.length = length;
        tempLengthArray = new int[length + 1];
        tempLengthArray2 = new int[priceArr.length][length + 1];
    }

    public int getMaxPrice() {
        for (int i = 0; i < lenghtArr.length; i++)
            for (int j = 1; j <= length; j++)
                if (lenghtArr[i] > j)
                    tempLengthArray[j] = Math.max(tempLengthArray[j], 0);
                else
                    tempLengthArray[j] = Math.max(tempLengthArray[j], tempLengthArray[j - lenghtArr[i]] + priceArr[i]);
        return tempLengthArray[tempLengthArray.length - 1];
    }

    public List getMaxPriceList(){

        List<Integer> integers=new ArrayList<>();
        for (int i = 0; i < lenghtArr.length; i++)
            for (int j = 1; j <= length; j++)
                if (lenghtArr[i] > j)
                    tempLengthArray2[i][j] = Math.max(tempLengthArray2[ i==0  ? 0 : i-1][j], 0);
                else
                    tempLengthArray2[i][j] = Math.max(tempLengthArray2[i==0  ? 0 : i-1][j], tempLengthArray2[i][j - lenghtArr[i]] + priceArr[i]);
        int i=priceArr.length-1; int j =length;

        while(i !=0 || j!=0 )
        {
            if(i!=0 && tempLengthArray2[i][j] == tempLengthArray2[i-1][j])
                i--;

            else
            {
                integers.add(lenghtArr[i]);
                j -=lenghtArr[i];
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        int[] lengthArray = {1, 2, 3, 4};
        int[] priceArray = {2, 5, 7, 8};
        CuttingARod cuttingARod = new CuttingARod(lengthArray, priceArray, 5);
        System.out.println(" getMaxPrice () -->  " + cuttingARod.getMaxPriceList());
    }
}
