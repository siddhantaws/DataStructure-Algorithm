package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintKElementInSpiralFormMatrix {
    private int arr[][];

    private int N ;

    private int M ;

    private int K;

    public PrintKElementInSpiralFormMatrix(int[][] arr, int k) {
        this.arr = arr;
        this.N=arr.length;
        this.M=arr[0].length;
        this.K =k;
    }

    public int getK(){
        return getK(N,M , K);
    }

    private int getK(int n, int m, int k ){
        if(n<1 || m<1 )
            return -1;
        //Element in First row
        if(k<n)
            return arr[0][k-1];

        //Element in last  Column
        if(k<n+m-1)
            return arr[k-m][m-1];
        if(k<n+m+m-1-1)
            return arr[n-1][m-1-(k-(m+n-1))];
        if(k< n+m+m+n+-4)
            return arr[n-1-(k-(m+n-1+m-1))][0];
        /*..........If element is NOT in outermost ring .......*/
        /* Recursion for sub-matrix. &A[1][1] is
        address to next inside sub matrix.*/
        return getK(  n-2, m-2, k-(2*n+2*m-4));
    }
}
