package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Inplace_M_NSizeMatrixTranspose {
    private int r;

    private int c;

    private int size ;

    private int arr[];

    public Inplace_M_NSizeMatrixTranspose(int r, int c) {
        this.r = r;
        this.c = c;
        this.size =r * c;
        this.arr =new int[size];
        for(int i=0;i<arr.length;i++)
            arr[i]=i+1;
    }



}
