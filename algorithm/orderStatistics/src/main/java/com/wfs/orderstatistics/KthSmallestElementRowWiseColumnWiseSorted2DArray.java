package com.wfs.orderstatistics;

import java.util.PriorityQueue;

public class KthSmallestElementRowWiseColumnWiseSorted2DArray {
    private int arr[][];

    private int k;

    private PriorityQueue<Point> pointspq;
    public KthSmallestElementRowWiseColumnWiseSorted2DArray(int[][] arr, int k) {
        this.arr = arr;
        this.k = k;
        this.pointspq =new PriorityQueue(arr[0].length);
    }

    class Point implements Comparable<Point>{
        int data ;
        int row ;
        int col;

        public Point(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Point o) {
            return this.data -o.data;
        }
    }

    public int getKthSmallest(){
        for(int i=0;i<arr[0].length;i++)
            pointspq.add(new Point(arr[i][0],i,0));
        Point  point=null;
        while(k>0){
            point =pointspq.poll();
            if(point.col!=arr[0].length)
                pointspq.add(new Point(arr[point.row][point.col+1] , point.row , point.col+1));
            k--;
        }
        return point.data;
    }

}
