package com.wellsfargo.data_structure.array;

public class SortedSubsequenceSize3LinearTime {
    private int arr[];

    public SortedSubsequenceSize3LinearTime(int[] arr) {
        this.arr = arr;
    }

    void find3Numbers(){
        int n = arr.length;
        int max = n-1; //Index of maximum element from right side
        int min = 0; //Index of minimum element from left side
        int i;

        int[] smaller = new int[n];
        smaller[0] = -1;  // first entry will always be -1
        for (i = 1; i < n; i++)
        {
            if (arr[i] <= arr[min])
            {
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;
        }
        // Create another array that will store index of a
        // greater element on right side. If there is no greater
        // element on right side, then greater[i] will be -1.
        int[] greater = new int[n];
        greater[n-1] = -1;  // last entry will always be -1
        for (i = n-2; i >= 0; i--)
        {
            if (arr[i] >= arr[max])
            {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;
        }

        // Now find a number which has both a greater number
        // on right side and smaller number on left side
        for (i = 0; i < n; i++)
        {
            if (smaller[i] != -1 && greater[i] != -1)
            {
                System.out.print(arr[smaller[i]]+" "+
                        arr[i]+" "+ arr[greater[i]]);

            }
        }
    }

    public static void main(String[] args) {
        SortedSubsequenceSize3LinearTime linearTime =new SortedSubsequenceSize3LinearTime(new int[]{4,5,3,7,6,8});
        linearTime.find3Numbers();
    }
}
