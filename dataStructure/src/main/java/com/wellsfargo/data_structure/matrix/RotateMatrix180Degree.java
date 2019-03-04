package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RotateMatrix180Degree {
    private int arr[][];
    private int N;

    public RotateMatrix180Degree(int[][] arr) {
        this.arr = arr;
        this.N=arr.length;
    }

    public void rotate(){
        for(int i=0 ,j=0;i<N/2 && j<arr[0].length ;i++,j++)
            MatrixUtil.swap(arr ,i,j,N -i,N-j);
    }
}
