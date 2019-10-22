package com.amazon.question;

import java.util.*;

public class InsertInterval {

    private int[][] intervals ;

    private int[] newInterval;

    private Queue<int[]> queue;

    public InsertInterval(int[][] intervals, int[] newInterval) {
        this.intervals = intervals;
        this.newInterval = newInterval;
        this.queue=new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });
        for(int i=0;i<intervals.length;i++)
            queue.add(intervals[i]);
        queue.add(newInterval);
    }

    public int[][] insert() {
        List<int[]> l =new ArrayList<>();
        while(queue.size()>1){
            int first[]= queue.poll();
            int second[]= queue.poll();
            if(isOverLapping(first,second)){
                queue.add(merge(first,second));
            }else{
                l.add(first);
                queue.add(second);
            }
        }
        if(queue.size()==1)
            l.add(queue.poll());
        int arr[][]=new int[l.size()][];
        for(int i=0;i<l.size();i++)
            arr[i]=l.get(i);
        return arr;
    }

    private int[] merge(int first[] , int second[]){
        int temp []=new int[]{Math.min(first[0],second[0]) , Math.max(second[1],first[1]) };
        return temp;
    }

    private boolean isOverLapping(int first[] , int second[]){
        if(first[0]<=second[0] && first[1]>=second[0])
            return true;
        return false;
    }

    public static void main(String[] args) {
        int [][]intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        InsertInterval interval =new InsertInterval(intervals , newInterval);
        interval.insert();
    }
}

