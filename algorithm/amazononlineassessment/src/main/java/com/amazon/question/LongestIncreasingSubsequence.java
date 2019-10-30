package com.amazon.question;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestIncreasingSubsequence {

    private int arr[];

    public LongestIncreasingSubsequence(int[] arr) {
        this.arr = arr;
    }

    public int lengthOfLIS() {
        int count =1;
        if(arr==null || arr.length==0)
            return 0;
        TreeMap<Integer, Sequence > sequenceMap =new TreeMap<>();
        sequenceMap.put(arr[0], new Sequence(0,1));
        for(int i=1;i<arr.length;i++){
            Map.Entry<Integer, Sequence> entry =sequenceMap.ceilingEntry(arr[i]);
            if(entry==null){
                sequenceMap.put(arr[i] , new Sequence(i,++count));
            }else{
                Sequence sequence = entry.getValue();
                sequenceMap.remove(entry.getKey());
                sequenceMap.put(arr[i] , new Sequence(i,sequence.count));
            }
        }
        return count;
    }

    class Sequence{
        int index;
        int count;
        public Sequence(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence =new LongestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(subsequence.lengthOfLIS());
    }
}
