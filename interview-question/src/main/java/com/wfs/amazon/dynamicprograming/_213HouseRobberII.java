package com.wfs.amazon.dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class _213HouseRobberII {

    private int nums[];

    public _213HouseRobberII(int[] nums) {
        this.nums = nums;
    }

    public int rob() {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length<=2)
            return Math.max(nums[0] , nums.length==2 ? nums[1] : Integer.MIN_VALUE);

        Map<Integer,Integer> mapOfPositionToValues =new HashMap<>();
        boolean elementTaken[] =new boolean[nums.length];
        return Math.max(rob(0 , nums , mapOfPositionToValues ,elementTaken ),
                rob(1, nums , mapOfPositionToValues ,elementTaken ));
    }

    public int rob(int pos ,int[] nums ,  Map<Integer,Integer> mapOfPositionToValues,boolean elementTaken[]){
        if(pos==nums.length-1 && !elementTaken[0])
            return nums[pos];
        else if (pos==nums.length-1 && elementTaken[0])
            return 0;

        if(mapOfPositionToValues.containsKey(pos))
            return mapOfPositionToValues.get(pos);

        elementTaken[pos] =true;
        int sum = 0;
        int num=nums[pos];
        int k=0;
        while(k<=1){
            if(pos+2+k<nums.length && !elementTaken[pos+2+k]){
                sum = Math.max(sum , rob(pos+2+k , nums,mapOfPositionToValues , elementTaken));
            }
            k++;
        }
        num+=sum;
        elementTaken[pos] =false;
        mapOfPositionToValues.put(pos,num);
        return num ;
    }

    public static void main(String[] args) {
        _213HouseRobberII robberII =new _213HouseRobberII(new int[]{6,6,4,8,4,3,3,10});
        System.out.println(robberII.rob());
    }
}
