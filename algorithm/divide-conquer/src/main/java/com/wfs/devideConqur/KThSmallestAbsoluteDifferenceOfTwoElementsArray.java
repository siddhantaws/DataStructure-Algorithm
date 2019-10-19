package com.wfs.devideConqur;

import java.util.Arrays;

public class KThSmallestAbsoluteDifferenceOfTwoElementsArray {
    private int arr[];
    private int k;

    public KThSmallestAbsoluteDifferenceOfTwoElementsArray(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }


    public int smallestDistancePair() {
        Arrays.sort(arr);

        int lo = 0;
        int hi = arr[arr.length - 1] - arr[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < arr.length; ++right) {
                while (arr[right] - arr[left] > mi)
                    left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int nums []= {1,2,3,4};
        KThSmallestAbsoluteDifferenceOfTwoElementsArray elementsArray =new KThSmallestAbsoluteDifferenceOfTwoElementsArray(nums , 3);
        System.out.println(elementsArray.smallestDistancePair());

    }
}
