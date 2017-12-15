package com.wellsfargo.data_structure.matrix;


public class PrintAGivenMatrixInSpiralForm {

    private int[][] matrix;

    public PrintAGivenMatrixInSpiralForm(int[][] matrix) {
        this.matrix = matrix;
    }

    public void printInSprialOrder() {
        int i=matrix.length-1;
        int j= matrix[0].length-1;
        int i1=0,j1=0;
        while(i1<=j) {
            while(j1<=j) {
                System.out.print(matrix[i1][j1++]+",");
            }
            j1--;i1++;
            while(i1<=i) {
                System.out.print(matrix[i1++][j1]+",");
            }
            i1--;
            while(j-j1<j) {
                System.out.print(matrix[i1][--j1]+",");
            }
            while(i-i1<i-1)
            {
                System.out.print(matrix[--i1][j1]+",");
            }
            i--;j--;j1=i1;
        }
    }


    public static void main(String[] args) {
        /*PrintAGivenMatrixInSpiralForm searchInARowWiseColumnWiseSortedMatrix =new PrintAGivenMatrixInSpiralForm( new int[][]{
                {10, 25, 35, 45 , 55},
                {15, 29, 47, 50 , 65} ,
                {20, 31, 49, 60 , 75},
                {25, 43, 53, 63 , 85},
                {30, 57, 67, 77 , 95}});*/
        PrintAGivenMatrixInSpiralForm searchInARowWiseColumnWiseSortedMatrix =new PrintAGivenMatrixInSpiralForm( new int[][]{
                {1,2,3,4,5,6},
                {7,8,9,10,11,12} ,
                {13,14,15,16,17,18} });
        searchInARowWiseColumnWiseSortedMatrix.printInSprialOrder();
    }
}
