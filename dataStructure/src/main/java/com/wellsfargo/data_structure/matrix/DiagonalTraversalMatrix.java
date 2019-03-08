package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class DiagonalTraversalMatrix {

    private int arr[][];
    private int N;
    private int M;

    public DiagonalTraversalMatrix(int[][] arr) {
        this.arr = arr;
        this.N= arr.length;
        this.M=arr[0].length;
    }

    public void print(){
        int l=0,r=0,l1=0,r1=0;

        while(l<N && r<M){
            l1=l ;r1=r;
            while(l1>=0 && r1>=0 && l1<N && r1 <M ){
                System.out.print(arr[l1][r1]);
                l1--;r1++;
            }
            if(l<N)
                l++;
            else
                r++;
        }
    }

}
