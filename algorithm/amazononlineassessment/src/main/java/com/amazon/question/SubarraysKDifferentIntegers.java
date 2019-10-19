package com.amazon.question;

import java.util.HashMap;
import java.util.Map;

public class SubarraysKDifferentIntegers {
    private int arr[];

    private int k;

    public SubarraysKDifferentIntegers(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    public int subarraysWithKDistinct() {
        int count =0;
        int i=0;int r=arr.length-1;
        SlidingWindow slidingWindow =new SlidingWindow();
        while(i<r && slidingWindow.distinctCount==k){
                if(slidingWindow.distinctCount==k && !slidingWindow.containsKey(arr[i]))
                    break;
            slidingWindow.add(arr[i]);i++;
        }
        int i1=0;
        while(i<r){
            count += (i-i1);
        }

        return count;
    }

    class SlidingWindow{
        private Map<Integer, Integer> map =new HashMap<>();
        int distinctCount=0;
        public void add(int i){
            if(map.containsKey(i)){
               map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);distinctCount++;
            }
        }

        public boolean containsKey(int i){
            return map.containsKey(i);
        }

        public void remove(int i){
            int count = map.get(i);
            if(count==1){
                map.remove(i);
                distinctCount--;
            }else{
                map.put(i,count-1);
            }
        }
        public int getDistinctCount(){
            return distinctCount;
        }
    }

}
