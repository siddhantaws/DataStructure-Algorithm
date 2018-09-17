package com.wellsfargo.data_structure.array;

public class SmallestPositiveNumberMissingFromUnsortedArray {
    private int arr[];

    public SmallestPositiveNumberMissingFromUnsortedArray(int[] arr) {
        this.arr = arr;
    }

    int segregate ( )
    {
        int j = 0, i;
        for(i = 0; i < arr.length; i++)
        {
            if (arr[i] <= 0)
            {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    int findMissingPositive(int arr[] , int size )
    {
        int i;
        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++)
        {
            if(Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }

        // Return the first index value at which
        // is positive
        for(i = 0; i < size; i++)
            if (arr[i] > 0)
                return i+1;  // 1 is added becuase indexes
        // start from 0

        return size+1;
    }

    int findMissing()
    {
        int size= arr.length;
        // First separate positive and
        // negative numbers
        int shift = segregate ();
        int arr2[] = new int[size-shift];
        int j=0;
        for(int i=shift;i<size;i++)
        {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }

    public static void main(String[] args) {
        SmallestPositiveNumberMissingFromUnsortedArray missing =new SmallestPositiveNumberMissingFromUnsortedArray(new int[]{2, 3, 7, 6, 8, -1, -10, 15});
        System.out.println(missing.findMissing());
    }
}
