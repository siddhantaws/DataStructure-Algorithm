package com.wfs.devideConqur;

public class MaximumSubarraySum {

    private int arr[];

    public MaximumSubarraySum(int[] arr) {
        this.arr = arr;
    }

    public int getMaxSubarraySum(){
        return getMaxSubarraySum(0 ,arr.length-1);
    }

    private int getMaxSubarraySum(int l ,int r){
        if(l==r)
            return arr[l];
        if(l>r){
            return Integer.MIN_VALUE;
        }else {
            int mid =l +(r-l)/2;
            int leftMaxSubArray = getMaxSubarraySum(l,mid);
            int rightMaxSubArray = getMaxSubarraySum(mid+1,r);
            int cornerMaxSubArray = getMaxSubArrayCorner(l, mid , r);
            leftMaxSubArray = Math.max(leftMaxSubArray,  rightMaxSubArray);
            return Math.max(leftMaxSubArray , cornerMaxSubArray);
        }
    }

    private int getMaxSubArrayCorner(int l , int mid, int r){
        int leftCornerSubArray =Integer.MIN_VALUE;int sum=0;
        for(int i=mid;i>=l;i--){
            sum+= arr[i];
            if(sum>leftCornerSubArray)
                leftCornerSubArray =sum;
        }
        int rightCornerSubArray =Integer.MIN_VALUE;sum=0;
        for(int i=mid+1;i<=r;i++){
            sum+= arr[i];
            if(sum>rightCornerSubArray)
                rightCornerSubArray =sum;
        }
        return leftCornerSubArray + rightCornerSubArray;
    }

    public static void main(String[] args) {
        MaximumSubarraySum subarraySum =new MaximumSubarraySum(new int[] {2, 3, 4, 5, 7});
        System.out.println(subarraySum.getMaxSubarraySum());
    }
}
