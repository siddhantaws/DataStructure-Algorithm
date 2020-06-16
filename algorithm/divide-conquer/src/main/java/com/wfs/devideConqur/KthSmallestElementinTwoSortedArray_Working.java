package com.wfs.devideConqur;

public class KthSmallestElementinTwoSortedArray_Working {

    private int arr1[];

    private int arr2[];

    private int K;

    public KthSmallestElementinTwoSortedArray_Working(int[] arr1, int[] arr2, int k) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        K = k;
    }

    public int getKthSmallest(){
        return getKthSmallest(arr1 , 0 , arr1.length-1,arr2 ,0,arr2.length-1, K);
    }

    private int getKthSmallest(int arr1[],int start1, int end1 , int arr2[] , int start2, int end2 , int k){
        int length1= end1-start1+1;
        int length2= end2-start2+1;

        if(length1>length2)
            return getKthSmallest(arr2 , start2 ,end2 ,arr1,start1,end1 , k);
        if(length1==0)
            return arr2[start2+k-1];
        if(k==1)
            return Math.min(arr1[start1],arr2[start2]);

        int i = start1 + Math.min(length1 , k/2)-1;
        int j = start2 + Math.min(length2 , k/2)-1;
        if(arr1[i]>arr2[j])
            return getKthSmallest(arr1,start1,end1 ,arr2 , j+1 ,end2, k-(start2+j-1) );
        else
            return getKthSmallest(arr1,i+1, end1 ,arr2 , start2 ,end2, k-(start2+j-1) );
    }
}
