package com.wfs.devideConqur;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CutRodsSomeLengthSuchSumCutOffLengthMaximized {

    private int arr[];

    private int N;

    private int M;

    public CutRodsSomeLengthSuchSumCutOffLengthMaximized(int[] arr , int m) {
        this.arr = arr;
        Arrays.sort(this.arr);
        this.N = arr.length;
        this.M = m;
    }

    public int binarySearch() {
        int low = 0;

        int high = arr[N - 1];

        while (low < high) {
            // f is the flag varibale sum is for the total length cutoff
            int f = 0, sum = 0;

            int mid = low + (high - low) / 2;

            // Loop from higer to lower for optimization
            for (int i = N - 1; i >= 0; i--) {
                // Only if length is greater than cut-off length

                if (arr[i] > mid) {
                    sum = sum + arr[i] - mid;
                }
                // When total cut off length becomes greater than desired cut off length
                if (sum >= M) {
                    f = 1;
                    low = mid + 1;
                    break;
                }
            }
            // If flag variable is not set Change high
            if (f == 0)
                high = mid;
        }
        // returning the maximum cut off length
        return low - 1;
    }

    public static void main(String[] args) {
        CutRodsSomeLengthSuchSumCutOffLengthMaximized maximized =new CutRodsSomeLengthSuchSumCutOffLengthMaximized(new int[]{ 1, 2, 3, 4, 5, 7, 6 }, 8 );
        System.out.println(maximized.binarySearch());
    }
}
