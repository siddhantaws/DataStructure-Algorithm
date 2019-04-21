package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindDuplicatesArrayUsingBitArray {
    private int arr[];

    public FindDuplicatesArrayUsingBitArray(int[] arr) {
        this.arr = arr;
    }

    class BitArray {
        int[] arr1;
        // Constructor
        public BitArray(int n) {
            // Devide by 32. To store n bits, we need n/32 + 1 integers (Assuming int is stored using 32 bits)
            arr1= new int[(n >> 5) + 1];
        }

        boolean get(int pos){// Get value of a bit at given position
            // Divide by 32 to find position of integer.
            int index = (pos >> 5);
            // Now find bit number in arr[index]
            int bitNo  = (pos & 0x1F);
            // Find value of given bit number in arr[index]
            return (arr1[index] & (1 << bitNo)) != 0;
        }

        void set(int pos) {// Sets a bit at given position
            // Find index of bit position
            int index = (pos >> 5);
            // Set bit number in arr[index]
            int bitNo = (pos & 0x1F);
            arr1[index] |= (1 << bitNo);
        }
    }

    public void checkDuplicates() {
        // create a bit with 32000 bits
        BitArray ba = new BitArray(320000);
        // Traverse array elements
        for (int i=0; i<arr.length; i++)  {
            // Index in bit array
            int num  = arr[i] - 1;
            // If num is already present in bit array
            if (ba.get(num))
                System.out.print(arr[i] +" ");
            else// Else insert num
                ba.set(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7,9};
        FindDuplicatesArrayUsingBitArray arrayUsingBitArray =new FindDuplicatesArrayUsingBitArray(arr);
        arrayUsingBitArray.checkDuplicates();
    }
}
