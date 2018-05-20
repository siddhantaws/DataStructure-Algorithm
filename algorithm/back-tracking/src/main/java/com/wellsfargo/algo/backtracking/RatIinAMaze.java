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
        else {
            int size = points.size();
            points.add(size, new Points(x, y));
            if (getPathInAMaze(x + 1, y) || getPathInAMaze(x, y + 1))
                return true;
            else
                points.remove(size);
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
        List<Points> pathInAMaze=ratIinAMaze.getPathInAMaze();
        for(Points points: pathInAMaze){
            System.out.println(points);
        }
    }

}
