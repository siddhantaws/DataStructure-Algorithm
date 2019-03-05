package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LowerUpperTriangularMatrix {
    private int arr[][];

    public LowerUpperTriangularMatrix(int[][] arr) {
        this.arr = arr;
    }

    public void printLowerTringular(){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++)
                if(i>=j){
                    System.out.print(arr[i][j]+"");
                }
        }
        System.out.println("");
    }
}
