/*
package com.wellsfargo.algo.mathematics;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class InPlaceMatrixTranspose {
    private int row ;

    private int col;

    private int arr[];

    public InPlaceMatrixTranspose(int row, int col) {
        this.row = row;
        this.col = col;
        this.arr=new int[row*col];
        for(int i=0;i<arr.length;i++)
            arr[i]= i+1;
    }

    private void print2DArray(){
        for(int r=0;r<row;r++) {
            for(int c=0;c<col;c++)
                System.out.print("\t"+ arr[(r*col) + c]);
            System.out.println("");
        }
    }

    public void MatrixInplaceTranspose() {
        int size = row*col - 1;
        int t; // holds element to be replaced, eventually becomes next element to move
        int next; // location of 't' to be moved
        int cycleBegin; // holds start of cycle
        int i; // iterator
        byte b[] =new byte[128];
        b[0] = b[size] = 1;
        i = 1; // Note that A[0] and A[size-1] won't move
        while (i < size) {
            cycleBegin = i;
            t = arr[i];
            do {
                // Input matrix [r x c]  Output matrix  i_new = (i*r)%(N-1)
                next = (i*row)%size;
                swap(A[next], t);
                b[i] = 1;
                i = next;
            }
            while (i != cycleBegin);
            // Get Next Move (what about querying random location?)
            for (i = 1; i < (size && b[i]); i++)
                ;
            System.out.println();
        }
    }


        public static void main(String[] args) {
        InPlaceMatrixTranspose matrixTranspose =new InPlaceMatrixTranspose(3 ,4);
        matrixTranspose.print2DArray();
    }

}
*/
