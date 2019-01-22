package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RearrangePositiveAndNegativeNumbersWithConstantExtraSpace {

    public RearrangePositiveAndNegativeNumbersWithConstantExtraSpace(int[] arr) {
        this.arr = arr;
    }

    private int arr[];

    private void swap(int i,int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    /* Function to reverse an array. An array can be  reversed in O(n) time and O(1) space. */
    void reverse(int l, int r) {
        if (l < r) {
            swap(l, r);
            reverse(++l, --r);
        }
    }
    // Merges two subarrays of arr[].First subarray is arr[l..m] Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        int i = l; // Initial index of 1st subarray
        int j = m + 1; // Initial index of IInd
        while (i <= m && arr[i] < 0)
            i++;
        // arr[i..m] is positive
        while (j <= r && arr[j] < 0)
            j++;
        // arr[j..r] is positive reverse positive part of left sub-array (arr[i..m])
        reverse( i, m);
        // reverse negative part of right sub-array (arr[m+1..j-1])
        reverse( m + 1, j - 1);
        // reverse arr[i..j-1]
        reverse( i, j - 1);
    }

    // Function to Rearrange positive and negativenumbers in a array
    void RearrangePosNeg( int l, int r) {
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for large l and h
            int m = l + (r - l) / 2;
            // Sort first and second halves
            RearrangePosNeg( l, m);
            RearrangePosNeg( m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /* Function to print an array */
    void printArray()
    {
        for (int i = 0; i < arr.length-1; i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        int arr[]={-12, 11, -13, -5, 6, -7, 5, -3, -6};
        RearrangePositiveAndNegativeNumbersWithConstantExtraSpace  numbers =new RearrangePositiveAndNegativeNumbersWithConstantExtraSpace(arr);
        numbers.RearrangePosNeg(0,arr.length-1);
        numbers.printArray();
    }

}
