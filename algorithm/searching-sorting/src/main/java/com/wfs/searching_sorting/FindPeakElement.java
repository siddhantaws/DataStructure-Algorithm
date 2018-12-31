package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindPeakElement {
    private int arr[];

    public FindPeakElement(int[] arr) {
        this.arr = arr;
    }

    public int getPeakElement(){
        return getPeak(0 ,arr.length-1);
    }

    private int getPeak(int low, int high){
        int mid = low + (high-low)/2;
        if((mid ==0 || arr[mid-1]< arr[mid] )&& (mid ==arr.length-1 || arr[mid+1]> arr[mid]) )
            return mid;
        else if(arr[mid-1] > arr[mid] )
            return getPeak(low , mid);
        else
            return getPeak(mid , high);
    }

    public static void main(String[] args) {
        int arr[]={10, 20, 15, 2, 23, 90, 67};
        FindPeakElement peakElement =new FindPeakElement(arr);
        System.out.println(peakElement.getPeakElement());
    }
}
