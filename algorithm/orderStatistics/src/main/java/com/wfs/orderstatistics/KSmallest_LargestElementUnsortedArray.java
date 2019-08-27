package com.wfs.orderstatistics;

public class KSmallest_LargestElementUnsortedArray {

    private int arr[];

    private int k;

    public KSmallest_LargestElementUnsortedArray(int[] arr, int k) {
        this.arr = arr;
        this.k=k;
    }

    public int getPivot(int l ,int r){
        int k=l;
        if(r-l==1 && arr[l]>arr[r]){
            swap(l,r);
            return l;
        }
        while(l<r){
            if(arr[l]<arr[r]){
                swap(l,k);
                k++;
            }
            l++;
        }
        swap(k,r);
        return k;
    }

    public int getkThSmallest(int l ,int r ,int k){
        if(l==r && k==1)
            return arr[l];
        if(l>r || l==r)
            return -1;
        int pivot =getPivot(l,r);
        if(pivot-l+1 == k)
            return arr[pivot];
        else if(pivot-l+1>k)
            return getkThSmallest(l,pivot, k);
        else
            return getkThSmallest(pivot+1,r, k-pivot+1);
    }

    public int getkThSmallest(){
        return getkThSmallest(0 , arr.length-1,k);
    }

    private void swap(int i ,int j){
        arr[i]= arr[i]^arr[j];
        arr[j]= arr[i]^arr[j];
        arr[i]= arr[j]^arr[i];
    }
}
