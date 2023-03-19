package com.google.question;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1293_Shortest_PathGridWithObstaclesElimination {
    public static void main(String[] args) {
        _1293_Shortest_PathGridWithObstaclesElimination grid =new _1293_Shortest_PathGridWithObstaclesElimination();
        grid.shortestPath(new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}, 2);
    }
    public int shortestPath(int[][] grid, int k) {
        final Set<Step> setOfSteps = new HashSet<>();
        final Queue<Step> queue= new LinkedList<>();
        final Step initialStep = new Step(0,0, 1,  grid[0][0]== 1 ? 1 : 0);
        queue.add(initialStep);
        setOfSteps.add(initialStep);
        int arr[][] ={{0,1},{0,-1},{1,0},{-1,0}};
        while(queue.size()>0) {
            final Step pollStep = queue.poll();
            if(pollStep.x == grid.length-1 && pollStep.y ==grid[0].length-1)
                return pollStep.currentstep;

            for(int directions[] :arr){
                int currentX = pollStep.x + directions[0];
                int currentY = pollStep.y + directions[1];
                if(isValid(currentX , currentY ,pollStep.numberOfObstacles ,grid , k )){
                    final Step newStep = new Step(currentX , currentY ,pollStep.currentstep+1 , grid[currentX][currentY]== 1 ?pollStep.numberOfObstacles+1 : pollStep.numberOfObstacles);
                    if(!setOfSteps.contains(newStep)){
                        setOfSteps.add(newStep);
                        queue.add(newStep);
                    }
                }
            }

        }
        return -1;
    }


    private boolean isValid(int x , int y, int currentObstaclesCount ,int[][] grid , int k){
        if(!(x>=0 && x<grid.length-1 && y>=0 && y<grid[0].length))
            return false;
        if(grid[x][y]==1){
            return currentObstaclesCount+1<=k ;
        }
        return true;
    }

    static class Step{

        int x;
        int y;
        int currentstep;
        int numberOfObstacles;

        Step(int x , int y , int currentstep ,int numberOfObstacles ){
            this.x= x;
            this.y= y;
            this.currentstep = currentstep;
            this.numberOfObstacles = numberOfObstacles;
        }

        public int hashCode(){
            int hashCode = 31*7 +  Integer.valueOf(x);
            hashCode +=31*7 +  Integer.valueOf(y);
            hashCode +=31*7 +  Integer.valueOf(numberOfObstacles);
            return hashCode;
        }

        public boolean equals(final Object o){
            if(!o.getClass().equals(this.getClass()))
                return false;
            if(!(o instanceof Step))
                return false;
            final Step s = (Step)o;

            return s.x==this.x && s.y==this.y && s.numberOfObstacles == this.numberOfObstacles;
        }

        @Override
        public String toString() {
            return "Step{" +
                    "x=" + x +
                    ", y=" + y +
                    ", currentstep=" + currentstep +
                    ", numberOfObstacles=" + numberOfObstacles +
                    '}';
        }
    }
}
