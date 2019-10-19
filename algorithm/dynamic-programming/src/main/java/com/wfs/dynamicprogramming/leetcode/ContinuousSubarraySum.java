package com.wfs.dynamicprogramming.leetcode;

import java.util.HashMap;

/*
* https://leetcode.com/problems/continuous-subarray-sum/solution/
* */
public class ContinuousSubarraySum {
    private int [] nums;

    private int k;
    public ContinuousSubarraySum(int[] nums , int k) {
        this.nums = nums;
        this.k=k;
    }
    public boolean checkSubarraySum() {
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum continuousSubarraySum =new ContinuousSubarraySum(new int[]{2,5,33,6,7,25,15}, 13);
        System.out.println(continuousSubarraySum.checkSubarraySum());
    }
}
