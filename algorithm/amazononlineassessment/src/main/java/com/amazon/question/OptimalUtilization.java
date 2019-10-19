package com.amazon.question;

import java.util.*;

public class OptimalUtilization {
    private int arr1[][];
    private int arr2[][];
    private int target;

    public OptimalUtilization(int[][] arr1,int[][] arr2, int target) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.target = target;
    }
    List<int[]> getOptimalValue(){
        Arrays.sort(arr1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]- o2[1];
            }
        });
        Arrays.sort(arr2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]- o2[1];
            }
        });
        int l =0; int r =arr2.length-1;
        int minDiff = Integer.MAX_VALUE;
        List<int[]> list =new ArrayList<>();
        while(l<r){
            int diff = Math.abs((arr1[l][1] + arr2[r][1]) - target);
            if((arr1[l][1] + arr2[r][1]) == target ){
                if(minDiff==0)
                    list.add(new int[]{arr1[l][0], arr2[r][0]});
                else{
                    list = new ArrayList<>();
                    list.add(new int[]{arr1[l][0], arr2[r][0]});
                }
            }else if(minDiff> diff) {
                list = new ArrayList<>();
                list.add(new int[]{arr1[l][0], arr2[r][0]});
            }else if(minDiff == diff){
                list.add(new int[]{arr1[l][0], arr2[r][0]});
            }
        }
        return list;
    }

    public static void main(String[] args) {
       int a [][]= { {1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int b [][]= { {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        OptimalUtilization utilization =new OptimalUtilization(a , b , 10);
        utilization.getOptimalValue();
    }
}
