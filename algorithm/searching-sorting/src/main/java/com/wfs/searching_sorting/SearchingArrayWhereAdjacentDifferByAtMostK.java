package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SearchingArrayWhereAdjacentDifferByAtMostK {
    private int arr[];
    private int k;
    private int x;

    public SearchingArrayWhereAdjacentDifferByAtMostK(int[] arr, int k, int x) {
        this.arr = arr;
        this.k = k;
        this.x = x;
    }

    public int search(){
        // Travers the given array starting from  leftmost element
        int i = 0;
        while (i < arr.length) {
            // If x is found at index i
            if (arr[i] == x)
                return i;
            // Jump the difference between current array element and x divided by k
            // We use max here to make sure that i moves at-least one step ahead.
            i = i + Math.max(1, Math.abs(arr[i]-x)/k);
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
