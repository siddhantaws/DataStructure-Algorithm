package com.wfs.searching_sorting;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class KThSmallestAbsoluteDifferenceTtwoElementsInAnArray {

    private int arr[];

    private int k;

    public KThSmallestAbsoluteDifferenceTtwoElementsInAnArray(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    private int upperBound(int a[], int value, int n) {
        int low=0;
        int high=n;
        while(low<high) {
            final int mid1=(low+high)/2;
            if(value>=a[mid1]) {
                low=mid1+1;
            }
            else {
                high=mid1;
            }
        }
        return low;
    }

    private int countpairs(int a[],int mid,int n)
    {
        int result=0;
        for(int i=0;i<n-1;++i) {
            int value=a[i]+mid;
            int m=upperBound(a,value,n);
            result=result+(m-(i+1));
        }
        return result;
    }

    private int getKthSmallestAbsDifferences() {
        int n = arr.length;
        if(k>n*(n-1)/2)
            return 0;
        Arrays.sort(arr);
        int high=arr[n-1]-arr[0];
        int low=arr[1]-arr[0];

        for(int i=1;i<=n-2;i++)
            if(arr[i+1]-arr[i]<low)
                low=arr[i+1]-arr[i];
        while(low<high) {
            int mid=(low+high)/2;
            if(countpairs(arr,mid,n)<k)
                low=mid+1;
            else
                high=mid;
        }
        return low;
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4}, k=3;
        KThSmallestAbsoluteDifferenceTtwoElementsInAnArray kThSmallestAbsoluteDifferenceTtwoElementsInAnArray=new KThSmallestAbsoluteDifferenceTtwoElementsInAnArray(a , k);
        System.out.println(kThSmallestAbsoluteDifferenceTtwoElementsInAnArray.getKthSmallestAbsDifferences());
    }
}
