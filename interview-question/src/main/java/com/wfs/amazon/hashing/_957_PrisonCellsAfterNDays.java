package com.wfs.amazon.hashing;

import java.util.HashMap;
import java.util.Map;

public class _957_PrisonCellsAfterNDays {
    private int arr[];

    private int N;

    public _957_PrisonCellsAfterNDays(int[] arr, int n) {
        this.arr = arr;
        N = n;
    }

    public int[] getPrisonAfterNDays(int[] cells, int N){
        Map<Integer,Integer> mapOfNumberToPrisionCells =new HashMap<>();
        boolean matchPatternFound =false;
        while(N>0){
            if(!matchPatternFound){
                int hashNumber =calcuateHashFromArray(cells);
                if(mapOfNumberToPrisionCells.containsKey(hashNumber)){
                    N= N%(mapOfNumberToPrisionCells.get(hashNumber)-N);
                    matchPatternFound =true;
                }else{
                    mapOfNumberToPrisionCells.put(hashNumber,N);
                }
            }
            if (N-->0){
                cells = getPrisionCellAfterOneDay(cells);
            }
        }
        return cells;
    }

    private int[] getPrisionCellAfterOneDay(int[] cells){
        int prev = cells[0];
        for(int i=1;i<cells.length-2;i++){
            if(cells[i-1] == cells[i+1]){
                cells[i]=prev;
                prev =1;
            }else{
                cells[i]=prev;
                prev =0;
            }
        }
        return  cells;
    }

    private int calcuateHashFromArray(int[] cells){
        int num=0;
        for(int i=cells.length-1;i>=0;i--){
            num+= (int)Math.pow(2,cells[i]);
        }
        return num;
    }
}
