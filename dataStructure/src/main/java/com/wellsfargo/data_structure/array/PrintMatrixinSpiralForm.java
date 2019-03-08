package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintMatrixinSpiralForm {

    private int arr[][];

    private int row ;

    private int col ;

    public PrintMatrixinSpiralForm(int[][] arr) {
        this.arr = arr;
        this.row=arr.length;
        this.col=arr[0].length;
    }

    public void printInSpiral(){
        int row1 =0, col1=0;

        while(row1<row && col1<col){

            for(int i=col1;i<col;i++)
                System.out.print(arr[row1][i]+" ");
            row1++;
            for(int i=row1;i<row;i++)
                System.out.print(arr[i][col-1]+" ");
            col--;
            if(row1<row){
                for(int i=col-1;i>=col1;i--)
                    System.out.print(arr[row-1][i]+" ");
                row--;
            }
            if(col1<col){
                for(int i=row-1;i>=row1;i--)
                    System.out.print(arr[i][col1]+"");
                col1++;
            }
        }
    }

    public static void main(String[] args) {
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        PrintMatrixinSpiralForm spiralForm =new PrintMatrixinSpiralForm(a);
        spiralForm.printInSpiral();
    }
}
