package com.wfs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Suryasnata on 6/23/2017.
 * Write a program to find the sum of maximum sum subsequence of the given array such that the intgers in the subsequence are sorted in increasing order.
 * if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
 * if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10)
 * if the input array is {10, 5, 4, 3}, then output should be 10
 */
public class MaximumSumIncreasingSubsequence {

    private int[] arr;
    private int[] tempArr1;
    private int[] tempArr2;

    public MaximumSumIncreasingSubsequence(int[] arr) {
        this.arr = arr;
        this.tempArr1 = new int[arr.length];
        this.tempArr2 = new int[arr.length];
    }

    public List maxSumIncreasingSequence() {
        //copy tempArr1 element
        for (int i = 0; i < arr.length; i++)
            tempArr1[i] = arr[i];
        int MAX_INDEX = getMaxSumIncreasingSequence();
        List arrays = new ArrayList();
        int maxvalue = tempArr1[MAX_INDEX];

        while (maxvalue != 0) {
            maxvalue = tempArr1[MAX_INDEX] - arr[MAX_INDEX];
            arrays.add(arr[MAX_INDEX]);
            MAX_INDEX = tempArr2[MAX_INDEX];
        }
        Collections.reverse(arrays);
        return arrays;
    }

    public int getMaxSumIncreasingSequence() {
        int MAX_INDEX = 0;
        for (int i = 1; i < arr.length; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && tempArr1[j] + arr[i] > tempArr1[i]) {
                    tempArr1[i] = tempArr1[j] + arr[i];
                    tempArr2[i] = j;
                    if (tempArr1[MAX_INDEX] < tempArr1[i])
                        MAX_INDEX = i;
                }
        return MAX_INDEX;
    }

    public static void main(String[] args) {
        MaximumSumIncreasingSubsequence maximumSumIncreasingSubsequence =new MaximumSumIncreasingSubsequence(new int[]{1, 101, 2, 3, 100, 4, 5});
        System.out.println("List of maximum sum Increasing Subsequence :  "+maximumSumIncreasingSubsequence.maxSumIncreasingSequence());
    }
}
