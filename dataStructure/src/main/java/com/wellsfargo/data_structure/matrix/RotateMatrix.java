package com.wellsfargo.data_structure.matrix;

public class RotateMatrix {
    private int [][] matrix ;
    private int N ;
    public RotateMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.N=matrix[0].length;
    }
    public void rotate(){
        for (int x=0;x<N/2;x++)
            for(int y=x;y<N-x-1 ;y++){
                int temp = matrix[x][y];
                matrix[x][y] = matrix[x][N-x-1];
                matrix[x][N-x-1] = matrix[N-x-1][N-y-1];
                matrix[N-x-1][N-y-1] =matrix[N-x-1][y];
                matrix[N-x-1][y] = temp;
            }
    }

    public void printMatrixInSpiralFor(){
        int x=0 , y=x , X=0,Y =X;
        while(x<N/2 && y<N-1-x){
            for(;y<N-1-x;y++)
            {
                System.out.print(matrix[x][y]);
            }
            y--;
            x++;
            for(;x<N/2;x++){
                System.out.print(matrix[x][y]);
            }
            x--;
            y--;
            for(;y>Y;y--){
                System.out.print(matrix[x][y]);
            }
            y++;
            for(;x>X;x--){
                System.out.print(matrix[x][y]);
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][]={{1,2,3},
                {4,5,6},
                {7,8,9},
             };
        RotateMatrix rotateMatrix=new RotateMatrix(matrix);
        rotateMatrix.printMatrixInSpiralFor();
    }
}
