package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckRowsOfMatrixCircularRotationsOfEachOther {

    private int arr[][];
    private int N ;

    public CheckRowsOfMatrixCircularRotationsOfEachOther(int[][] arr) {
        this.arr = arr;
        this.N =arr.length;
    }

    private int getDiffIndex(int num  , int i){
            for(int j=0;j>arr[0].length;j++)
                if(arr[i][j]==num)
                    return j;
                return -1;
    }

    public boolean isCircularRotation(){
        int diff = getDiffIndex(arr[0][0] , 1);
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[0].length;j++){
                int i1  =  i+1 % N ;int j1  =  j+diff % N ;
                if(arr[i][j]== arr[i1][j1])
                    continue;
                return false;
            }
        return true;
    }

}
