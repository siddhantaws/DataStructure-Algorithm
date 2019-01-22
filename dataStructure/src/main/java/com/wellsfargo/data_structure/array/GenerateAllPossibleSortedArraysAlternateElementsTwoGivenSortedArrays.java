package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GenerateAllPossibleSortedArraysAlternateElementsTwoGivenSortedArrays {

    private int arr1[];

    private int arr2[];

    private int c[];

    public GenerateAllPossibleSortedArraysAlternateElementsTwoGivenSortedArrays(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        c = new int[arr1.length + arr2.length];
    }

    public void generate() {
        generateUtil(0, 0, arr1.length, arr2.length, 0, true);
    }

    void printArr(int arr[], int n) {// A utility function to print an array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
        System.out.println(" ");
    }

    /* Function to generates and prints all sorted arrays from alternate elements of
    'A[i..m-1]' and 'B[j..n-1]'  If 'flag' is true, then current element is to be included from A otherwise from B.
    'len' is the index in output array C[]. We print output  array  each time before including a character from A only if length of output array is
    greater than 0. We try than all possible combinations */
    void generateUtil(int i, int j, int m, int n, int len, boolean flag) {
        if (flag) { // Include valid element from A
            // Print output if there is at least one 'B' in output array 'C'
            if (len > 0)
                printArr(c, len + 1);
            // Recur for all elements of A after current index
            for (int k = i; k < m; k++) {
                if (len == 0) {
                /* this block works for the very first call to include
                     the first element in the output array */
                    c[len] = arr1[k];
                    // don't increment lem as B is included yet
                    generateUtil(k + 1, j, m, n, len, !flag);
                } else {     /* include valid element from A and recur */
                    if (arr1[k] > c[len]) {
                        c[len + 1] = arr1[k];
                        generateUtil(k + 1, j, m, n, len + 1, !flag);
                    }
                }
            }
        } else {   /* Include valid element from B and recur */
            for (int l = j; l < n; l++) {
                if (arr2[l] > c[len]) {
                    c[len + 1] = arr2[l];
                    generateUtil(i, l + 1, m, n, len + 1, !flag);
                }
            }
        }
    }

    public static void main(String[] args) {

        int A[] = {10, 15, 25};
        int B[] = {5, 20, 30};
        GenerateAllPossibleSortedArraysAlternateElementsTwoGivenSortedArrays givenSortedArrays =new GenerateAllPossibleSortedArraysAlternateElementsTwoGivenSortedArrays(A,B);
        givenSortedArrays.generate();
    }

}
