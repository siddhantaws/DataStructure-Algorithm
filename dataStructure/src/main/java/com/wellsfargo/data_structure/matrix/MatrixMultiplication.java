package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MatrixMultiplication {
    private int arr1[][];

    private int arr2[][];

    private int arr3[][];

    public MatrixMultiplication(int[][] arr1, int[][] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        assert this.arr1[0].length == this.arr2.length;
        this.arr3 =new int[arr1.length][arr2[0].length];
    }

    public void multiplyIterative(){
        for(int i=0;i<arr3.length;i++)
            for(int j=0;j<arr3[i].length;j++)
                arr3[i][j] = mul(i,j);
    }

    private int mul(int row , int col){
        int mul=1;
        int firstRow = row;
        int firstCol =col ;
        while(firstCol<arr1[row].length){
            mul = mul + (arr1[row][firstRow++] * arr1[firstCol][col]);
        }
        return mul;
    }
}
