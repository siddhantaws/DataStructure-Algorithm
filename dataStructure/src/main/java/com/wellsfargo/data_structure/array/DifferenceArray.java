package com.wellsfargo.data_structure.array;

public class DifferenceArray {

    private int arr[];

    private int diffArray[];

    public DifferenceArray(int[] arr) {
        this.arr = arr;
    }

    void initializeDiffArray() {

        int n = arr.length;
        diffArray = new int[n+1];
        diffArray[0] = arr[0];
        diffArray[n] = 0;
        for (int i = 1; i < n; i++)
            diffArray[i] = arr[i] - arr[i - 1];
    }

    void update(int l, int r, int x) {
        diffArray[l] += x;
        diffArray[r + 1] -= x;
    }

    void printArray() {
        for (int i = 0; i < arr.length; i++) {

            if (i == 0)
                arr[i] = diffArray[i];

                // Note that A[0] or D[0] decides
                // values of rest of the elements.
            else
                arr[i] = diffArray[i] + arr[i - 1];

            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        DifferenceArray differenceArray=new DifferenceArray(new int[]{ 10, 5, 20, 40 });
        differenceArray.initializeDiffArray();
        differenceArray.update(0, 1, 10);
        differenceArray.printArray();
    }
}
