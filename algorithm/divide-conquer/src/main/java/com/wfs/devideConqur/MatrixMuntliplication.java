package com.wfs.devideConqur;

public class MatrixMuntliplication {
    private int arr1[][];
    private int arr2[][];
    private int res[][];
    private int n;


    public MatrixMuntliplication(int[][] arr1, int[][] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.n=arr1.length;
    }

    public void multiply(){
        multiply(arr1, arr2, 0,0,0,0,n);
    }

    public void multiply(int arr1[][],int arr2[][],int x1,int y1,int x2,int y2, int n){
        if(n==2){
            //BF multilication
        }else {
            substraction(arr2,arr2,x1,y1+n/2 ,x2+n/2,y2/n , n);
            //multiply(arr1,res, );
        }
    }

    private void adition(int arr1[][],int arr2[][],int x1,int y1,int x2,int y2, int n){

    }

    private void substraction(int arr1[][],int arr2[][],int x1,int y1,int x2,int y2, int n){

    }
}

