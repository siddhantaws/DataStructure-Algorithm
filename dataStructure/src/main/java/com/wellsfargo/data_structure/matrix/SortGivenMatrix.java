package com.wellsfargo.data_structure.matrix;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SortGivenMatrix {

    private int arr[][];
    private int N;
    private int temp [];


    public SortGivenMatrix(int[][] arr) {
        this.arr = arr;
        this.N=arr.length;
        this.temp =new int [N*N];
    }

    public void sort(){
        int  k=0;
        for(int i=0;i<arr.length;i++)
            for(int j=0;i<arr[0].length;j++)
                temp[k++] =arr[i][j];


        Arrays.sort(temp);
        for(int i=0;i<arr.length;i++)
            for(int j=0;i<arr[0].length;j++)
                arr[i][j] = temp[k++];
    }
}
