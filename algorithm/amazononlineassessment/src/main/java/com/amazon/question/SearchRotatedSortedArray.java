package com.amazon.question;

public class SearchRotatedSortedArray {
    private int arr[];

    private int K;

    public SearchRotatedSortedArray(int[] arr , int K) {
        this.arr = arr;
        this.K =K;
    }

    public int getIndex(){
        int start=0;int end =arr.length-1;
        while(start<end){
            int mid = start+ (end-start)/2;
            if (arr[mid]==K)
                return mid;
            else if(arr[mid]>=arr[start]){
                if(arr[start]<= K && arr[mid]>K)
                    end = mid-1;
                else
                    start = mid+1;
            }else{
                if(arr[mid]<K && arr[end]>=K)
                    start =mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray sortedArray =new SearchRotatedSortedArray(new int[]{4,5,6,0,1,2,3}, 0);
        System.out.println(sortedArray.getIndex());
    }
}
