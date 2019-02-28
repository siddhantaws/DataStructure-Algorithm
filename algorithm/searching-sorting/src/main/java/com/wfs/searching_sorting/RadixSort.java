package com.wfs.searching_sorting;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RadixSort {

    private int arr[];
    private int output[]; // output array
    private int count[] = new int[10];

    public RadixSort(int[] arr) {
        this.arr = arr;
        this.output =new int[arr.length];

    }

    private int getMax(){
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
            maxValue =Math.max(maxValue ,arr[i]);
        return maxValue;
    }

    private void radixSort(int exp){
        Arrays.fill(count,0);
        for(int i=0;i<arr.length;i++)
            count[ (arr[i]/exp)%10]++;

        for(int i=1;i<count.length;i++)
            count[i] =count[i]+count[i-1];

        for(int i=arr.length-1;i>=0;i--){
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to curent digit
        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }

    public void radixSort(){
        int maxValue = getMax();
        // Do counting sort for every digit. Note that instead  of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for(int i=1; (maxValue/ i)> 0 ;i=i*10)
            radixSort(i);
        print();
    }

    // A utility function to print an array
    void print() {
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }

    public static void main(String[] args) {
        RadixSort radixSort =new RadixSort(new int[]{170, 45, 75, 90, 802, 24, 2, 66});
        radixSort.radixSort();
    }
}
