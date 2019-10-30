package com.amazon.question;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class Unique_Paths_III {
    private int arr[][];

    private int numberOfZeros;

    private SetAndStackDS setAndStackDS;

    private int [][] visitedArray;

    private Point startPoint ;

    public Unique_Paths_III(int[][] arr) {
        this.arr = arr;
        this.setAndStackDS=new SetAndStackDS();
        this.visitedArray =new int[][]{{-1,0} , {0,-1} ,{0,1}, {1,0}};
        this.init();
    }

    public void init(){
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                if(arr[i][j]==0)
                    numberOfZeros++;
                else if(arr[i][j]==1)
                    startPoint =new Point(i,j);
    }

    public int uniquePathsIII(){
        setAndStackDS.add(startPoint);
        return  uniquePathsIII(startPoint);
    }

    public int uniquePathsIII(Point p) {
        int count=0;
        if(arr[p.x][p.y]==2){
            if(setAndStackDS.size()==numberOfZeros+2)
                return 1;
            else
                return 0;
        }else{
            for(int i=0;i<visitedArray.length;i++){
                Point point=new Point(p.x+visitedArray[i][0] , p.y+visitedArray[i][1]);
                if(!isSafe(point))
                    continue;
                else{
                    setAndStackDS.add(point);
                    count+= uniquePathsIII(point);
                    setAndStackDS.pop();
                }
            }
        }
        return count;
    }

    private boolean isSafe(Point point ){
        return point.x>=0 && point.x<arr.length && point.y>=0 && point.y<arr[0].length && arr[point.x][point.y]!=-1 && !setAndStackDS.contains(point) ;
    }

    class SetAndStackDS{
        private Stack<Point> points;
        private Set<Point> pointSet;
        SetAndStackDS(){
            this.points =new Stack<>();
            this.pointSet =new HashSet<>();
        }

        public boolean contains(Point point){
            return pointSet.contains(point);
        }

        public void add(Point point){
            points.push(point);
            pointSet.add(point);
        }

        public void pop(){
            pointSet.remove(points.pop());
        }

        public int size(){
            return pointSet.size();
        }
    }

    public static void main(String[] args) {
        int arr[][]= {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        Unique_Paths_III  pathsIii =new Unique_Paths_III(arr);
        System.out.println(pathsIii.uniquePathsIII());
    }


    class Point{
        int x ;
        int y ;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
