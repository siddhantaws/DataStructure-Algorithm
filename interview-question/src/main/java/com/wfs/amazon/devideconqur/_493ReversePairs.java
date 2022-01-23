/*
package com.wfs.amazon.devideconqur;

public class _493ReversePairs {
    private int[] nums;

    private int tempArr[];
    public _493ReversePairs(int[] nums) {
        this.nums = nums;
        this.tempArr =new int[nums.length];
    }

    public int reversePairs() {
        return reversePairs(0 , nums.length-1);
    }

    private int reversePairs(int l, int r) {
        if(l>r)
            return 0;
        int mid = l + (r-l)/2;
        int left = reversePairs(l,mid);
        int right = reversePairs(mid+1,r);
        return left + right + merge(l ,mid+1,r );
    }
    private int merge(int l, int mid ,int r){
        int count =0;
        int x =l; int y =mid;

        while(x<mid && y<r){
            if(nums[x]<nums[y]){
                tempArr[l++] =nums[y++];
            }else {
                count+= 2*nums[y] < nums[x] ? 0 : 1;
                tempArr[l++] =nums[x++];
            }
        }
        while(x<mid){
            tempArr[l++] =nums[x++];
        }
        int lastPos =0;
        while(y<r){

            tempArr[l++] =nums[y++];

        }
        System.arraycopy(tempArr,l,nums,l,r-l+1);
    }


}
*/
