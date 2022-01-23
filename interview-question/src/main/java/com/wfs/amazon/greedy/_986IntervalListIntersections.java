package com.wfs.amazon.greedy;

import java.util.ArrayList;
import java.util.List;

public class _986IntervalListIntersections {
    private int[][] arr1;

    private int[][] arr2;

    public _986IntervalListIntersections(int[][] arr1, int[][] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public int[][] intervalIntersection() {
        List<int[]> list =new ArrayList<>();
        int i=0;int j=0;
        while(i<arr1.length && j<arr2.length){
            int low = Math.max(arr1[i][0],arr1[j][0]);
            int high = Math.min(arr1[i][1],arr1[j][1]);
            if(low<=high)
            list.add(new int[]{low,high});

            if(arr1[i][0]>arr2[j][0])
                j++;
            else
                i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        _986IntervalListIntersections intersections =new _986IntervalListIntersections(new int[][] {{0,2},{5,10},{13,23},{24,25}} ,
                new int[][] {{1,5},{8,12},{15,24},{25,26}});
        intersections.intervalIntersection();
    }
}
