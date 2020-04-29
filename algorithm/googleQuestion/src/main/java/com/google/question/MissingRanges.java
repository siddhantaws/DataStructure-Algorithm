package com.google.question;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    private int[] num;
    private int lower;
    private int upper ;

    public MissingRanges(int[] nums, int lower, int upper) {
        this.num = nums;
        this.lower = lower;
        this.upper = upper;
    }
    public List<String> findMissingRanges() {
        int lastRange = lower;
        List<String> l =new ArrayList<>();
        for(int i=0;i<num.length;i++){
            if(num[i]-lastRange==1 || num[i]==lastRange){
                lastRange = num[i];
                continue;
            }
            if(num[i]-lastRange==2){
                l.add((lastRange+1)+"");
                lastRange = num[i];
            }else{
                l.add((lastRange+1)+"->"+(num[i]-1));
                lastRange = num[i];
            }
        }
        if(upper - lastRange>1){
           l.add((lastRange+1)+"->"+(upper));
        }

        return l;
    }

    public static void main(String[] args) {
        MissingRanges ranges =new MissingRanges(new int[]{0, 1, 3, 50, 75} ,0 ,99);
        for(String s :ranges.findMissingRanges())
            System.out.println(s);
    }
}
