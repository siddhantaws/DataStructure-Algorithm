package com.wfs.amazon.dynamicprograming;

public class _174DungeonGame {
    private int [][]dungeon;
    private int [][]dpArr;

    public _174DungeonGame(int[][] arr) {
        this.dungeon = arr;
        this.dpArr =new int[dungeon.length+1][dungeon[0].length+1];
        for(int i=0;i<dpArr[0].length;i++)
            this.dpArr[dpArr.length-1][i] =Integer.MAX_VALUE;
        for(int i=0;i<dpArr.length;i++)
            this.dpArr[i][dpArr.length-1] =Integer.MAX_VALUE;
        this.dpArr[dpArr.length-1][dpArr[0].length-2]=1;
        this.dpArr[dpArr.length-2][dpArr[0].length-1]=1;
    }

    public int calculateMinimumHP() {
        for(int i= dpArr.length-2;i>=0;i--)
            for(int j= dpArr.length-2;j>=0;j--){
                dpArr[i][j]=Math.min(dpArr[i+1][j],dpArr[i][j+1])-dungeon[i][j];
                if(dpArr[i][j]<1)
                    dpArr[i][j]=1;
            }

        return this.dpArr[0][0];
    }
}
