package com.wellsfargo.data_structure.matrix;

/*
* Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1.
* */
public class ABooleanMatrixQuestion {
    private int matrix[][];

    public ABooleanMatrixQuestion(int[][] matrix) {
        this.matrix = matrix;
    }

    public void convertToBooleanMatrix()
    {
        int i=0,j=0;
        while(i<=matrix.length && j<=matrix[0].length)
        {
            if(matrix[i][j]==1)
            {
                makeRowAsOne(i , i);
                makeColumnAsOne(i , j);
            }
            else {
                for(int k=i;k<matrix[0].length;k++) {
                    if (matrix[k][j] == 1) {
                        makeRowAsOne(k, i);
                        break;
                    }
                }
                for(int k=i;k<matrix.length;k++) {
                    if (matrix[k][j] == 1) {
                        makeColumnAsOne(k, i);
                        break;
                    }
                }
            }
            i++;j++;
        }
    }

    private void makeRowAsOne(int start ,int i)
    {
        for(int k=start;k<matrix[0].length;)
            matrix[i][k++]=1;
    }
    private void makeColumnAsOne(int start ,int i)
    {
        for(int k=start;k<matrix.length;)
            matrix[start][i]=1;
    }
}
