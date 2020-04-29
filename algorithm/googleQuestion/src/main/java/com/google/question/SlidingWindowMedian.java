package com.google.question;

import java.util.Collections;
import java.util.TreeMap;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new double[0];
        double[] result = new double[nums.length - k + 1];
        // To avoid integer overflow or underflow, double casting is required
        TreeMap<Integer, Integer> left = new TreeMap<>((a, b)-> (int) ((double) b - (double) a));
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int leftCount = 0;
        int rightCount = 0;
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if (leftCount + rightCount == k) { // Step 1 : Clean up the window by removing the invalid item
                if (nums[i-k] <= left.firstKey()) {
                    remove(left, nums[i-k]);
                    leftCount--;
                } else {
                    remove(right, nums[i-k]);
                    rightCount--;
                }
            }
            // Step 2: Insert the element into left or right, keeping in mind that left size has to be >= right size This step does not include balancing
            if (leftCount <= rightCount) {
                add(left, nums[i]);
                leftCount++;
            } else {
                add(right, nums[i]);
                rightCount++;
            }
            // Step 3: So, we do balancing so that left and right's lowest values point to the elements contributing to median calculation
            if (rightCount > 0) {
                while (left.firstKey() > right.firstKey()) {
                    add(right, remove(left, left.firstKey()));
                    add(left, remove(right, right.firstKey()));
                }
            }
            // Step 4 : Median calculation
            if (leftCount + rightCount == k) {
                if (k % 2 == 0)
                    result[idx++] = ((double) left.firstKey() + right.firstKey()) / 2.0;
                else
                    result[idx++] = (double) left.firstKey();
            }
        }
        return result;
    }

    private int remove(TreeMap<Integer, Integer> map, int key){
        map.merge(key, -1, Integer::sum);
        if (map.get(key) == 0) map.remove(key);
        return key;
    }

    private void add(TreeMap<Integer, Integer> map, int val){
        map.merge(val, 1, Integer::sum);
    }

    public static void main(String[] args) {
        SlidingWindowMedian windowMedian =new SlidingWindowMedian();
        int[] nums={1 , 3  ,-1, -3  ,5 , 3 , 6 , 7 };
        double[] median=  windowMedian.medianSlidingWindow(nums , 3);
        for (double d:median)
            System.out.print(d+" ");
    }
}
