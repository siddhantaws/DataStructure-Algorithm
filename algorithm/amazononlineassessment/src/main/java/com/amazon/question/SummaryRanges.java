package com.amazon.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SummaryRanges {
    private int arr[];

    public SummaryRanges(int[] arr) {
        this.arr = arr;
    }

    public List<String> summaryRanges() {
        List<String> al =new ArrayList<>();
        for(int i=0 , j=0;j<arr.length;j++){
            i=j;
            while(j+1<arr.length && arr[j]+1==arr[j+1])
                j++;
            if(i==j)
                al.add(arr[i]+"");
            else
                al.add(arr[i]+" ->"+arr[j]);
        }
        return al;
    }


    public static void main(String[] args) {
        SummaryRanges ranges =new SummaryRanges(new int[]{0,2,3,4,6,8,9});
        System.out.println(ranges.summaryRanges());
    }
}
