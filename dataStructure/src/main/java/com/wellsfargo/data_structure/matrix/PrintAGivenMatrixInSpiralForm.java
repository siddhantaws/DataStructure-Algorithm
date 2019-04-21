package com.wellsfargo.data_structure.matrix;


public class PrintAGivenMatrixInSpiralForm {

    private int[][] matrix;

    public PrintAGivenMatrixInSpiralForm(int[][] matrix) {
        this.matrix = matrix;
    }


    public void printMatrixInSpiralWayUsingRecursion(){
        printMatrixInSpiralWayUsingRecursion(0,0,matrix[0].length-1,matrix.length-1);
    }

    private void printMatrixInSpiralWayUsingRecursion(int rowStart, int colStart, int colLength,  int rowLength){
        for (int i = rowStart; i <= colLength; i++) {
            System.out.print(matrix[rowStart][i] + " ");
        }
        for (int i = rowStart+1; i <= rowLength; i++) {
            System.out.print(matrix[i][colLength] + " ");
        }
        if(rowStart+1 <= rowLength){
            for (int i = colLength-1; i >= colStart; i--) {
                System.out.print(matrix[rowLength][i] + " ");
            }
        }
        if(colStart+1 <= colLength){
            for (int i = rowLength-1; i > rowStart; i--) {
                System.out.print(matrix[i][colStart] + " ");
            }
        }
        if(rowStart+1 <= rowLength-1 && colStart+1 <= colLength-1){
            printMatrixInSpiralWayUsingRecursion(rowStart+1, colStart+1, colLength-1, rowLength-1);
        }
    }
    public void printInSprialOrder() {
        int i, rowStart = 0, colStart = 0;

        int rowEnd =matrix.length ; int colEnd= matrix[0].length;
        while (rowStart < rowEnd && colStart < colEnd) {
            // Print the first row from the remaining rows
            for (i = colStart; i < colEnd; ++i) {
                System.out.print(matrix[rowStart][i]+" ");
            }
            rowStart++;
            // Print the last column from the remaining columns
            for (i = rowStart; i < rowEnd; ++i) {
                System.out.print(matrix[i][colEnd-1]+" ");
            }
            colEnd--;
            // Print the last row from the remaining rows */
            if ( rowStart < rowEnd) {
                for (i = colEnd-1; i >= colStart; --i) {
                    System.out.print(matrix[rowEnd-1][i]+" ");
                }
                rowEnd--;
            }
            // Print the first column from the remaining columns */
            if (colStart < colEnd) {
                for (i = rowEnd-1; i >= rowStart; --i) {
                    System.out.print(matrix[i][colStart]+" ");
                }
                colStart++;
            }
        }
    }


    public static void main(String[] args) {
       PrintAGivenMatrixInSpiralForm searchInARowWiseColumnWiseSortedMatrix =new PrintAGivenMatrixInSpiralForm( new int[][]{
                {1,2,3,4,5,6},
                {7,8,9,10,11,12} ,
                {13,14,15,16,17,18} });
        searchInARowWiseColumnWiseSortedMatrix.printInSprialOrder();
    }
}
