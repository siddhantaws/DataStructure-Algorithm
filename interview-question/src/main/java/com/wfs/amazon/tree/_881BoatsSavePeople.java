package com.wfs.amazon.tree;

import java.util.Arrays;
import java.util.TreeMap;

public class _881BoatsSavePeople {
    private int[] people;

    private int limit ;

    private TreeMap<Integer,Integer> treeMap;

    public _881BoatsSavePeople(int[] people, int limit) {
        this.people = people;
        this.limit = limit;
        this.treeMap =new TreeMap<>();
    }

    public int numRescueBoats() {
        int count =0;
        if(people.length==0 || people.length==1)
            return people.length;
        Arrays.stream(people).forEach(k->{
            treeMap.compute(k, (key,value)-> value ==null ? 1 : value+1);
        });
        while(treeMap.size()>1){
            if(!treeMap.lastKey().equals(treeMap.firstKey()) && treeMap.lastKey()+treeMap.firstKey()<=limit){
                treeMap.compute(treeMap.lastKey(), (k,v)-> v==1 ? null : v-1);
                treeMap.compute(treeMap.firstKey(), (k,v)-> v==1 ? null : v-1);
            }else {
                treeMap.compute(treeMap.lastKey(), (k,v)-> v==1 ? null : v-1);
            }
            count++;
        }
        int sum =0;
        while(treeMap.size()>0){
            sum+=treeMap.lastKey();
            treeMap.compute(treeMap.lastKey(), (k,v)-> v==1 ? null : v-1);
            if(sum==limit){
                count++;
                sum=0;
            }
        }
        return sum>0 ?  count+1 : count;
    }

    public static void main(String[] args) {
        _881BoatsSavePeople savePeople =new _881BoatsSavePeople(new int[]{3,2,2,1} ,3);
        System.out.println(savePeople.numRescueBoats());
    }
}
