package com.wfs.dynamicprogramming;

public class MinimumCostPolygonTriangulation {


    private double cost(Point points[], int i, int j, int k)
    {
        Point p1 = points[i], p2 = points[j], p3 = points[k];
        return dist(p1, p2) + dist(p2, p3) + dist(p3, p1);
    }
    private double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
    }

    private double min(double x, double y)
    {
        return (x <= y)? x : y;
    }

    public double minimumCostTringulation(Point points[], int i, int j)
    {
        // There must be at least three points between i and j
        // (including i and j)
        if (j < i+2)
            return 0;

        // Initialize result as infinite
        double res = Double.MAX_VALUE;

        // Find minimum triangulation by considering all
        for (int k=i+1; k<j; k++)
        {
            System.out.println( i +"\t"+ j+"\t"+k );
            res = min(res, (minimumCostTringulation(points, i, k) + minimumCostTringulation(points, k, j) +
                    cost(points, i, k, j)));
        }

        return  res;
    }


    public double minimumCostTringulationUsingDP(Point points[], int n){
        // There must be at least 3 points to form a triangle
        if (n < 3)
            return 0;
        // table to store results of subproblems.  table[i][j] stores cost of
        // triangulation of points from i to j.  The entry table[0][n-1] stores
        // the final result.
        double table[][]=new double[n][n];
        for(int i=0;i<table.length;i++)
            for(int j=0;j<table[0].length;j++)
                table[i][j]=-1;
        // Fill table using above recursive formula. Note that the table
        // is filled in diagonal fashion i.e., from diagonal elements to
        // table[0][n-1] which is the result.
        for (int gap = 0; gap < n; gap++)
        {
            for (int i = 0, j = gap; j < n; i++, j++)
            {
                if (j < i+2)
                    table[i][j] = 0.0;
                else
                {
                    table[i][j] = Double.MAX_VALUE;
                    for (int k = i+1; k < j; k++)
                    {
                        double val = table[i][k] + table[k][j] + cost(points,i,j,k);
                        if (table[i][j] > val)
                            table[i][j] = val;
                    }
                }
            }
        }
        return  table[0][n-1];

    }

    public static void main(String[] args) {
        Point points[] = new Point[]{ new Point(0, 0), new Point(0, 2), new Point(1, 2),new Point(2, 0)};
        MinimumCostPolygonTriangulation minCost=new MinimumCostPolygonTriangulation();
        System.out.println(minCost.minimumCostTringulation(points , 0 , points.length-1));
    }
}

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}