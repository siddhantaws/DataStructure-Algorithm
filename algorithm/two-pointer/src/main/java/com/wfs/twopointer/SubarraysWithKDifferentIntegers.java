package com.wfs.twopointer;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {
    private int arr[];

    private int K;

    public SubarraysWithKDifferentIntegers(int[] arr, int k) {
        this.arr = arr;
        K = k;
    }

    public int subarraysWithKDistinct() {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int right = 0; right < arr.length; ++right) {
            int x = arr[right];
            window1.add(x);
            window2.add(x);

            while (window1.different() > K)
                window1.remove(arr[left1++]);
            while (window2.different() >= K)
                window2.remove(arr[left2++]);

            ans += left2 - left1;
        }

        return ans;
    }
    class Window {
        Map<Integer, Integer> count;
        int nonzero;

        Window() {
            count = new HashMap<>();
            nonzero = 0;
        }

        void add(int x) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 1)
                nonzero++;
        }

        void remove(int x) {
            count.put(x, count.get(x) - 1);
            if (count.get(x) == 0)
                nonzero--;
        }

        int different() {
            return nonzero;
        }
    }

    public static void main(String[] args) {
        SubarraysWithKDifferentIntegers withKDifferentIntegers =new SubarraysWithKDifferentIntegers(new int[]{1,2,1,2} , 2);
        System.out.println(withKDifferentIntegers.subarraysWithKDistinct());
    }

}

