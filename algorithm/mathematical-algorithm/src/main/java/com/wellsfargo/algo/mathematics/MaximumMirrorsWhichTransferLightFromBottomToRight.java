package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumMirrorsWhichTransferLightFromBottomToRight {
    private String[][] matrix;
    private int horizontal[], vertical[];
    private int N;

    public MaximumMirrorsWhichTransferLightFromBottomToRight(String[][] matrix) {
        this.matrix = matrix;
        this.horizontal = new int[matrix.length];
        this.vertical = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            horizontal[i]=-1;
            vertical[i]=-1;
        }
        this.N = matrix.length;
    }

    public int maximumMirrorInMatrix() {
        // looping matrix to mark column for obstacles
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j].equals("B"))
                    continue;
                // mark rightmost column with obstacle
                horizontal[i] = j;
                break;
            }
        }
        // looping matrix to mark rows for obstacles
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (matrix[i][j] .equals("B"))
                    continue;
                // mark leftmost row with obstacle
                vertical[j] = i;
                break;
            }
        }
        int res = 0; // Initialize result
        // if there is not obstacle on right or below, then mirror can be placed to transfer light
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                /* if i > vertical[j] then light can from bottom if j > horizontal[i] then light can go to right */
                if (i > vertical[j] && j > horizontal[i]) {
                /* uncomment this code to print actual mirror position also
                cout << i << " " << j << endl; */
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //  B - Blank     O - Obstacle
        String mat[][] = {{"B","B","O","B","B"},
                            {"B","B","B","B","O"} ,
                            {"B","B","B","B","B"},
                            {"B","O","O","B","O"},
                            {"B","B","B","O","B"} };
        MaximumMirrorsWhichTransferLightFromBottomToRight lightFromBottomToRight =new MaximumMirrorsWhichTransferLightFromBottomToRight(mat);
        System.out.println(lightFromBottomToRight.maximumMirrorInMatrix());
        }
}
