package com.wfs.orderstatistics;

public class KadanesAlgo {
    private int arr[];

    public KadanesAlgo(int[] arr) {
        this.arr = arr;
    }

    public int getLargestSumContiguous(){
        int max =arr[0];
        int currentMax = arr[0];
        for(int i=1;i<arr.length;i++){
            currentMax =Math.max(currentMax+arr[i] , arr[i]);
            max =Math.max(arr[i] ,Math.max(max , currentMax));
        }
        return max;
    }

    public static void main(String[] args) {
        KadanesAlgo algo =new KadanesAlgo(new int[]{-2,-3,4,-1,-2,1,5,-3});
        System.out.println(algo.getLargestSumContiguous());
    }
}
