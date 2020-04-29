package com.google.question;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    private int nums[];
    private int k;

    public ContinuousSubarraySum(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
    }

    public boolean checkSubarraySum() {
        int sum = 0;
        Map<Integer, Integer > map = new HashMap<>();
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
        ContinuousSubarraySum subarraySum =new ContinuousSubarraySum(new int[]{23,2,4,6,7},6);
        System.out.println(subarraySum.checkSubarraySum());
    }
}
