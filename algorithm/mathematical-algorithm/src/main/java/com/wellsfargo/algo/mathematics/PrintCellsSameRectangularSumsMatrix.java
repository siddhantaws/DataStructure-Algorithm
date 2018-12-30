package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintCellsSameRectangularSumsMatrix {
    private int[][] matrix;
    private int m, n;

    public PrintCellsSameRectangularSumsMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
    }

    public void printCellWithSameRectangularArea() {
        /* sum[i][j] denotes sum of sub-matrix, mat[0][0] to mat[i][j]  sumr[i][j] denotes sum of sub-matrix, mat[i][j]  to mat[m - 1][n - 1] */
        int sum[][] = new int[m][n];
        int sumr[][] = new int[m][n];

        // Initialize both sum matrices by mat
        int totalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumr[i][j] = sum[i][j] = matrix[i][j];
                totalSum += matrix[i][j];
            }
        }

        // updating first and last row separately
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i][0]  + sum[i - 1][0];
            sumr[m - i - 1][n - 1] = sumr[m - i - 1][n - 1] + sumr[m - i][n - 1];
        }

        // updating first and last column separately
        for (int j = 1; j < n; j++) {
            sum[0][j] += sum[0][j - 1];
            sumr[m - 1][n - j - 1] += sumr[m - 1][n - j];
        }

        // updating sum and sumr indices by nearby indices
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                sumr[m - i - 1][n - j - 1] =  sumr[m - i - 1][n - j - 1]  +sumr[m - i][n - j - 1] + sumr[m - i - 1][n - j] - sumr[m - i][n - j];
            }
        }
        /* print all those indices at which sum of prime diagonal  rectangles is half of the total sum of matrix */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int mainDiagRectangleSum = sum[i][j] +
                        sumr[i][j] - matrix[i][j];
                if (totalSum == 2 * mainDiagRectangleSum)
                    System.out.println("(" + i + ", " + j + ")");
            }
        }

    }

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3, 5},
                        {4, 1, 0, 2},
                        {0, 1, 2, 0},
                         {7, 1, 1, 0}};
        PrintCellsSameRectangularSumsMatrix sameRectangularSumsMatrix= new PrintCellsSameRectangularSumsMatrix(mat);
        sameRectangularSumsMatrix.printCellWithSameRectangularArea();
    }
}
