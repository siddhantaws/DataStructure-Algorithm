package com.google.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _2172MaximumANDSumofArray {
    private Map<String, Integer> memo;

    public _2172MaximumANDSumofArray(){
        this.memo = new HashMap<>();
    }

    public int maximumANDSum(int[] nums, int numSlots) {
        memo.clear();
        int slots[] = new int[numSlots+1];
        Arrays.fill(slots , 2);
        return dfsWithDP(nums , slots , 0);
    }

    public int dfsWithDP(int num[] , int slots[], int pos){
        if(pos==num.length)
            return 0;
        String key = Arrays.toString(slots)+pos;
        int ans = Integer.MIN_VALUE;
        if(memo.containsKey(key))
            return memo.get(key);
        for(int i=1;i<slots.length;i++){
            if(slots[i]==0)
                continue;
            slots[i]--;
            ans = Math.max(ans , dfsWithDP(num , slots , pos+1) + num[pos]& i);
            slots[i]++;
        }
        memo.put(key , ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
