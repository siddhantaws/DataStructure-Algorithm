package com.wellsfargo.data_structure.matrix;

public class SearchInARowWiseColumnWiseSortedMatrix {
    private int[][] matrix;

    private int value ;

    public SearchInARowWiseColumnWiseSortedMatrix(int[][] matrix, int value) {
        this.matrix = matrix;
        this.value = value ;
    }


    /**
     *
     * Get position from O(n)
     */
    public String getPosition(){
        int i =0;
        int j=matrix[0].length-1;
        while( !(i<0 || j<0) || !(i>matrix.length)){
            if(matrix[i][j] ==value)
                return i+","+j ;
            else if(matrix[i][j] >value)
                j--;
            else
                i++;
        }
        return -1+","+-1;
    }





    public static void main(String[] args) {
        SearchInARowWiseColumnWiseSortedMatrix searchInARowWiseColumnWiseSortedMatrix =new SearchInARowWiseColumnWiseSortedMatrix( new int[][]{
                {10, 25, 35, 45 , 55},
                {15, 29, 47, 50 , 65} ,
                {20, 31, 49, 60 , 75},
                {25, 43, 53, 63 , 85},
                {30, 57, 67, 77 , 95}} , 32);

        searchInARowWiseColumnWiseSortedMatrix.getPosition();
    }
}
