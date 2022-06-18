package com.wfs.google;

import java.util.HashSet;
import java.util.Set;

public class _128LongestConsecutiveSequence {

    public static void main(String[] args) {
        _128LongestConsecutiveSequence sequence = new _128LongestConsecutiveSequence();
        sequence.longestConsecutive(new int[]{100,4,200,3,2,1});
    }

    private int longestConsecutive(int[] nums) {
        final Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
