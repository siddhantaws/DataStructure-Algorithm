package com.wfs.orderstatistics;

public class MaximumSubarraySumUsingPrefixSum {

    private int arr[];
    private int prefixSum[];

    public MaximumSubarraySumUsingPrefixSum(int[] arr) {
        this.arr = arr;
        this.prefixSum=new int[arr.length];
        this.prefixSum[0]= arr[0];
        for (int i = 1; i < arr.length; i++)
            prefixSum[i] = prefixSum[i - 1]+ arr[i];
    }

    public int getAMaxSumSubArray(){
        int res=Integer.MIN_VALUE;
        int minPrefixSum = 0;
        for(int i=0;i<arr.length;i++){
            res= Math.max(res , prefixSum[i]-minPrefixSum);
            minPrefixSum =Math.min(minPrefixSum , prefixSum[i]);
        }
        return res;
    }
}
