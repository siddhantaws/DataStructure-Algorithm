package com.wfs.amazon.tree;

import java.util.Map;
import java.util.TreeMap;

public class _352DataStreamDisjointIntervals {

    private TreeMap<Integer,Integer> mapOfElemets;
    /** Initialize your data structure here. */
    public _352DataStreamDisjointIntervals() {
        this. mapOfElemets =new TreeMap<Integer,Integer>();
    }

    public void addNum(int val) {
        if(mapOfElemets.isEmpty() || (val< mapOfElemets.firstKey() && mapOfElemets.firstKey()-val >1) ||
                (val> mapOfElemets.get(mapOfElemets.lastKey()) && val-mapOfElemets.get(mapOfElemets.lastKey()) >1 ) ){
            mapOfElemets.put(val,val);
            return;
        }

        Integer floorKey = mapOfElemets.floorKey(val);
        Integer ceilKey = mapOfElemets.ceilingKey(val);
        if(ceilKey==null)
            return ;
        if(floorKey==null){
            mapOfElemets.put( val, mapOfElemets.remove(ceilKey)) ;
            return;
        }
        if(val -mapOfElemets.get(floorKey)==1 && ceilKey-val==1 ){
            mapOfElemets.put(floorKey ,mapOfElemets.remove(ceilKey) );
            return;
        }

        mapOfElemets.put(val,val);
    }

    public int[][] getIntervals() {
        int[][] returnInterval =new int[mapOfElemets.size()][2];int i=0;
        for(Map.Entry<Integer,Integer> entry : mapOfElemets.entrySet()){
            returnInterval[i][0]=entry.getKey();
            returnInterval[i++][1]=entry.getValue();
        }
        return returnInterval;
    }

    public static void main(String[] args) {
        _352DataStreamDisjointIntervals streamDisjointIntervals =new _352DataStreamDisjointIntervals();
        streamDisjointIntervals.addNum(1);
        streamDisjointIntervals.addNum(3);
        streamDisjointIntervals.addNum(2);
    }
}
