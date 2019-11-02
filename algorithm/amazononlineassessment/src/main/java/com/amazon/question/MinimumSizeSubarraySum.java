package com.amazon.question;

public class MinimumSizeSubarraySum {

    private int [] nums;

    private int s ;

    public MinimumSizeSubarraySum(int[] nums, int s) {
        this.nums = nums;
        this.s = s;
    }

    public int minSubArrayLen1() {
        int n =  nums.length;
        int ans=Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    public int minSubArrayLen2() {
       int minLength=Integer.MAX_VALUE;
       int l=0;int r=0; int currSum=nums[l];
       while(l<nums.length){
           if(currSum==s){
               minLength = Math.min(minLength , r-l+1);
               currSum-= nums[l];
               l++;
           }else if(currSum>s){
               currSum-= nums[l];
               l++;
           }else{
               if(r==nums.length-1)
                   break;
               r++;
               currSum+= nums[r];
           }
       }
       return minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum subarraySum =new MinimumSizeSubarraySum(new int[]{1,2,3,4,5},11);
        System.out.println(subarraySum.minSubArrayLen1());
    }
}
