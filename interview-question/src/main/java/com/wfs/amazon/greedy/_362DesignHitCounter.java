package com.wfs.amazon.greedy;

import java.util.Map;
import java.util.TreeMap;

public class _362DesignHitCounter {
    /** Initialize your data structure here. */
    TreeMap<Integer,Integer> mapOfTimestampToHiotCount;
    private int totalCount =0;
    private int startHitTimeStamp =0;
    private int lastHitTimeStamp =0;
    public _362DesignHitCounter() {
        this.mapOfTimestampToHiotCount =new TreeMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(startHitTimeStamp==0 ){
            lastHitTimeStamp =startHitTimeStamp = timestamp;
            totalCount++;
            return;
        }
        if(timestamp-lastHitTimeStamp>300){
            mapOfTimestampToHiotCount.clear();
            totalCount=1;
            startHitTimeStamp= lastHitTimeStamp=timestamp ;
            mapOfTimestampToHiotCount.put(timestamp ,mapOfTimestampToHiotCount.getOrDefault(timestamp,0)+1);
            return;
        }
        mapOfTimestampToHiotCount.put(timestamp ,mapOfTimestampToHiotCount.getOrDefault(timestamp,0)+1);
        lastHitTimeStamp = timestamp;
        deleteEarlierEntry(lastHitTimeStamp-300);
    }

    private void deleteEarlierEntry(int timestamp){
        boolean flag =false;
        for(Map.Entry<Integer ,Integer> entry : mapOfTimestampToHiotCount.headMap(timestamp, true).entrySet()){
            totalCount-=entry.getValue();
            mapOfTimestampToHiotCount.remove(entry.getKey());
        }
        for(Map.Entry<Integer ,Integer> entry  : mapOfTimestampToHiotCount.entrySet()){
            if(!flag){
                flag = true;
                startHitTimeStamp =entry.getKey();
                continue;
            }
        }
    }

    private void intitalizeHitCount(int timestamp){
        mapOfTimestampToHiotCount.clear();
        totalCount=1;
        startHitTimeStamp= lastHitTimeStamp=timestamp ;
        mapOfTimestampToHiotCount.put(timestamp ,mapOfTimestampToHiotCount.getOrDefault(timestamp,0)+1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if(timestamp-lastHitTimeStamp>300){
            intitalizeHitCount(timestamp);
            return totalCount;
        }
        deleteEarlierEntry(lastHitTimeStamp-300);
        return totalCount;
    }

}
