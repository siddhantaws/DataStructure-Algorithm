package com.wfs.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Suryasnata on 5/16/2017.
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
 * You may assume that all costs are positive integers.
 *  1   2   3
 *  4   8   2
 *  1   5   3
 *
 *
 */
public class MinCostPath {

    private int arr[][];
    private int tempArray[][];
    public MinCostPath(int arr[][]) {
        this.arr = arr;
        tempArray=new int[arr.length][arr[0].length];
    }

    public MinCostPath() {
    }

    public List getMinCostPath()
    {
        int i =0 , j=1;
        for(i=0;i<arr.length;i++)
        {
            tempArray[i][0] = i==0 ? arr[0][0] : (tempArray[i-1][0] + arr[i][0]);
            for(j=1;j<arr[i].length;j++)
            {
                if(i==0)
                    tempArray[i][j] =tempArray[i][j-1] + arr[i][j] ;
                else
                    tempArray[i][j] =Math.min(  Math.min( tempArray[i-1][j-1] ,  tempArray[i][j-1]),tempArray[i-1][j]  ) + arr[i][j];
            }
        }
        List<Integer>  stacks=new ArrayList<>();
        i--;j--;

        while(i!=0 || j!=0)
        {
            stacks.add(arr[i][j]);
            int num =     tempArray[i][j] -  arr[i][j] ;
            if( i>0 && j> 0 && tempArray[i-1][j-1] ==num )
            {
                i-- ; j--;
            }
            else if( i>0 && tempArray[i-1][j] ==num )
                i-- ;
            else if(j>0 && tempArray[i][j-1] ==num)
                j-- ;
        }
        stacks.add(arr[0][0]);
        Collections.reverse(stacks);
        return stacks;
    }



    public static void main(String[] args) {

        MinCostPath  minCostPath =new MinCostPath(new int[][]{
                { 1 , 2 , 3 },
                { 4 , 8 , 2 },
                { 1 , 5 , 3 }
        });
        System.out.printf("minCostPath -> "+minCostPath.getMinCostPath());
    }
}
