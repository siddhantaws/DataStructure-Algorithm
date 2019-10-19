package com.wfs.dynamicprogramming.leetcode;

public class HouseRobber_II {
    private int nums[];

    public HouseRobber_II(int[] arr) {
        this.nums = arr;
    }

    public int maxRobAmount(){
        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int max1 = robHelper(nums, 0, nums.length-2);
        int max2 = robHelper(nums, 1, nums.length-1);

        return Math.max(max1, max2);
    }

    public int robHelper(int[] nums, int i, int j){
        if(i==j){
            return nums[i];
        }

        int[] dp = new int[nums.length];
        dp[i]=nums[i];
        dp[i+1]=Math.max(nums[i+1], dp[i]);

        for(int k=i+2; k<=j; k++){
            dp[k]=Math.max(dp[k-1], dp[k-2]+nums[k]);
        }

        return dp[j];
    }
    public static void main(String[] args) {
        HouseRobber_II a =new HouseRobber_II(new int[]{1,2,3,1});

    }
}
