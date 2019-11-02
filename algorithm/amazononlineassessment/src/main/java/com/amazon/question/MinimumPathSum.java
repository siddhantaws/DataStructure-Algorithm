package com.amazon.question;

public class MinimumPathSum {

    private int arr[][];

    public MinimumPathSum(int[][] arr) {
        this.arr = arr;
    }

    public int minPathSum() {
        int arr1[]= new int[arr[0].length];
        System.arraycopy(arr[0],0, arr1,0,arr[0].length);
        for(int i=1;i<arr1.length;i++)
            arr1[i]+= arr1[i-1];
        for(int i=1;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++){
                if(j==0)
                    arr1[j] += arr[i][j];
                else
                    arr1[j] = Math.min(arr1[j-1] +arr[i][j] , arr[i][j] +  arr1[j]) ;
            }
        return arr1[arr1.length-1];
    }

    public static void main(String[] args) {
       int arr[][]= {{1,3,1}};
        MinimumPathSum pathSum =new MinimumPathSum(arr);
        System.out.println(pathSum.minPathSum());
    }
}
