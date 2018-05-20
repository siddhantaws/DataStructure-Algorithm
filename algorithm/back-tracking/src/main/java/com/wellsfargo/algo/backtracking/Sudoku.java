package com.wellsfargo.algo.backtracking;

import com.wellsfargo.data_structure.matrix.Point;

public class Sudoku {

    private int arr[][];

    private static final int UNASSIGNED = -0;

    private boolean usedInCols(int i ,int j , int val){
        for(int k=0;k<i;k++)
            if(arr[k][j]==val)
                return true;
        return false;
    }

    private boolean usedInRows(int i ,int j , int val){
        for(int k=0;k<j;k++)
            if(arr[i][k]==val)
                return true;
        return false;
    }

    private boolean usedInBox(int i ,int j , int val){
        for(int k=0;k<3;k++)
            for(int l=0;l<3;l++)
            if(arr[k+i][l+j]==val)
                return true;
        return false;
    }

    private Point isUnassignedLocation(){
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                if(arr[i][j]==UNASSIGNED)
                    return new Point(i , j);
        return null;
    }

    private boolean isSafe(Point point ,int val){
        return !usedInRows(point.getX(),point.getY() ,val) &&
               !usedInCols(point.getX(),point.getY() ,val) &&
               !usedInBox(point.getX(),point.getY() ,val);

    }

    public boolean solveSudoku(){
        Point point = isUnassignedLocation();
        if(point==null)
            return true;
        for(int k=1;k<10;k++){
            if(isSafe(point ,k )){
                arr[point.getX()][point.getY()]=k;

                if(solveSudoku())
                    return true;
                else
                    arr[point.getX()][point.getY()]= UNASSIGNED;
            }
        }
        return isUnassignedLocation() ==null;
    }

}
