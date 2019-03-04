package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumSwapsRequiredBringElementsLessThanEqualkTogether {
    private int arr[];

    private int k ;

    private int n;
    public MinimumSwapsRequiredBringElementsLessThanEqualkTogether(int[] arr, int k ) {
        this.arr = arr;
        this.k=k;
        this.n = arr.length;
    }

    // Utility function to find minimum swaps required to club all elements less than or equals to k together
    public int minSwap() {

        // Find count of elements which are less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        // Find unwanted elements in current window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;

        // Initialize answer with 'bad' value of current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {
            // Decrement count of previous window
            if (arr[i] > k)
                --bad;
            // Increment count of current window
            if (arr[j] > k)
                ++bad;
            // Update ans if count of 'bad' is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumSwapsRequiredBringElementsLessThanEqualkTogether lessThanEqualkTogether =new MinimumSwapsRequiredBringElementsLessThanEqualkTogether(new int[]{2, 1, 5, 6, 3}, 3 );
        System.out.println(lessThanEqualkTogether.minSwap());

    }
}
