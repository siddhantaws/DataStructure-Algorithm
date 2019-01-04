package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckReversingSubArrayMakeArraySorted {
    private int arr[];

    private int n ;
    public CheckReversingSubArrayMakeArraySorted(int[] arr) {
        this.arr = arr;
        this.n=arr.length;
    }
    public boolean checkReverse() {
        if (n == 1) {
            return true;
        }
        // Find first increasing part
        int i;
        for (i = 1; arr[i - 1] < arr[i] && i < n; i++);
        if (i == n) {
            return true;
        }
        // Find reversed part
        int j = i++;
        while (arr[j] < arr[j - 1]) {
            if (i > 1 && arr[j] < arr[i - 2]) {
                return false;
            }
            j++;
        }
        if (j == n) {
            return true;
        }

        // Find last increasing part
        int k = j;

        // To handle cases like {1,2,3,4,20,9,16,17}
        if (arr[k] < arr[i - 1]) {
            return false;
        }

        while (k > 1 && k < n) {
            if (arr[k] < arr[k - 1]) {
                return false;
            }
            k++;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckReversingSubArrayMakeArraySorted checkReversingSubArrayMakeArraySorted=new CheckReversingSubArrayMakeArraySorted(new int[]{ 1, 3, 4, 10, 9, 8 });
        System.out.println(checkReversingSubArrayMakeArraySorted.checkReverse());
    }
}
