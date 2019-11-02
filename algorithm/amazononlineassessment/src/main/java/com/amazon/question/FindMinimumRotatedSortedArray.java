package com.amazon.question;

public class FindMinimumRotatedSortedArray {

    public int findMin(int[] nums) {

        int l =0; int r=nums.length-1;
        while(l<r){
            int mid = l+ (r-l)/2;
            if(l==mid && mid+1==r)
                return mid+1;
            if(l==mid)
                return nums[l]>nums[r] ? nums[r] : nums[l];
            if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])
                return mid;
            else if(nums[mid]>nums[l] && nums[mid]>nums[r])
                l =mid+1;
            else
                r=mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMinimumRotatedSortedArray sortedArray =new FindMinimumRotatedSortedArray();
        System.out.println(sortedArray.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
