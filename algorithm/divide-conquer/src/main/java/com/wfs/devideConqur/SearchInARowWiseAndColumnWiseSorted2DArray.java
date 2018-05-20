package com.wfs.devideConqur;

public class SearchInARowWiseAndColumnWiseSorted2DArray {

    private int[][] matrix;

    public SearchInARowWiseAndColumnWiseSorted2DArray(int[][] matrix) {
        this.matrix = matrix;
    }

    public void search(int key){
          search(key, 0 ,matrix[0].length-1 , 0 ,matrix.length-1);
    }

    private void search(int key, int fromRow , int toRow , int fromCol , int toCol ) {

        // Find middle and compare with middle
        int i = fromRow + (toRow - fromRow) / 2;
        int j = fromCol + (toCol - fromCol) / 2;
        if (matrix[i][j] == key){
            System.out.println("Point Found");
            return ;
        }
        else {
            // right-up quarter of matrix is searched in all cases.
            // Provided it is different from current call
            if (i != toRow || j != fromCol)
                search(key, fromRow, i, j, toCol);

            // Special case for iteration with 1*2 matrix
            // mat[i][j] and mat[i][j+1] are only two elements.
            // So just check second element
            if (fromRow == toRow && fromCol + 1 == toCol)
                if (matrix[fromRow][toCol] == key){
                    System.out.println("Point Found");
                    return ;
                }


            // If middle key is lesser then search lower horizontal
            // matrix and right hand side matrix
            if (matrix[i][j] < key) {
                // search lower horizontal if such matrix exists
                if (i + 1 <= toRow)
                    search(key, i + 1, toRow, fromCol, toCol);
            }// If middle key is greater then search left vertical
            // matrix and right hand side matrix
            else {
                // search left vertical if such matrix exists
                if (j - 1 >= fromCol)
                    search(key, fromRow, toRow, fromCol, j - 1);
            }
        }
        return ;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] { {10, 20, 30, 40},
                                    {15, 25, 35, 45},
                                    {27, 29, 37, 48},
                                     {32, 33, 39, 50}};
        SearchInARowWiseAndColumnWiseSorted2DArray searchInARowWiseAndColumnWiseSorted2DArray=new SearchInARowWiseAndColumnWiseSorted2DArray(mat);
        searchInARowWiseAndColumnWiseSorted2DArray.search(20);
    }

}
