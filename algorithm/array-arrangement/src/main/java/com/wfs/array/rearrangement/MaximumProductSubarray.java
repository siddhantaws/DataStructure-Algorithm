package com.wfs.array.rearrangement;

public class MaximumProductSubarray {
    private int arr[];

    public MaximumProductSubarray(int[] arr) {
        this.arr = arr;
    }

    public int getMaxProductSubArray(){
        int max=Integer.MIN_VALUE;
        int minEndingHere =1;
        int maxEndingHere =1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                maxEndingHere*=arr[i];
                max= Math.max(maxEndingHere , max);
                minEndingHere = Math.min(minEndingHere ,minEndingHere*arr[i]);
            } else if(arr[i]<0){
                max= Math.max(minEndingHere*arr[i] , max);
                minEndingHere = Math.min(minEndingHere ,minEndingHere*arr[i]);
            }else{
                minEndingHere=1;
                maxEndingHere=1;
            }
        }
        return max;
    }
}
