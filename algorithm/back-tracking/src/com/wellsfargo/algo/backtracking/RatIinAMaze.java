package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatIinAMaze {

    private int arr[][];
    private List<Points> points;

    public RatIinAMaze(int[][] arr) {
        this.arr = arr;
        points =new ArrayList<>();
    }

    public List<Points> getPathInAMaze()
    {
        getPathInAMaze(0 , 0);
        return points;
    }

    private boolean getPathInAMaze(int x ,int y)
    {
        if(x>arr.length-1 || y >arr[0].length-1 ||  arr[x][y]!=1)
            return false;
        if( x == arr.length-1 && y==arr[0].length-1)
        {
            points.add(new Points(x ,y));
            return true;
        }
        else
            for(int i=0;i<=1;i++)
            {
                points.add(new Points(x ,y));
                if(getPathInAMaze(x+1 , y))
                   return true;
                if(getPathInAMaze(x , y+1))
                    return true;
                points.remove(new Points(x ,y));
            }
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = {{1, 1, 1, 0},
                        {1, 0, 1, 1},
                        {0, 1, 0, 1},
                        {1, 1, 1, 1}
        };
        RatIinAMaze ratIinAMaze =new RatIinAMaze(maze);
        ratIinAMaze.getPathInAMaze();
    }

}
