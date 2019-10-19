/*
package com.amazon.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnections {

    private List<List<Integer>> connections;

    private List<List<Integer>> currList;

    private int N ;

    private int count =0;

    public CriticalConnections(List<List<Integer>> connections, int N) {
        this.connections = connections;
        this.currList =new ArrayList<>();
        this.N= N;
    }

    public List<List<Integer>> criticalConnections() {
        Map<Integer,List<Integer>> map =new HashMap<>();
        for(int i=0;i<connections.size();i++){
            criticalConnections(i,map);
        }
        return currList;
    }

    public void criticalConnections(int i , Map<Integer,List<Integer>> map) {
        if(map.containsKey(i)){
            return;
        }
        count++;
        List<Integer> list =new ArrayList<>();list.add(count);list.add(count);
        map.put(i,list);
        for(Integer integer :getAdjacentNode(i)){
            criticalConnections(integer, map);
            if(connections.get(i).get(0)<connections.get(i).get(1))
        }
        int minValue = getAdjacentNode(i , map);
        map.get(i).set(1,minValue );
    }

    private int getAdjacentNode(int value , Map<Integer,List<Integer>> map ){
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<connections.size();i++){
            if(connections.get(i).get(0)==value)
                minValue =Math.min(minValue , map.get(i).get(1));
        }
        return minValue;
    }

    private List<Integer> getAdjacentNode(int value){
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<connections.size();i++){
            if(connections.get(i).get(0)==value)
                list.add(i);
        }
        return list;
    }

    private int getIndex(int index){
        for(int i=0;i<connections.size();i++){
            if(connections.get(i).get(0)==index)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists =new ArrayList<>();
        List<Integer> l =new ArrayList<>();l.add(0);l.add(1);lists.add(l);
        l =new ArrayList<>();l.add(1);l.add(2);lists.add(l);
        l =new ArrayList<>();l.add(2);l.add(0);lists.add(l);
        l =new ArrayList<>();l.add(1);l.add(3);lists.add(l);
        CriticalConnections criticalConnections =new CriticalConnections(lists , 4);
        criticalConnections.criticalConnections();
    }
}
*/
