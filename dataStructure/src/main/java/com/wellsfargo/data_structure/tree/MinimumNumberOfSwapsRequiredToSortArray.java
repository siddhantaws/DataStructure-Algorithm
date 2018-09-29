package com.wellsfargo.data_structure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumNumberOfSwapsRequiredToSortArray {
    private int[] arr;

    public MinimumNumberOfSwapsRequiredToSortArray(int[] arr) {
        this.arr = arr;
    }

    public int minSwaps(int n) {
        // Create an array of pairs where first
        // element is array element and second element
        // is position of first element
        Pair arrPos[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            Pair p = new Pair(arr[i], i);
            arrPos[i] = p;
        }

        // Sort the array by array element values to
        // get right position of every element as second
        // element of pair.
        Arrays.sort(arrPos);

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < n; i++)
            visited.add(false);

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++) {
            // already swapped and corrected or
            // already present at correct pos
            if (visited.get(i) || arrPos[i].second == i)
                continue;

            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!visited.get(i)) {
                visited.set(i, true);

                // move to next node
                j = arrPos[j].second;
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }

        // Return result
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 4, 3, 2};

        MinimumNumberOfSwapsRequiredToSortArray array = new MinimumNumberOfSwapsRequiredToSortArray(arr);
        array.minSwaps(arr.length);
    }

    class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return o.first - this.first;
        }
    }
}
