package com.wfs.amazon.binarysearch;

public class _378KthSmallestElementSortedMatrix {
    private int arr[][];
    private int K;

    public _378KthSmallestElementSortedMatrix(int[][] arr,int K) {
        this.arr = arr;
        this.K=K;
    }

    public int kthSmallest() {
        int start =arr[0][0]; int end =arr[arr.length-1][arr.length-1];
        int minMaxArr[]=new int[2];
        minMaxArr[0]=start;minMaxArr[1]=end;
        while(start<end){
            minMaxArr[0]=start;minMaxArr[1]=end;
            int mid = start + (end-start)/2;
            int count = getKthElement(mid , minMaxArr);
            if(count==K)
                return minMaxArr[0];
            else if(count<K)
                start = minMaxArr[1];
            else
                end =minMaxArr[0];
        }
        return start;
    }

    private int getKthElement(int mid, int minMaxArr[]){
        int row = arr.length-1;int col =0;int count =0;
        while(row>=0 && col<arr[0].length){
            if(arr[row][col]>mid){
                minMaxArr[1] =Math.min( minMaxArr[1] , arr[row][col]);
                row--;
            }else{
                minMaxArr[0] =Math.max( minMaxArr[0] , arr[row][col]);
                col++;
                count+=row+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        _378KthSmallestElementSortedMatrix elementSortedMatrix =new _378KthSmallestElementSortedMatrix(matrix ,7);
        System.out.println(elementSortedMatrix.kthSmallest());
    }
}
