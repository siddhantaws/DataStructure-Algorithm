package com.amazon.question;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {


    private Map<String , TreeMap<Integer,String>> map ;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.map =new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).put(timestamp,value);
        }else{
            TreeMap<Integer,String> treeMap =new TreeMap<>();
            treeMap.put(timestamp,value);
            map.put(key, treeMap);
        }
    }

    public String get(String key, int timestamp) {
        Map.Entry<Integer,String> entry1=null;
        if(map.containsKey(key)  && (entry1 =map.get(key).floorEntry(timestamp))!=null )
            return entry1.getValue();
        else
            return "";
    }


}
