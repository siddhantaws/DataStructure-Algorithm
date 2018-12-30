package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TransposeOfMatrix {

    private int arr[][];

    public TransposeOfMatrix(int[][] arr) {
        this.arr = arr;
    }

    public int[][] getTranspose(){
        for(int i=0;i<arr.length;i++)
            for(int j=i;i<arr[i].length;j++)
                swap(i,j,j,i);
        return arr;
    }

    private void swap(int i, int j , int i1, int j1){
        arr[i][j] =arr[i][j] ^ arr[i1][j1];
        arr[i1][j1] = arr[i][j] ^ arr[i1][j1];
        arr[i][j] = arr[i1][j1]^ arr[i][j];
    }

}
