package com.wfs.array.rearrangement;

public class RearrangeArraySuchThatarr_i {
    private int arr[];

    public RearrangeArraySuchThatarr_i(int[] arr) {
        this.arr = arr;
    }

    public void rearrange(){
        for(int i=0;i<arr.length;){
            if(arr[i]!=i && arr[i]>=0){
                swap(arr[i], i);
            }else{
                i++;
            }
        }
    }

    private void swap(int i, int r){
        i = i ^r;
        r = i ^r;
        i= r ^ i;
    }
}
