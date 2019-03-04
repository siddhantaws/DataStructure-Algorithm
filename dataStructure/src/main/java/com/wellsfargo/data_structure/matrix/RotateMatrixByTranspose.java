package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RotateMatrixByTranspose {
    private int arr[][];
    private int N;

    public RotateMatrixByTranspose(int[][] arr) {
        this.arr = arr;
        this.N=arr.length;
    }

    public void rotate(){
        doTranpose();
        reverseColumn();
        MatrixUtil.print(arr);
    }

    private void reverseColumn (){
        for(int i=0;i<arr.length;i++){
            int r =N;
            int l = 0;
            while(l>r){
                MatrixUtil.swap(arr ,l++ ,i , r--, i );
            }
        }
    }

    private void doTranpose(){
       for(int i=0;i<arr.length;i++)
           for(int j=i;i<arr.length;j++)
               MatrixUtil.swap(arr ,i,j,j,i);
    }



}
