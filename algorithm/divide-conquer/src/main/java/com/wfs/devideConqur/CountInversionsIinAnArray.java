package com.wfs.devideConqur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suryasnata on 5/27/2017.
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0.
 * If array is sorted in reverse order that inversion count is the maximum. Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
public class CountInversionsIinAnArray {

    private int[] numArray;
    private int[] finalArray;
    private List<String> inversionList;

    public CountInversionsIinAnArray(int[] numArray) {
        this.numArray = numArray;
        this.finalArray = new int[numArray.length];
        this.inversionList = new ArrayList();
    }

    public List getInversion() {
        return getInversion(numArray, 0, numArray.length - 1);
    }

    private List getInversion(int[] numArray, int start, int end) {
        if ((end - start) == 0)
            return null;
        int mid = (end + start) / 2;
        getInversion(numArray, start, mid);
        getInversion(numArray, mid + 1, end);
        return merge(numArray, start, mid, end);
    }

    private List merge(int[] numArray, int start, int mid, int end) {
        for (int i = start; i <=end; i++)
            finalArray[i] = numArray[i];
        int i = start;
        int j = mid + 1;
        int k = end;

        while (i <= mid && j <= end) {
            if (finalArray[i] <= finalArray[j]) {
                numArray[k++] = finalArray[i++];
            } else {
                int m = k;
                numArray[k++] = finalArray[j++];
                while (m <= mid) {
                    inversionList.add(finalArray[m] + "," + finalArray[j - 1]);
                }
            }
        }
        while (i <= mid)
            numArray[k++] = finalArray[i++];
        return inversionList;
    }

    public static void main(String[] args) {
        CountInversionsIinAnArray countInversionsIinAnArray=new CountInversionsIinAnArray(new int[]{2, 4, 1, 3, 5});
        System.out.println(countInversionsIinAnArray.getInversion());
    }
}
