package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MatrixUtil {

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void print(char arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void swap( int arr[][] ,int i1,int j1, int i2, int j2){
        int temp = arr[i1][j1];
        arr[i1][j1] =arr[i2][j2];
        arr[i2][j2] = temp;
    }

    public static void swap( char arr[][] ,int i1,int j1, int i2, int j2){
        char temp = arr[i1][j1];
        arr[i1][j1] =arr[i2][j2];
        arr[i2][j2] = temp;
    }
}
