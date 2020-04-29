package com.google.question;

import java.util.TreeMap;
import java.util.TreeSet;

public class ContainsDuplicate_III {
    private int arr[];
    private int k;
    private int t;

    public ContainsDuplicate_III(int[] arr, int k, int t) {
        this.arr = arr;
        this.k = k;
        this.t = t;
    }

    public boolean containsNearbyAlmostDuplicate() {
        TreeSet<Integer> treeSet =new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            int num =arr[i];
            Integer ceiling = treeSet.ceiling(num);
            if(ceiling!=null && ceiling.intValue() <=t+num)
                return true;
            Integer  flooringValue = treeSet.floor(num);
            if(flooringValue!=null && num<=flooringValue.intValue()+t)
                return true;
            treeSet.add(num);
            if(treeSet.size()>k)
                treeSet.remove(arr[i]-k);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_III iii =new ContainsDuplicate_III(new int[]{1,2,3,1} , 3,0);
        System.out.println(iii.containsNearbyAlmostDuplicate());
    }
}
