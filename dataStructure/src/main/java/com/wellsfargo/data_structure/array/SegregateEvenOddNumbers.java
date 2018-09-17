package com.wellsfargo.data_structure.array;

public class SegregateEvenOddNumbers {

    private int arr[];

    public SegregateEvenOddNumbers(int[] arr) {
        this.arr = arr;
    }

    public void segregateEvenAndOdd(){
        int i = -1, j = 0;
        int t;
        while (j != arr.length) {
            if (arr[j] % 2 == 0) {
                i++;

                // Swapping even and odd numbers
                swap(i, j);
            }
            j++;
        }
        for ( i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private void swap(int i , int j){
        arr[i] =arr[i]+arr[j];
        arr[j] = arr[i]- arr[j];
        arr[i] =arr[i]-arr[j];
    }

    public static void main(String[] args) {
        SegregateEvenOddNumbers seg=new SegregateEvenOddNumbers(new int[]{1,2,4,5,6});
        seg.segregateEvenAndOdd();
    }
}
