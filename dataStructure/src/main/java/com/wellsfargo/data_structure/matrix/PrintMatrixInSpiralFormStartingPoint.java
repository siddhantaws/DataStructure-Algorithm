package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintMatrixInSpiralFormStartingPoint {
    private int [][] matrix;

    private int a ;

    private int b;

    public PrintMatrixInSpiralFormStartingPoint(int[][] matrix, int x, int y) {
        this.matrix = matrix;
        this.a = x;
        this.b = y;
    }

    public void printSpiral(){
        printSpiral(matrix.length,matrix[0].length);
    }
    public void printSpiral(int r,int c){
        int i;
        int low_row = (0 > a) ? 0 : a;
        int low_column = (0 > b) ? 0 : b - 1;
        int high_row = ((a + 1) >= r) ? r - 1 : a + 1;
        int high_column = ((b + 1) >= c) ? c - 1 : b + 1;
        while ((low_row > 0 - r && low_column > 0 - c))
        {
            for (i = low_column + 1; i <= high_column && i < c && low_row >= 0; ++i)
                System.out.print (matrix[low_row][i] + " ");
            low_row -= 1;

            for (i = low_row + 2; i <= high_row && i < r &&  high_column < c; ++i)
                System.out.print(matrix[i][high_column] + " ");
            high_column += 1;

            for (i = high_column - 2; i >= low_column && i >= 0 && high_row < r; --i)
                System.out.print(matrix[high_row][i] + " ");
            high_row += 1;

            for (i = high_row - 2; i > low_row && i >= 0 && low_column >= 0; --i)
                System.out.print(matrix [i][low_column] +" ");
            low_column -= 1;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [][]mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        PrintMatrixInSpiralFormStartingPoint inSpiralFormStartingPoint =new PrintMatrixInSpiralFormStartingPoint(mat,0,2);
        inSpiralFormStartingPoint.printSpiral();
    }
}
