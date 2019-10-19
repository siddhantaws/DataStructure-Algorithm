package com.amazon.question;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectingCitiesWithMinimumCost {
    private int arr[][];

    private int N;

    public ConnectingCitiesWithMinimumCost(int[][] arr,int N) {
        this.arr = arr;
        this.N=N;
    }

    public int minimumCost() {
        int sum = 0;
        boolean visited[]= new boolean[N];
        Queue<int[]> queue =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int firstVertex = arr[0][0];
        visited[firstVertex-1] =true;
        int visitedCount =1;
        for(int i=0;i<arr.length;i++)
            if(arr[i][0]==firstVertex)
                queue.add(arr[i]);
        while(!queue.isEmpty()){
            int a[] = queue.poll();
            if(visited[a[1]-1])
                continue;
            visited[a[1]-1]=true;
            visitedCount++;
            firstVertex = a[1];
            sum+=a[2];
            for(int i=0;i<arr.length;i++)
                if(arr[i][0]==firstVertex && !visited[arr[i][1]-1])
                    queue.add(arr[i]);
        }
        return visitedCount==N ? sum : -1;
    }

    public static void main(String[] args) {
        int connections[][] = {{2,1,50459},{3,2,47477},{4,2,52585},{4,2,52585},{5,3,16477}};
        ConnectingCitiesWithMinimumCost cities =new ConnectingCitiesWithMinimumCost(connections , 5);
        System.out.println(cities.minimumCost());
    }
}
