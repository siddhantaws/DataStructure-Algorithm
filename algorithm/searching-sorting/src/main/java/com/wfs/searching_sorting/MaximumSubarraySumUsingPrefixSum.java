package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumSubarraySumUsingPrefixSum {

    private int arr[];

    public MaximumSubarraySumUsingPrefixSum(int[] arr) {
        this.arr = arr;
    }

    public int maximumSumSubarray() {// Function to compute maximum subarray sum in linear time.
        // Initialize minimum prefix sum to 0.
        int min_prefix_sum = 0;
        // Initialize maximum subarray sum so far to -infinity.
        int res = Integer.MIN_VALUE;
        // Initialize and compute the prefix sum array.
        int n =arr.length;
        int prefix_sum[] = new int[n];
        prefix_sum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        // loop through the array, keep track of minimum prefix sum so far and maximum subarray sum.
        for (int i = 0; i < n; i++) {
            res = Math.max(res, prefix_sum[i] - min_prefix_sum);
            min_prefix_sum = Math.min(min_prefix_sum, prefix_sum[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={-2, -3, 4, -1, -2, 1, 5, -3};
        MaximumSubarraySumUsingPrefixSum usingPrefixSum =new MaximumSubarraySumUsingPrefixSum(arr);
        System.out.println(usingPrefixSum.maximumSumSubarray());
    }
}
