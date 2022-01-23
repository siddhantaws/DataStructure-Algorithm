package com.wfs.amazon.binarysearch;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class _OptimalUtilization {
    private List<int[]> a;

    private List<int[]> b;
    private int k;

    public _OptimalUtilization(List<int[]> a, List<int[]> b,int k) {
        this.a = a;
        this.b = b;
        this. k=k;
    }
    public List<int[]> getMinDiff(){
        List<int[]> l =new ArrayList<>();
        TreeMap<Integer,Integer> mapOfElementToPosition =new TreeMap<>();
        for(int arr []:a)
            mapOfElementToPosition.put(arr[1],arr[0]);
        int minAbsDiffernces = Integer.MAX_VALUE;
        for(int arr[]:b){
            int floorKey =mapOfElementToPosition.floorKey(arr[1]);
            int absDifferences = Math.abs(k-floorKey-arr[1]);
            if(absDifferences<minAbsDiffernces){
                l.clear();
                minAbsDiffernces =absDifferences;
                l.add(new int[]{arr[0] , mapOfElementToPosition.get(floorKey)});
            }else{
                l.add(new int[]{arr[0] , mapOfElementToPosition.get(floorKey)});
            }
        }
        return l;
    }
}
