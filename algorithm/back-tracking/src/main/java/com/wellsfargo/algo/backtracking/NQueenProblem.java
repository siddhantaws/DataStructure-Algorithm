package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NQueenProblem {

    private Map<Points, Object> points;

    private int rows_Cols;

    public NQueenProblem(int rows_Cols) {
        this.rows_Cols = rows_Cols;
        this.points = new HashMap<>();
    }

    public Map<Points, Object> getNQueuePath() {
        getNQueuePath(0, 0);
        return points;
    }

    private boolean getNQueuePath(int x, int y) {
        if(points.size()== 4)
            return true;
            for (; y < rows_Cols; y++)
                if (isSafe(x, y)){
                    Points p1= new Points(x, y);
                    points.put(p1, new Object());
                    if(getNQueuePath(x+1, 0) )
                        return  true;
                    else{
                        points.remove(p1);
                        getNQueuePath(x, y+1);
                        return false;
                    }
                }
        return  false;
    }

    private boolean isSafe(int x, int y) {
        for (Points point : points.keySet()) {
            if (point.getX() == x || point.getY() == y  || ( Math.abs(point.getX() -x ) == Math.abs(point.getY() -y )) )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueenProblem nQueenProblem=new NQueenProblem(4);
        nQueenProblem.getNQueuePath();
    }
}
