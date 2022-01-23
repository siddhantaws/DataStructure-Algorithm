package com.wfs.amazon.dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class _931MinimumFallingPathSum {
    Map<String,Integer> mapOfCoordinatesToMinCost =new HashMap<>();
    private int minCost =Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] A) {
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<A[0].length;i++)
            minCost= Math.min(minCost, minFallingPathSum(A, 0,i));
        return  minCost;
    }

    private int minFallingPathSum(int [][]A , int row , int col){
        if(row==A.length)
            return Integer.MAX_VALUE;
        if(row==A.length-1)
            return A[row][col];

        if(mapOfCoordinatesToMinCost.containsKey(getKey(row,col)))
            return mapOfCoordinatesToMinCost.get(getKey(row,col));

        int cost = Integer.MAX_VALUE;
        for(int j=-1;j<2;j++){
            if(validColumn(row+j ,A))
                cost = Math.min(cost ,minFallingPathSum(A, row+1 , row+j) );
        }
        mapOfCoordinatesToMinCost.put(getKey(row,col) , cost);

        return mapOfCoordinatesToMinCost.get(getKey(row,col));
    }

    private boolean validColumn(int j,int[][] A){
        return j>=0 && j<A[0].length;
    }
    private String getKey(int i,int j){
        return i+"$"+j;
    }
}
