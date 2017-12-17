package com.wellsfargo.data_structure.matrix;

public class CreateMatrixWithAlternatingRectanglesofOAndX {
    private int row;
    private int col ;
    private char[][] matrix;

    public CreateMatrixWithAlternatingRectanglesofOAndX(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix=new char[row][col];
    }

    public char[][] getMatrix() {
        int start =0;
        int R =row-1 ,C =col-1;
        boolean isX= true;
        int count=0;
        while(start+count+R <row && start+count+C<col){
            for(int i=start;i+R+count<row;i++)
                matrix[start][i]=isX ? 'X':'0';
            for(int i=start+R;i+C+count<col;i++)
                matrix[start+R][i]=isX ? 'X':'0';
            for(int i=start+R;i-R-count<start;i--)
                matrix[start+R][i]=isX ? 'X':'0';
            for(int i=start+C;i-R-count<start;i--)
                matrix[start+C][i]=isX ? 'X':'0';
            isX=!isX;
            R=R-2;C=C-2;
            start=start+1;
            count++;
        }
        return matrix;
    }
}
