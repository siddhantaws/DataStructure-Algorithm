
package com.wfs.devideConqur;


/**
 * @author Siddhanta Kumar Pattnaik
 *
 * */

public class KthSmallestSumContinuousSubarraysPositiveNumbers {
    private int a[];
    private int k;

    public KthSmallestSumContinuousSubarraysPositiveNumbers(int[] arr, int k) {
        this.a = arr;
        this.k = k;
    }

    private int kthSmallestSumContinuousSubarrays() {
        int prefix[] = new int[a.length];
        prefix[0] = a[0];
        for (int i = 1; i < a.length; i++)
            prefix[i] = prefix[i - 1] + a[i];

        int maxSum = prefix[a.length - 1];
        int start = 0;
        int end = maxSum;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) >> 1;

            if (rank(prefix, mid) >= k) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    private static int rank(int[] prefix, int mid) {
        int sumBeforeIthIndex = 0;
        int rank = 0;
        int count = 0;
        for (int i = 0; i < prefix.length; i++) {
            count = upperBound(prefix, sumBeforeIthIndex + mid);
            count -= i;
            rank += count;
            sumBeforeIthIndex = prefix[i];
        }
        return rank;
    }

    /**
     * Return the index of element which is greater then <x> if found
     * otherwise array length.
     *
     * @param prefix
     * @param x
     * @return
     */
    private static int upperBound(int prefix[], int x) {
        int start = 0;
        int end = prefix.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (prefix[mid] == x) {
                ans = mid + 1;
                break;
            }

            if (prefix[mid] > x) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;

        }
        return ans == -1 ? prefix.length : ans;
    }

    public static void main(String args[]) {
        KthSmallestSumContinuousSubarraysPositiveNumbers positiveNumbers =new KthSmallestSumContinuousSubarraysPositiveNumbers(new int[] {1, 2, 3, 4, 5, 6}, 3);
        System.out.println(positiveNumbers.kthSmallestSumContinuousSubarrays());
       // System.out.println(positiveNumbers.kthSmallestSumContinuousSubarrays());
        System.out.println(upperBound(new int[]{1,2,4,6,10,15}, 7));

    }
}

