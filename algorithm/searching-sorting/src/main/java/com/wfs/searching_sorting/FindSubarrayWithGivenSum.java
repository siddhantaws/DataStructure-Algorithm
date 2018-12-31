package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindSubarrayWithGivenSum {
    private int arr[];

    private int sum ;
    public FindSubarrayWithGivenSum(int[] arr, int sum) {
        this.arr = arr;
        this.sum=sum;
    }

    public int getSubArray(){
        int currSum=arr[0]; int start =0;
        for(int i=1;i<arr.length-1;i++) {
            currSum =currSum+arr[i];
            if(currSum>sum){
                while(currSum > sum && start<i){
                    currSum =currSum -arr[start++];
                }
            }
            if(currSum==sum)
                return i;
        }
        return -1;
    }
}
