package com.google.question;

import java.util.*;

public class MinimumNumberFlipsConvertBinaryMatrixZeroMatrix {
    private int mat[][];

    public MinimumNumberFlipsConvertBinaryMatrixZeroMatrix(int[][] arr) {
        this.mat = arr;
    }

    public int minFlips() {
        int arr[][]={{0,1},{0,-1},{0,0},{1,0},{-1,0}};
        int N= mat.length*mat[0].length;
        int num=0;
        for(int i=0;i<mat.length;i++)
            for(int j=0;j<mat[0].length;j++)
                num = (num <<1 ) | mat[i][j] ;
        if (num==0)
            return 0;
        Set<Integer> setOfNumbers =new HashSet();
        Queue<Integer> integers =new LinkedList();

        setOfNumbers.add(num);integers.add(num);
        int steps=0;
        while(!integers.isEmpty()){
            int n= integers.size();
            while(n-->0){
                int number =integers.poll();
                if (number==0)
                    break;
                for(int i=0;i<mat.length;i++)
                    for(int j=0;j<mat[0].length;j++){
                        num = number;
                        for(int x[] :arr){
                            int row = i+x[0];int col = j+x[1];
                            if (row<0 || col<0 || row>=mat.length || col>=mat[0].length)
                                continue;
                            int pos = N - (  row*mat[0].length+ col)-1;
                            if((num & 1<<pos)>=1)
                                num = num ^ (1<<pos);
                            else
                                num = num | (1<<pos);
                        }
                        if (!setOfNumbers.contains(num)){
                            setOfNumbers.add(num);
                            integers.add(num);
                        }

                    }
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int  mat[][] = {{0,0},{0,1}};
        MinimumNumberFlipsConvertBinaryMatrixZeroMatrix matrixZeroMatrix =new MinimumNumberFlipsConvertBinaryMatrixZeroMatrix(mat);
        System.out.println(matrixZeroMatrix.minFlips());
    }
}
