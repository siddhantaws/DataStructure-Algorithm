package com.wfs.amazon.dfs;

import java.util.*;

public class _694NumberDistinctIslands {

    private int arr[][];
    private Set<String> setOfDistinctPath;
    private Queue<String> listOfOnes;

    public _694NumberDistinctIslands(int[][] arr) {
        this.arr = arr;
        this.setOfDistinctPath =new HashSet<>();
        this.listOfOnes =new ArrayDeque<>();
    }

    public int numDistinctIslands() {
        int count =0;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++){
                numDistinctIslands(i,j, "00");
                String pathString = null;
                if(!listOfOnes.isEmpty() && !setOfDistinctPath.contains(pathString =getPathInString(listOfOnes))){
                    count++;
                    setOfDistinctPath.add(pathString);
                }
            }
        return count;
    }

    private String getPathInString(Queue<String> pathInString){
        StringBuilder sb =new StringBuilder();
        while (!pathInString.isEmpty())
            sb.append(pathInString.poll());
        return sb.toString();
    }


    private void numDistinctIslands(int i, int j ,String str){
        if(i>=0 && i<arr.length && j>=0 && j<arr[i].length && arr[i][j]==1){
            arr[i][j]=-1;
            listOfOnes.add(str);
            numDistinctIslands(i+1,j,"A");
            numDistinctIslands(i,j+1,"B");
            numDistinctIslands(i,j-1,"C");
            numDistinctIslands(i-1,j,"D");
            listOfOnes.add("$");
        }
    }

    public static void main(String[] args) {
        int arr[][]= {{1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        };
        int arr1 [][]={
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        };
        _694NumberDistinctIslands distinctIslands =new _694NumberDistinctIslands(arr1);
        System.out.println(distinctIslands.numDistinctIslands());
    }
}
