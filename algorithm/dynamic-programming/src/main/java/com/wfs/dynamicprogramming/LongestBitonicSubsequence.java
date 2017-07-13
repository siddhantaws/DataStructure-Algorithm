package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/5/2017.
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing.
 * Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
 * Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
 */
public class LongestBitonicSubsequence {
    private int arr[];

    private int lcsFromLeft[];

    private int lcsFromRight[];

    public LongestBitonicSubsequence(int[] arr) {
        this.arr = arr;
        this.lcsFromLeft =new int[arr.length];
        this.lcsFromRight =new int[arr.length];
    }




}
