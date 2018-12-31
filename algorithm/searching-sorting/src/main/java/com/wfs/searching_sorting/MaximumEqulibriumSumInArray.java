package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumEqulibriumSumInArray {
    private int arr[];
    private int tempArray[];

    public MaximumEqulibriumSumInArray(int[] arr) {
        this.arr = arr;
        this.tempArray =new int[arr.length];
        tempArray[0]=arr[0];
    }

    public int getEquilibriumIndex(){
        for(int i=1;i< arr.length;i++)
            tempArray[i] = tempArray[i-1]+arr[i];

        if(tempArray[tempArray.length-1] == arr[arr.length-1])
            return tempArray.length-1;

        tempArray[tempArray.length-1] = arr[arr.length-1];
        int suffixSum =-1;
        for(int i=arr.length-2;i>=0;i--){
            suffixSum =arr[i] +tempArray[i-1];
            if(suffixSum == tempArray[i])
                return i;
            else
                tempArray[i] =suffixSum;
        }
        return -1;
    }
}
