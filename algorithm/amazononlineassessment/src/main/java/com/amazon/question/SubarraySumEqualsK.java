package com.amazon.question;

import java.util.HashMap;

public class SubarraySumEqualsK {
    private int arr[];

    private int K;

    public SubarraySumEqualsK(int[] arr, int k) {
        this.arr = arr;
        K = k;
    }

    public int subarraySum() {
        int count =0 , sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - K))
                count += map.get(sum - K);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK sumEqualsK = new SubarraySumEqualsK(new int[]{3,4,7,2,-3,1,4,2}, 7);
        System.out.println(sumEqualsK.subarraySum());
    }
}
