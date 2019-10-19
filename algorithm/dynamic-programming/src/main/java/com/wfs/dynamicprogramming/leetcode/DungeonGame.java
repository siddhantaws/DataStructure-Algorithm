package com.wfs.dynamicprogramming.leetcode;

import java.util.Arrays;

public class DungeonGame {
    private int dungeon[][];

    public DungeonGame(int[][] arr) {
        this.dungeon = arr;
    }
    public int calculateMinimumHP() {
        int row =dungeon.length; int col =dungeon[0].length;
        int dp[][] = new int[row+1][col+1];
        for(int i=0;i<=row;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[row][col-1]=1;
        dp[row-1][col]=1;

        for(int i =row-1;i>=0;i--)
            for(int j =col-1;j>=0;j--){
                int min = Math.min(dp[i][j+1] ,dp[i+1][j]-dungeon[i][j]);
                dp[i][j] = min<=0 ? 1 : min;
            }
        System.out.println(dp[0][0]);
        return dp[0][0];

    }

    public int calculateMinimumHPUtil(int[][] dungeon,int row, int col) {
        if(row>=dungeon.length || col >=dungeon[0].length)return Integer.MAX_VALUE;

        int right=calculateMinimumHPUtil(dungeon,row,col+1);
        int down=calculateMinimumHPUtil(dungeon,row+1,col);

        if(right==Integer.MAX_VALUE && down ==Integer.MAX_VALUE){
            if((1-dungeon[row][col])<=0)
                return 1;
            else
                return 1-dungeon[row][col];
        }

        int currMin =Math.min(right,down)-dungeon[row][col];
        if(currMin<=0)
            return 1;
        else
            return currMin;
    }

    public static void main(String[] args) {
        int dungeon[][] ={
                {-2,-5,3},
                {-5,-10,1},
                {10,30,-5}};
        DungeonGame game =new DungeonGame(dungeon);
        System.out.println(game.calculateMinimumHPUtil(dungeon ,0,0));
    }
}
