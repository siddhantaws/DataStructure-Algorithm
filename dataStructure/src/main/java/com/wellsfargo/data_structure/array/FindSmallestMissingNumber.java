package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindSmallestMissingNumber {
    private int arr[];

    public FindSmallestMissingNumber(int[] arr) {
        this.arr = arr;
    }

    public int getMissingNumber(int start , int end){
        if(start>end)
            return end+1;

        if(start!=arr[start])
            return start;
        int mid  =start+(end-start)>>1;


        if(arr[mid] ==mid)
            return getMissingNumber(mid+1,end);
        else
            return getMissingNumber(start,mid);
    }
}
