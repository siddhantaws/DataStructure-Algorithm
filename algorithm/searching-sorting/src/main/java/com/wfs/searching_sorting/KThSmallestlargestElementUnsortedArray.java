package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class KThSmallestlargestElementUnsortedArray {

    private int arr[];

    private int k;

    public KThSmallestlargestElementUnsortedArray(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    public int getKthSmallest() {
        return getKthSmallest(0, arr.length - 1);
    }

    private int getKthSmallest(int start, int end) {
        int pivot = getKthSmallest(start, end);
        if (start + pivot < k)
            return getKthSmallest(pivot + 1, end);
        else if(start + pivot > k)
            return getKthSmallest(start, pivot);
        else
            return pivot;
    }

    private int getPivot(int start, int end) {
        int pivot = arr[end];

        int i = start - 1;

        for (int j = start; i < end - 1; i++) {
            if (arr[start] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, end);
        return i + 1;
    }

    private void swap(int source, int dest) {
        arr[source] = arr[source] ^ arr[dest];
        arr[dest] = arr[source] ^ arr[dest];
        arr[source] = arr[source] ^ arr[dest];
    }
}
