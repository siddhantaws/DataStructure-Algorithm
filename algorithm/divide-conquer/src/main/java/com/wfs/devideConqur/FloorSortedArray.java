package com.wfs.devideConqur;

public class FloorSortedArray {
    private int arr[];

    public FloorSortedArray(int[] arr) {
        this.arr = arr;
    }

    public int floorIndex(int num){
        return floorIndex(num , 0 ,arr.length-1);
    }

    private int floorIndex(int num , int l ,int r){
        if(l>r)
            return -1;
        if(arr[r]<num)
            return r;
        int mid = l +(r-l)/2;
        if(arr[mid]==num)
            return mid;
        if(mid>0 && arr[mid-1]<num && arr[mid]>num )
            return mid-1;
        if(arr[mid]>num)
            return floorIndex(num , l ,mid-1);
        else
            return floorIndex(num , mid+1 ,r);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 10, 12, 14};
        FloorSortedArray sortedArray =new FloorSortedArray(arr);
        System.out.println(sortedArray.floorIndex(18));
    }
}
