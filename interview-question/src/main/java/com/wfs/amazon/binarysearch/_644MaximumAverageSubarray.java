package com.wfs.amazon.binarysearch;

public class _644MaximumAverageSubarray {
    private int nums[];

    private int K;

    public _644MaximumAverageSubarray(int[] arr, int k) {
        this.nums = arr;
        K = k;
    }
    public double findMaxAverage() {
        double l;
        double r;
        double m;
        l = r = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        while (l + 1e-10 < r) {
            m = l + (r - l) / 2;
            if (canFind(nums, K, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }
    private boolean canFind(int[] nums, int k, double m) {
        double rightSum = 0;
        double leftSum = 0;
        double minLeftSum = 0;
        for (int i = 0; i < k; ++i) {
            rightSum += nums[i] - m;
        }
        for (int i = k; i <= nums.length; ++i) {
            if (rightSum - minLeftSum >= 0) {
                return true;
            }
            if (i < nums.length) {
                rightSum += nums[i] - m;
                leftSum += nums[i - k] - m;
                minLeftSum = Math.min(minLeftSum, leftSum);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _644MaximumAverageSubarray subarray =new _644MaximumAverageSubarray(new int[]{1,12,-5,-6,50,3}, 4);
        System.out.println(subarray.findMaxAverage());
    }
}
