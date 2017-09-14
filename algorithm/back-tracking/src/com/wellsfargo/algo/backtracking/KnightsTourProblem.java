package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightsTourProblem {

    private int rowColumnValue ;

    private List<Points> points;

    private int[][] chessArray;
    public KnightsTourProblem(int rowColumnValue) {
        this.rowColumnValue = rowColumnValue;
        this.points = new ArrayList<>();
        this.chessArray =new int[rowColumnValue][rowColumnValue];
    }

    public List<Points> getKnightTourRoute()
    {
        getKnightTourRoute(0 , 0);
        int i=1;
        for(Points point: points)
            chessArray[point.getX()][point.getY()] =i++;
        System.out.println(Arrays.deepToString(chessArray));
        return points;
    }

    private boolean getKnightTourRoute(int x , int y)
    {
        if( x<0 ||  y<0 || x>=rowColumnValue || y >=rowColumnValue)
            return  false;
        if(points.contains(new Points(x ,y)))
            return  false;
        if(points.size()==rowColumnValue*rowColumnValue)
            return true;
        else
        {
            points.add(new Points(x ,y));
            if(getKnightTourRoute(x-2 , y-1)|| getKnightTourRoute(x-2 , y+1) || getKnightTourRoute(x-1 , y-2) || getKnightTourRoute(x+1 , y-2) || getKnightTourRoute(x+2 , y-1)
             || getKnightTourRoute(x+2 , y+1) || getKnightTourRoute(x+1 , y+2) || getKnightTourRoute(x-1 , y+2))
                return true ;
            points.remove(new Points(x ,y));
        }
        return false;
    }


    public static void main(String[] args) {
        KnightsTourProblem knightsTourProblem=new KnightsTourProblem(8);
        knightsTourProblem.getKnightTourRoute();
    }
}
