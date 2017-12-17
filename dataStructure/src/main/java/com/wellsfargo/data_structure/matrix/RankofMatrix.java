package com.wellsfargo.data_structure.matrix;

public class RankofMatrix {
    private int [][] marix;
    private int R;
    private int C;

    public RankofMatrix(int[][] marix) {
        this.marix = marix;
        this.R=marix.length;
        this.C=marix[0].length;
    }

    public int getRank(){
        int rank = C;
        for (int row = 0; row < rank; row++)
        {
            // Before we visit current row 'row', we make
            // sure that mat[row][0],....mat[row][row-1]
            // are 0.

            // Diagonal element is not zero
            if (marix[row][row]!=0)
            {
                for (int col = 0; col < R; col++)
                {
                    if (col != row)
                    {
                        // This makes all entries of current
                        // column as 0 except entry 'mat[row][row]'
                        double mult = (double)marix[col][row] /
                                marix[row][row];
                        for (int i = 0; i < rank; i++)
                            marix[col][i] -= mult * marix[row][i];
                    }
                }
            }

            // Diagonal element is already zero. Two cases
            // arise:
            // 1) If there is a row below it with non-zero
            //    entry, then swap this row with that row
            //    and process that row
            // 2) If all elements in current column below
            //    mat[r][row] are 0, then remvoe this column
            //    by swapping it with last column and
            //    reducing number of columns by 1.
            else
            {
                boolean reduce = true;

            /* Find the non-zero element in current
                column  */
                for (int i = row + 1; i < R;  i++)
                {
                    // Swap the row with non-zero element
                    // with this row.
                    if (marix[i][row]!=0)
                    {
                        swap(marix, row, i, rank);
                        reduce = false;
                        break ;
                    }
                }

                // If we did not find any row with non-zero
                // element in current columnm, then all
                // values in this column are 0.
                if (reduce)
                {
                    // Reduce number of columns
                    rank--;

                    // Copy the last column here
                    for (int i = 0; i < R; i ++)
                        marix[i][row] = marix[i][rank];
                }

                // Process this row again
                row--;
            }

            // Uncomment these lines to see intermediate results
            // display(mat, R, C);
            // printf("\n");
        }
        return rank;
    }

    private void swap(int marix[][], int row1, int row2,int col)
    {
        for (int i = 0; i < col; i++)
        {
            int temp = marix[row1][i];
            marix[row1][i] = marix[row2][i];
            marix[row2][i] = temp;
        }
    }

    public static void main(String[] args) {
        RankofMatrix rankofMatrix =new RankofMatrix(new int[][]{
                {10,   20,   10},
                {20,   40,   20},
                {30,   50,   0}}
        );
        System.out.println(rankofMatrix.getRank());
    }
}
