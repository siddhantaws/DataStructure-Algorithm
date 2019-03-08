package com.wellsfargo.data_structure.array;

import com.wellsfargo.data_structure.matrix.MatrixUtil;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MagicSquareEvenOrder {
    private int arr[][];

    private int N;

    public MagicSquareEvenOrder(int n) {
        this.N= n;
        this.arr = new int[N][N];
    }

    public void constructMagicSquare(){
        int i, j;
        // filling matrix with its count value
        // starting from 1;
        for ( i = 0; i < N; i++)
            for ( j = 0; j < N; j++)
                arr[i][j] = (N*i) + j + 1;

        MatrixUtil.print(arr);

        // change value of Array elements at fix location as per rule
        // (n*n+1)-arr[i][j] Top Left corner of Matrix (order (n/4)*(n/4))
        for ( i = 0; i < N/4; i++)
            for ( j = 0; j < N/4; j++)
                arr[i][j] = (N*N + 1) - arr[i][j];
        MatrixUtil.print(arr);
        // Top Right corner of Matrix (order (n/4)*(n/4))
        for ( i = 0; i < N/4; i++)
            for ( j = 3 * (N/4); j < N; j++)
                arr[i][j] = (N*N + 1) - arr[i][j];
        MatrixUtil.print(arr);
        // Bottom Left corner of Matrix (order (n/4)*(n/4))
        for ( i = 3 * N/4; i < N; i++)
            for ( j = 0; j < N/4; j++)
                arr[i][j] = (N*N+1) - arr[i][j];
        MatrixUtil.print(arr);
        // Bottom Right corner of Matrix (order (n/4)*(n/4))
        for ( i = 3 * N/4; i < N; i++)
            for ( j = 3 * N/4; j < N; j++)
                arr[i][j] = (N*N + 1) - arr[i][j];
        MatrixUtil.print(arr);
        // Centre of Matrix (order (n/2)*(n/2))
        for ( i = N/4; i < 3 * N/4; i++)
            for ( j = N/4; j < 3 * N/4; j++)
                arr[i][j] = (N*N + 1) - arr[i][j];
        MatrixUtil.print(arr);
    }

    public static void main(String[] args) {
        MagicSquareEvenOrder squareEvenOrder =new MagicSquareEvenOrder(8);
        squareEvenOrder.constructMagicSquare();
    }
}
