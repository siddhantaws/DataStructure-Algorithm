package com.wellsfargo.data_structure.matrix;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CountSubMatricesHavingSumDivisibleK {
    private int mat[][];

    private int K;

    public CountSubMatricesHavingSumDivisibleK(int[][] mat, int k) {
        this.mat = mat;
        K = k;
    }
    // function to count all sub-arrays divisible by k
    private int subCount(int arr[], int n) {
        // create auxiliary hash array to count frequency of remainders
        int mod[] = new int[K];
        Arrays.fill(mod, 0);
        // Traverse original array and compute cumulative sum take remainder of this current cumulative
        // sum and increase count by 1 for this remainder in mod[] array
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            // as the sum can be negative, taking modulo twice
            mod[((cumSum % K) + K) % K]++;
        }
        // Initialize result
        int result = 0;
        // Traverse mod[]
        for (int i = 0; i < K; i++)
            // If there are more than one prefix subarrays with a particular mod value.
            if (mod[i] > 1)
                result += (mod[i] * (mod[i] - 1)) / 2;
        // add the subarrays starting from the arr[i] which are divisible by k itself
        result += mod[0];
        return result;
    }

    // function to count all sub-matrices having sum divisible by the value 'k'
    public int countSubmatrix(int n) {
        // Variable to store the final output
        int tot_count = 0;
        int left, right, i;
        int temp[] = new int[n];
        // Set the left column
        for (left = 0; left < n; left++) {
            // Initialize all elements of temp as 0
            Arrays.fill(temp, 0);
            // Set the right column for the left column set by outer loop
            for (right = left; right < n; right++) {
                // Calculate sum between current left and right for every row 'i'
                for (i = 0; i < n; ++i)
                    temp[i] += mat[i][right];
                // Count number of subarrays in temp[]  having sum divisible by 'k' and then
                // add it to 'tot_count'
                tot_count += subCount(temp, n);
            }
        }
        // required count of sub-matrices having sum divisible by 'k'
        return tot_count;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, -1, 6},
                {3, 3, 8},
                {4, 4, -9}};
        CountSubMatricesHavingSumDivisibleK havingSumDivisibleK =new CountSubMatricesHavingSumDivisibleK(mat , 4);
        havingSumDivisibleK.countSubmatrix(3);
    }
}
