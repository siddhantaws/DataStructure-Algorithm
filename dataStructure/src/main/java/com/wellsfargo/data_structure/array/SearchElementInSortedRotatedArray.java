package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SearchElementInSortedRotatedArray {

    private int arr[];

    private int n;

    public SearchElementInSortedRotatedArray(int[] arr,int n) {
        this.arr = arr;
        this.n=n;
    }

    public int getPivot(int l ,int r){
        while(l<r){
            int mid  = l + (r-l)/2;
            if((arr[mid-1]< arr[mid] && arr[mid]> arr[mid+1]) || (arr[mid-1]> arr[mid] && arr[mid] <  arr[mid+1]))
                return mid;
            else if((arr[mid-1]< arr[mid] && arr[mid]> arr[mid+1]) && arr[mid-1]>arr[l])
                return getPivot(l,  mid);
            else
                return getPivot(mid+1,  r);
        }
        return -1;
    }





    public void rotate(int l , int r){
        if(l<r){
            if(l+n <= r -(l+n)){
                swap(l , r-n);
                rotate(l,r-n);
            }else{
                swap(l+n , 0);
                rotate(l-n,r);
            }
        }
    }

    private void swap(int left , int right){
        for(int i=0;i<n;i++){
            arr[left] = arr[left]^arr[right];
            arr[right] = arr[left] ^arr[right];
            arr[left] =arr[left] ^ arr[right];
        }
    }
}
