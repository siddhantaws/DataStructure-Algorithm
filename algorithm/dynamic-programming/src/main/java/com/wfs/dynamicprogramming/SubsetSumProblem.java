package com.wfs.dynamicprogramming;

public class SubsetSumProblem {
    private int arr[];

    private Boolean dpArray[];

    private int sumValue;



    public SubsetSumProblem(int[] arr, int sumValue) {
        this.arr = arr;
        this.sumValue = sumValue;
        this.dpArray =new Boolean[arr.length];
    }

    public boolean isSubsetPossible(int i , int sumValue){
        if(i==0 && arr[i]-sumValue==0)
            return true;
        if(i==0 && arr[i]-sumValue!=0)
            return false;
        if(dpArray[i]!=null)
            return dpArray[i];
        boolean flag = isSubsetPossible(i-1 , sumValue) || isSubsetPossible(i-1 , sumValue - arr[i]);
        dpArray[i] =flag;
        return flag;
    }

}
