package com.amazon.question;

public class SearchInSortedRotatedArray {
    private int arr[];

    private int num;

    public SearchInSortedRotatedArray(int[] arr,int num) {
        this.arr = arr;
        this.num = num;
    }

    public int getIndex(){
        return getIndexInDescendingRotated(0,arr.length-1);
    }

    private int getIndexInAssendingRotated(int l , int r){
        if(l>r)
            return -1;
        int mid = l+ (r-l)/2;
        if(arr[mid]==num)
            return mid;
        if(arr[l]<=arr[mid]){
            if(arr[l]<=num && arr[mid]>=num)
                return getIndexInAssendingRotated(l , mid-1);
            return getIndexInAssendingRotated(mid+1 , r);
        }
        if(arr[mid]<=num && arr[r]>=num)
            return getIndexInAssendingRotated(mid+1 , r);
        return getIndexInAssendingRotated(l , mid-1);
    }

    private int getIndexInDescendingRotated(int l , int r){
        if(l>r)
            return -1;
        int mid = l + (r-l)/2;
        if(arr[mid]==num)
            return mid;
        if(arr[l]>=arr[mid]){
            if(arr[l]>=num && arr[mid]<=num)
                return getIndexInDescendingRotated(l ,mid-1);
            return getIndexInDescendingRotated(mid+1,r);
        }
        if(arr[mid]>=num && arr[r]<=num)
            return getIndexInDescendingRotated(mid+1, r);
        return getIndexInDescendingRotated(l, mid-1);

    }

    public static void main(String[] args) {
        SearchInSortedRotatedArray search =new SearchInSortedRotatedArray(new int[]{3,2,1,10,9,8,7,6,5,4}, 10);
        System.out.println(search.getIndex());
    }
}
