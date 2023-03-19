package com.google.question;

import java.util.Map;
import java.util.TreeMap;

public class _715RangeModule {
    private TreeMap<Integer, Integer> rangeModule;

    public _715RangeModule(){
        this.rangeModule =new TreeMap<>();
    }

    public void addRange(int start , int end){
        while(true){
            Map.Entry<Integer ,Integer> floorMap = rangeModule.floorEntry(end);
            if(floorMap==null || floorMap.getValue()<start)
                break;
            start = Math.min(start ,floorMap.getKey() );
            end = Math.max(end , floorMap.getValue());
            rangeModule.remove(floorMap.getKey());
        }
        rangeModule.put(start,end);
    }

    public void removeRange(int start , int end){
        addRange(start, end);
        Map.Entry<Integer ,Integer> floorMap = rangeModule.floorEntry(start);
        rangeModule.remove(floorMap.getKey());
        if(floorMap.getKey()<start)
            rangeModule.put(floorMap.getKey() , start);
        if(floorMap.getValue()>end)
            rangeModule.put(end , floorMap.getValue());
    }


    public static void main(String[] args) {
        _715RangeModule rangeModule =new _715RangeModule();
        rangeModule.addRange(10,20);
        rangeModule.addRange(17,19);
    }
}
