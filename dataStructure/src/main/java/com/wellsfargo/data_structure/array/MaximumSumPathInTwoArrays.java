package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumSumPathInTwoArrays {

    private int arr1[];

    private int arr2[];

    public MaximumSumPathInTwoArrays(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    // This function returns the sum of elements on maximum path  from beginning to end
    public  int maxPathSum(int ar1[], int ar2[], int m, int n) {
        // initialize indexes for ar1[] and ar2[]
        int i = 0, j = 0;
        // Initialize result and current sum through ar1[] and ar2[].
        int result = 0, sum1 = 0, sum2 = 0;
        // Below 3 loops are similar to merge in merge sort
        while (i < m && j < n) {
            // Add elements of ar1[] to sum1
            if (ar1[i] < ar2[j])
                sum1 += ar1[i++];
                // Add elements of ar2[] to sum2
            else if (ar1[i] > ar2[j])
                sum2 += ar2[j++];
                // we reached a common point
            else {
                // Take the maximum of two sums and add to result
                result += Math.max(sum1, sum2);
                // Update sum1 and sum2 for elements after this intersection point
                sum1 = 0;
                sum2 = 0;

                // Keep updating result while there are more common
                // elements
                while (i < m && j < n && ar1[i] == ar2[j]) {
                    result = result + ar1[i++];
                    j++;
                }
            }
        }
        while (i < m)// Add remaining elements of ar1[]
            sum1 += ar1[i++];
        while (j < n)// Add remaining elements of ar2[]
            sum2 += ar2[j++];

        result += Math.max(sum1, sum2);// Add maximum of two sums of remaining elements
        return result;
    }

}
