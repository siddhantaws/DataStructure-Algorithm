package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RotateMatrixAntiClockwise {
    private int arr[][];
    private int N;

    public RotateMatrixAntiClockwise(int[][] arr) {
        this.arr = arr;
        this.N=arr.length;
    }

    public void rotate(){
        for(int i=0;i<N/2;i++)
            for(int j=i;j<N-i-1;j++){
                int temp = arr[i][j];

                arr[i][j] = arr[j][N-i-1];
                arr[j][N-i-1] = arr[N-i-1][N-j-1];
                arr[N-i-1][N-j-1] =  arr[N-j-1][i];
                arr[N-j-1][i] =temp;
            }
        MatrixUtil.print(arr);
    }


    public static void main(String[] args) {
        int arr[][]={{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}} ;
        RotateMatrixAntiClockwise  antiClockwise =new RotateMatrixAntiClockwise(arr);
        antiClockwise.rotate();
    }
}
