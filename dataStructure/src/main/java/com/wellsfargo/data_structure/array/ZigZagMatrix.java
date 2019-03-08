package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ZigZagMatrix {

    private int arr[][];

    private int N;

    private int M;

    public ZigZagMatrix(int[][] arr) {
        this.arr = arr;
        this.N =arr.length;
        this.M =arr[0].length;
    }

    public void zigzag(){

        int l=0,r=0;
        System.out.print(arr[l][r]);
        while(l< N && r < M){
            if(r == M-1)
                l++;
            else
                r++;
            System.out.print(arr[l][r]);
            while(r >= 0){
                System.out.print(arr[l--][r--]);
            }
            if(l==N-1)
                r++;
            else
                l++;
            System.out.println(arr[l][r]);
            while(l <= N-1){
                System.out.print(arr[l++][r++]);
            }
            System.out.print(arr[l][r]);
        }
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 } };
        ZigZagMatrix matrix =new ZigZagMatrix(mat);

    }
}
