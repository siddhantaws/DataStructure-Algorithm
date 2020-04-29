package com.google.question;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    private int[] nums;

    public SummaryRanges(int[] nums) {
        this.nums = nums;
    }

    public List<String> summaryRanges() {
        int startIndex = 0;
        List<String> l =new ArrayList<>();
        if(nums.length==0)
            return l;
        if(nums.length==1){
            l.add(nums[0]+"");
            return l;
        }
        for(int i=1;i<nums.length;){
            int currIndex=startIndex;
            while(i<nums.length && nums[i]-nums[currIndex]==1){
                currIndex=i++;
            }
            if(currIndex==startIndex){
                l.add(nums[currIndex]+"");
                startIndex =i++;
            }else{
                l.add(nums[startIndex]+"->"+nums[currIndex]);
                startIndex =i++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        SummaryRanges ranges =new SummaryRanges(new int[]{0,1,2,4,5,7});
        for (String s :ranges.summaryRanges())
            System.out.println(s);
    }
}
