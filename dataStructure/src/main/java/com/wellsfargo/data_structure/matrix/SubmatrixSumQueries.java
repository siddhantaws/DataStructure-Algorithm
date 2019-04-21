package com.wellsfargo.data_structure.matrix;

public class SubmatrixSumQueries {

    private int arr[][];

    private int tempArray[][];


    public SubmatrixSumQueries(int[][] arr) {
        this.arr = arr;
        this.tempArray = new int[arr.length][arr[0].length];
        constructMatrix();
    }

    private void constructMatrix(){
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[0].length;j++){
                if(i==0 && j==0)
                    tempArray[i][j] =arr[i][j];
                else if(j==0)
                    tempArray[i][j] =tempArray[i-1][j] + arr[i][j] ;
                else if(i==0)
                    tempArray[i][j] =tempArray[i][j-1] + arr[i][j] ;
                else
                    tempArray[i][j] =tempArray[i][j-1] + arr[i][j] + arr[i-1][j];
            }
    }

    public int getQuerySum(int i1,int j1 , int i2 , int j2){
        return tempArray[i2][j2] - tempArray[i1][j1];
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}};
        SubmatrixSumQueries sumQueries =new SubmatrixSumQueries(mat);
        System.out.println(sumQueries.getQuerySum(0,0,2,2));
    }

}
