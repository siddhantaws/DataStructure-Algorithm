package com.amazon.question;

public class MinimumElementSortedRotatedArray {
    private int arr[];

    public MinimumElementSortedRotatedArray(int[] arr) {
        this.arr = arr;
    }

    private int getMinimum(){
        return getMinimum(0 ,arr.length-1);
    }

    public int getMinimum(int l , int r){
        if(l>r)
            return arr[0];
        if(l==r)
         return arr[l];
        int mid = (l+r)/2;

        if(mid<r && arr[mid+1]<arr[mid])//if mid+1 is minimum
            return arr[mid+1];

        if(l>mid && arr[mid-1]>arr[mid])
            return arr[mid];

        if(arr[r]>arr[mid])
            return getMinimum(l,mid-1);
        return getMinimum(mid+1,r);
    }

    public static void main(String[] args) {
        MinimumElementSortedRotatedArray elementSortedRotatedArray =new MinimumElementSortedRotatedArray(new int[]{1,2,3,4,5,6,7,8,});
        System.out.println(elementSortedRotatedArray.getMinimum());
    }
}
