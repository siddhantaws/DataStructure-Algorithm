package com.wfs.amazon.binarysearch;

public class _1060MissingElementSortedArray {
    private int []arr;

    private int k;

    public _1060MissingElementSortedArray(int[] arr,int k) {
        this.arr = arr;
        this.k=k;
    }

    public int missingElement() {
        int l=0;int r= arr.length-1;
        if(arr[r]-arr[l]-1-(r-l+1)>k)
            return -1;
        while(k>0){
            if(l==r)
                return arr[r]-k;
            if(r-l+1==2)
                return arr[l]+k;
            int mid = l + (r-l)/2;

            if(arr[mid] - arr[l]+1 -(mid-l+1) >=k)
                r=mid;
            else{
                k-=arr[mid] - arr[l]+1 - ((mid-l+1));
                l=mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        _1060MissingElementSortedArray  sortedArray =new _1060MissingElementSortedArray(new int[]{1,2,4} , 3);
        System.out.println(sortedArray.missingElement());
    }
}
