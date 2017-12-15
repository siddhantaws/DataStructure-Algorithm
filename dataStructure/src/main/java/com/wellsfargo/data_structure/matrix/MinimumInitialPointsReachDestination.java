package com.wellsfargo.data_structure.matrix;

import java.util.ArrayList;
import java.util.List;

public class MinimumInitialPointsReachDestination {

    private int[][] points;
    private int[][] auxArray;
    private List<Point> pointList;

    public MinimumInitialPointsReachDestination(int[][] points) {
        this.points = points;
        this.auxArray =new int[points.length][points[0].length];
        this.pointList =new ArrayList<>();
    }

    public List getPath() {
        int i=0, j=0;
        for(i=0;i<points.length;i++)
            for( j=0;j<points[i].length;j++)
            {
                if(i==0 && j==0){
                    auxArray[i][j] = points[i][j];
                    continue;
                }
                if(j>0)
                    auxArray[i][j] = Math.min(auxArray[i][j-1] + points[i][j],auxArray[ i==0 ? 0: i-1][j] +points[i][j]);
                else
                    auxArray[i][j] = auxArray[i-1][j] +points[i][j];
            }
        i--;j--;

        pointList.add(new Point(i,j));
        while(i!=0 && j!=0){
            if(auxArray[i][j] -points[i][j] == auxArray[i][j-1])
                pointList.add(new Point(i,--j));
            else
                pointList.add(new Point(--i,j));
        }
        pointList.add(new Point(0,0));
        return null;
    }

    public static void main(String[] args) {
        int points[][] ={{-2, -3,   3},{-5, -10,  1},{10,  30, -5}};
        MinimumInitialPointsReachDestination minimumInitialPointsReachDestination =new MinimumInitialPointsReachDestination (points) ;
        minimumInitialPointsReachDestination.getPath();
    }
}
