package com.wfs.twopointer;

public class TappingRainWater {
    private int arr[];

    public TappingRainWater(int[] arr) {
        this.arr = arr;
    }

    public int getWater(){
        int leftMax=0; int rightMax=0;
        int l=0;int r=arr.length-1;
        int totalWater= 0;
        while(l<r){
            if(arr[l]>arr[r]){
                if(arr[r]>rightMax)
                    rightMax= arr[r];
                else
                    totalWater +=  rightMax -arr[r--];
            }else{
                if(arr[l]>leftMax)
                    leftMax= arr[l];
                else
                    totalWater += leftMax-  arr[l++];
            }
        }
        return totalWater;
    }
}
