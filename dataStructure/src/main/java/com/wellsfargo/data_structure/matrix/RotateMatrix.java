package com.wellsfargo.data_structure.matrix;

public class RotateMatrix {
    private int [][] matrix ;

    private int N ;

    private TransposeOfMatrix transposeOfMatrix;

    public void setTransposeOfMatrix(TransposeOfMatrix transposeOfMatrix) {
        this.transposeOfMatrix = transposeOfMatrix;
    }

    public RotateMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.N=matrix[0].length;
        this.transposeOfMatrix =new TransposeOfMatrix(matrix);
    }


    public void rotateUsingTranspose(){

        matrix = transposeOfMatrix.getTranspose();
        for(int i=0;i<matrix.length;i++){
            int x1 = 0;
            int x2= matrix[i].length-1;
            while(x2>x1){
                swap(x1,i,x2,i);
                x1++;x2--;
            }
        }
    }

    private void swap(int i, int j , int i1, int j1){
        matrix[i][j] =matrix[i][j] ^ matrix[i1][j1];
        matrix[i1][j1] = matrix[i][j] ^ matrix[i1][j1];
        matrix[i][j] = matrix[i1][j1]^ matrix[i][j];
    }

    public void rotate(){
        for (int x=0;x<N/2;x++)
            for(int y=x;y<N-x-1 ;y++){

                // store current cell in temp variable
                int temp = matrix[x][y];

                // move values from right to top
                matrix[x][y] = matrix[y][N-1-x];

                // move values from bottom to right
                matrix[y][N-1-x] = matrix[N-1-x][N-1-y];

                // move values from left to bottom
                matrix[N-1-x][N-1-y] = matrix[N-1-y][x];

                // assign temp to left
                matrix[N-1-y][x] = temp;
            }
        print();
    }

    private void print(){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
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
        int matrix[][]={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
             };
        RotateMatrix rotateMatrix=new RotateMatrix(matrix);
        rotateMatrix.rotate();
    }
}
