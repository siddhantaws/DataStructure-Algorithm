package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumOperationsRequiredSetAllElementsBinaryMatrix {
    private boolean arr[][];

    private int N;

    private int M ;
    public MinimumOperationsRequiredSetAllElementsBinaryMatrix(boolean[][] arr) {
        this.arr = arr;
        this.N =arr.length;
        this.M =arr[0].length;
    }

    public int minOperation() {
        int ans = 0;
               for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                // check if this cell equals 0
                if (arr[i][j] == false) {
                    // increase the number of moves
                    ans++;
                    // flip from this cell to the start point
                    for (int k = 0; k <= i; k++) {
                        for (int h = 0; h <= j; h++) {
                            // flip the cell
                            if (arr[k][h] == true) {
                                arr[k][h] = false;
                            } else {
                                arr[k][h] = true;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean mat[][]
                = {
                {false , false, true, true, true},
                {false , false, false, true, true},
                {false , false, false, true, true},
                {true ,  true,  true, true, true},
                {true ,  true,  true, true, true}
        };
        MinimumOperationsRequiredSetAllElementsBinaryMatrix binaryMatrix =new MinimumOperationsRequiredSetAllElementsBinaryMatrix(mat);
        System.out.println(binaryMatrix.minOperation());
    }
}
