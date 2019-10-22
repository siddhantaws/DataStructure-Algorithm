package com.amazon.question;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    private int arr[][];

    private boolean visited[][];

    private int[][] hitCount;

    private int visitedRoute[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private int[][] distanceCount;

    public ShortestDistanceFromAllBuildings(int[][] arr) {
        this.arr = arr;
        this.visited = new boolean[arr.length][arr[0].length];
        this.hitCount = new int[arr.length][arr[0].length];
        this.distanceCount = new int[arr.length][arr[0].length];
    }

    public int[] getBuildingPoint() {
        int totalBuilding = -1;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 1)
                    totalBuilding++;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 1)
                    bfs(i,j);
        int minDistance = Integer.MAX_VALUE; int x= -1;int y=-1;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == 0 && hitCount[i][j]==totalBuilding){
                    if(minDistance<distanceCount[i][j]){
                        minDistance = distanceCount[i][j];
                        x=i;y=j;
                    }
                }
        return  new int[]{x,y};
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int N = queue.size();
            for (int k = 0; k < N; k++) {
                int ar[] = queue.poll();
                for (int l = 0; l < visitedRoute.length; i++) {
                    int x = ar[0] + visitedRoute[i][0];
                    int y = ar[1] + visitedRoute[i][1];
                    if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !visited[x][y] && arr[x][y] == 0) {
                        visited[x][y] = true;
                        ++hitCount[x][y];
                        queue.add(new int[]{x, y});
                        distanceCount[x][y] = distanceCount[x][y] + distance;
                    }
                }
            }
        }
        reset();
    }

    private void reset(){
        for(int i=0;i<visited.length;i++)
            for(int j=0;j<visited[0].length;j++)
                visited[i][j]=false;
    }


}
