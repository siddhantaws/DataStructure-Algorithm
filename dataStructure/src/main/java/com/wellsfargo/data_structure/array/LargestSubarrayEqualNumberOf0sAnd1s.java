package com.wellsfargo.data_structure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LargestSubarrayEqualNumberOf0sAnd1s {
    private int arr[];

    private int n ;
    public LargestSubarrayEqualNumberOf0sAnd1s(int[] arr) {
        this.arr = arr;
        this.n=arr.length;
    }

    // Returns largest subarray with equal number of 0s and 1s
    public int maxLen() {
        // Creates an empty hashMap hM
        Map<Integer, Integer> hM = new HashMap<>();
        int sum = 0;     // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }
        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];
            // To handle sum=0 at last index
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }
            // If this sum is seen before, then update max_len if required
            if (hM.containsKey(sum + n)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                hM.put(sum + n, i);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }
        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);
        return max_len;
    }

    public static void main(String[] args) {
        LargestSubarrayEqualNumberOf0sAnd1s equalNumberOf0sAnd1s =new LargestSubarrayEqualNumberOf0sAnd1s(new int []{1, 0, 0, 1, 0, 1, 1});
        equalNumberOf0sAnd1s.maxLen();
    }
}
