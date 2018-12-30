package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class QueriesinMatrix {
    private int row;

    private int col;

    private int rowArr[];

    private int colArr[];

    public QueriesinMatrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.rowArr = new int[row];
        this.colArr = new int[col];
        preprocessMatrix();
    }

    private void preprocessMatrix() {
        // Fill rows with 1 to m-1
        for (int i = 0; i < row; i++)
            rowArr[i] = i;
        // Fill columns with 1 to n-1
        for (int i = 0; i < col; i++)
            colArr[i] = i;
    }

    void queryMatrix(char ch, int x, int y) {
        // perform queries
        int tmp;
        switch (ch) {
            case 'R':
                // swap row x with y
                swapRow(x - 1, y - 1);
                break;
            case 'C':
                // swap coloumn x with y
                swapCol(x - 1, y - 1);
                break;
            case 'P':
                // Print value at (x, y)
                System.out.printf("value at (%d, %d) = %d\n", x, y, rowArr[x - 1] * col + colArr[y - 1] + 1);
                break;
        }
        return;
    }

    private void swapRow(int source, int dest) {
        rowArr[source] = rowArr[source] ^ rowArr[dest];
        rowArr[dest] = rowArr[source] ^ rowArr[dest];
        rowArr[source] = rowArr[source] ^ rowArr[dest];
    }

    private void swapCol(int source, int dest) {
        colArr[source] = colArr[source] ^ colArr[dest];
        colArr[dest] = colArr[source] ^ colArr[dest];
        colArr[source] = colArr[source] ^ colArr[dest];
    }

    public static void main(String[] args) {
        QueriesinMatrix queriesinMatrix=new QueriesinMatrix(3,3);
        queriesinMatrix.queryMatrix('R',1,2);
        //queriesinMatrix.queryMatrix('C',1,2);
        queriesinMatrix.queryMatrix('P',1,3);
    }
}
