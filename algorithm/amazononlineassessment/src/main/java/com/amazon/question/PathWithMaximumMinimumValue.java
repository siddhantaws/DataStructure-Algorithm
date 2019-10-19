package com.amazon.question;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumMinimumValue {
    private int arr[][];
    private boolean visited[][];

    public PathWithMaximumMinimumValue(int[][] arr) {
        this.arr = arr;
        this.visited = new boolean[arr.length][arr[0].length];

    }

    public int maximumMinimumPath() {
        int traverserArr[][]={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> queue =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] -o1 [2];
            }
        });
        queue.add(new int[]{0,0,arr[0][0]});
        visited[0][0] =true;
        while(!queue.isEmpty()){
            int res[] = queue.poll();
            if(res[0]==arr.length-1 && res[1]==arr[0].length-1)
                return res[2];
            for(int i=0;i<traverserArr.length;i++) {
                int X = res[0]+ traverserArr[i][0];
                int Y = res[1]+ traverserArr[i][1];
                if(X<arr.length && X>=0 && Y<arr[0].length && Y>=0  && !visited[X][Y]){
                    queue.add(new int[]{X,Y, Math.min( arr[X][Y] , res[2] )});
                    visited[X][Y]=true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[][] ={{5,4,5},{1,2,6},{7,4,6}};
        PathWithMaximumMinimumValue withMaximumMinimumValue =new PathWithMaximumMinimumValue(arr);
        System.out.println(withMaximumMinimumValue.maximumMinimumPath());
    }
}
