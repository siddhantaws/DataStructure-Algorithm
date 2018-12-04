/*
package com.wfs.devideConqur;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class KthSmallestSumContinuousSubarraysPositiveNumbers {

    private int arr[];

    private int k;

    public KthSmallestSumContinuousSubarraysPositiveNumbers(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    int CalculateRank(List<Integer> prefix, int n, int x) {
        int cnt;

        // Initially rank is 0.
        int rank = 0;
        int sumBeforeIthindex = 0;
        for (int i = 0; i < n; ++i) {

            // Calculating the count the subarray with
            // starting at ith index
            cnt = upper_bound(prefix.begin(), prefix.end(),
                    sumBeforeIthindex + x) - prefix.begin();

            // Subtracting the subarrays before ith index.
            cnt -= i;

            // Adding the count to rank.
            rank += cnt;
            sumBeforeIthindex = prefix[i];
        }
        return rank;
    }

    int findKthSmallestSum(int a[], int n, int k) {
        // PrefixSum array.
        List<Integer> prefix = new ArrayList<>();

        // Total Sum initially 0.
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += a[i];
            prefix.add(sum);
        }

        // Binary search on possible
        // range i.e [0, total sum]
        int ans = 0;
        int start = 0, end = sum;
        while (start <= end) {

            int mid = (start + end) >> 1;

            // Calculating rank of the mid and
            // comparing with K
            if (CalculateRank(prefix, n, mid) >= k) {

                // If greater or equal store the answer
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
*/
