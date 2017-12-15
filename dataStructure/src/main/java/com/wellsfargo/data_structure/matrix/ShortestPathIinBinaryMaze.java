package com.wellsfargo.data_structure.matrix;

import java.util.*;

public class ShortestPathIinBinaryMaze {

    private int[][]mat;

    private Point destPoint;

    private Queue<Point> pointList;

    public ShortestPathIinBinaryMaze(int[][] mat ,Point destPoint) {
        this.mat = mat;
        this.destPoint= destPoint;
        this.pointList=new ArrayDeque<>();
    }

    public List<Point> getShottestPath()
    {
        Point sourcePoint =  new Point(0,0);
        pointList.add(sourcePoint);
        List<Point> points=new ArrayList<>() ;
        Set<Point> visited=new HashSet<>();
        visited.add(sourcePoint);
        while(!pointList.isEmpty()){
            Point point= pointList.peek();
            if(point.getX() ==destPoint.getX() && point.getY()==destPoint.getY())
                return points;
            point = pointList.poll();
            for(int i=0;i<4;i++)
            {
                Point newPoint =null ;
                switch (i) {
                    case 0:
                        newPoint = new Point(point.getX() + 1, point.getY());
                        break;
                    case 1:
                        newPoint = new Point(point.getX(), point.getY() + 1);
                        break;
                    case 2:
                        newPoint = new Point(point.getX() - 1, point.getY());
                        break;
                    case 3:
                        newPoint = new Point(point.getX(), point.getY() - 1);
                        break;
                }
                if(isValid(newPoint) && mat[newPoint.getX()][newPoint.getY()] ==1 && !visited.contains(newPoint)){
                    visited.add(newPoint);
                    pointList.add(newPoint);
                }
            }
        }
        return points;
    }

    private boolean isValid(Point point) {
        return point.getX()>=0 && point.getY()>=0 && point.getX()<=destPoint.getX() && point.getY()<=destPoint.getY();
    }


    public static void main(String[] args) {
        ShortestPathIinBinaryMaze
                shortestPathIinBinaryMaze = new ShortestPathIinBinaryMaze(new int[][]{
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        } , new Point(3,4));
        shortestPathIinBinaryMaze.getShottestPath();

    }
}
