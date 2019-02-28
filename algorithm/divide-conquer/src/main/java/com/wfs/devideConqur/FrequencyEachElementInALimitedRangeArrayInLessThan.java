package com.wfs.devideConqur;

import java.util.ArrayList;
import java.util.List;

public class FrequencyEachElementInALimitedRangeArrayInLessThan {
    private int arr[];
    private List<Integer> integers;

    public FrequencyEachElementInALimitedRangeArrayInLessThan(int arr[]) {
        this.arr = arr;
        this.integers = new ArrayList<>();
        for(int i=0; i<arr.length;i++)
            integers.add(0);
    }

    public List getFrequency() {
        getFrequency(arr, 0, arr.length - 1);
        for (Integer i : integers)
            System.out.println(i);
        return integers;
    }

    private void getFrequency(int arr[], int low, int high) {
        if (arr[low] == arr[high]) {
            // increment the frequency of the element
            // by count of elements between high and low
            integers.set(arr[low], integers.get(arr[low]) + (high - low + 1));
        } else {
            // Find mid and recurse for left and right
            // subarray
            int mid = (low + high) / 2;
            getFrequency(arr, low, mid);
            getFrequency(arr, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10};
        FrequencyEachElementInALimitedRangeArrayInLessThan frequencyEachElementInALimitedRangeArrayInLessThan = new FrequencyEachElementInALimitedRangeArrayInLessThan(arr);
        frequencyEachElementInALimitedRangeArrayInLessThan.getFrequency();
    }
}
