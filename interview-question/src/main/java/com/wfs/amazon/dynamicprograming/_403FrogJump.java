package com.wfs.amazon.dynamicprograming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _403FrogJump {

    private int[] stones;

    public _403FrogJump(int[] stones) {
        this.stones = stones;
    }

    public boolean canCross() {
        Map<Integer, HashSet<Integer>> mapOfStonesToMoves =new HashMap<>();
        for(int i=0;i<stones.length;i++)
            mapOfStonesToMoves.put(stones[i], new HashSet());

        mapOfStonesToMoves.get(0).add(0);

        for(int i=0;i<stones.length;i++){
            for(int move : mapOfStonesToMoves.get(stones[i])){
                int j = i+1;
                for(int k =move-1;k<=move+1 && j<stones.length ;k++){
                    while(stones[j]<=stones[i]+k){
                        mapOfStonesToMoves.get(stones[j]).add(k);
                        j++;
                    }
                }

            }
        }
        return mapOfStonesToMoves.get(stones[stones.length-1]).size()>0 ;
    }

    public static void main(String[] args) {
        _403FrogJump frogJump =new _403FrogJump(new int[]{0,1,3,5,6,8,12,17});
        System.out.println(frogJump.canCross());
    }
}
