package com.amazon.question;

import java.util.HashSet;
import java.util.Set;

public class NumberIslands {
    private int arr[][];

    private int direction[][]=new int[][]{{0,-1} ,{0,1} ,{-1,0},{1,0}};

    private Set<String> stringSet =new HashSet<>();

    public NumberIslands(int[][] arr) {
        this.arr = arr;
    }

    public int numIslands() {
        int count =0;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                if(arr[i][j]==1 && !stringSet.contains(i+","+j)){
                    stringSet.add(i+","+j);
                    count += dfs(i,j);
                }
        return count;
    }

    private int dfs(int x ,int y){
        for(int i=0;i<direction.length;i++){
            int x1 = x+direction[i][0];
            int y1 = y+direction[i][1];
            if(isValid(x1,y1)){
                stringSet.add(x1+","+y1);
                dfs(x1,y1);
            }
        }
        return 1;
    }

    private boolean isValid(int x , int y){
        return x>=0 && x<arr.length && y>=0 && y<arr[0].length && arr[x][y]==1 && !stringSet.contains(x+","+y);
    }

    public static void main(String[] args) {
        //int arr[][]={{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int arr[][]= {{1,1,0,0,0} , {1,1,0,0,0} ,{0,0,1,0,0},{0,0,0,1,1}};
        NumberIslands islands =new NumberIslands(arr);
        System.out.println(islands.numIslands());
    }
}
