package com.wfs.amazon.hashing;

import java.util.HashMap;
import java.util.Map;

public class _957PrisonCellsAfterNDays {
    private int[] cells;
    private int N;

    public _957PrisonCellsAfterNDays(int[] cells, int n) {
        this.cells = cells;
        N = n;
    }
    public int[] prisonAfterNDays() {
        Map<Integer,Integer> mapOfIntegerToCellCount =new HashMap<>();
        int initialState =0x0;
        for(int cell :cells){
            initialState<<=1;
            initialState|=cell;
        }
        boolean isFastForward =false;
        while(N>0){
            if(!isFastForward){
                if(mapOfIntegerToCellCount.containsKey(initialState)){
                   isFastForward =true;
                }else{
                    mapOfIntegerToCellCount.put(initialState,N);
                }
            }
            if(N>0){
                N--;
               // initialState =
            }
        }

        int returnArray[] =new int[cells.length];
        for(int i=cells.length;i>=0;i--){
            returnArray[i]=initialState &1;
            initialState>>=1;
        }
        return returnArray;
    }

}
