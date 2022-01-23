package com.wfs.amazon.binarysearch;

public class FloorAndCeilingOfArray {
    private int arr[];

    public FloorAndCeilingOfArray(int[] arr) {
        this.arr = arr;
    }

    public int getFloorIndex(int key){
        return getFloorIndex(key , 0, arr.length-1);
    }

    private int getFloorIndex(int key , int l , int r){
        if(arr[l]>key)
            return -1;
        if(arr[r]<=key)
            return r;
        int mid =l+ (r-l)/2;

        if(arr[mid]==key)
            return mid;
        else if(arr[mid]>key){
            if(mid-1>=0 && arr[mid-1]<=key)
                return mid-1;
            return getFloorIndex(key , l,mid-1);
        }else{
            if(mid+1<=r &&  arr[mid+1]>key)
                return mid;
            return getFloorIndex(key , mid+1,r);
        }
    }

    private int ceilingIndex(int key , int l , int r){
        if(arr[l]<=key)
            return l;
        if(arr[r]>key)
            return -1;
        int mid = l+(r-l)/2;

        if(arr[mid]==key)
            return mid;

        if(arr[mid]>key){
            if(mid-1>=l && arr[mid-1]<key)
                return mid;
            return ceilingIndex(key , l,mid-1);
        }else{
            if(mid+1<=r && arr[mid+1]<=key)
                return mid+1;
            return ceilingIndex(key , mid+1,r);
        }
    }



    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        FloorAndCeilingOfArray floorAndCeilingOfArray =new FloorAndCeilingOfArray(arr);
        System.out.println(floorAndCeilingOfArray.getFloorIndex(4));
        System.out.println(floorAndCeilingOfArray.getFloorIndex(8));
        System.out.println(floorAndCeilingOfArray.getFloorIndex(9));
        System.out.println(floorAndCeilingOfArray.getFloorIndex(0));
        System.out.println(floorAndCeilingOfArray.getFloorIndex(20));
        System.out.println(floorAndCeilingOfArray.getFloorIndex(15));
    }
}
