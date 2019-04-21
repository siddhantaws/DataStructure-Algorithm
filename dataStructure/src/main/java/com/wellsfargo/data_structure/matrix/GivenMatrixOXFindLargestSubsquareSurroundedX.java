package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GivenMatrixOXFindLargestSubsquareSurroundedX {

    private char[][] matirx;
    private int arHori[][];
    private int arVert[][];

    public GivenMatrixOXFindLargestSubsquareSurroundedX(char[][] matirx) {
        this.matirx = matirx;
        this.arHori = new int[matirx.length][matirx.length];
        this.arVert = new int[matirx.length][matirx.length];
        polulateMatrix();
    }

    private void polulateMatrix() {
        for (int i = 0; i < matirx.length; i++)
            for (int j = 0; j < matirx.length; j++) {
                if (matirx[i][j] == 'O') {
                    arHori[i][j] = 0;
                    arVert[i][j] = 0;
                } else {
                    arHori[i][j] = j == 0 ? 1 : arHori[i][j - 1] + 1;
                    arVert[i][j] = i == 0 ? 1 : arVert[i-1][j]+1;
                }
            }
    }

    public int findSquareMatrix() {
        int max =0;
        for (int i = matirx.length - 1; i >= 0; i--)
            for (int j = matirx.length - 1; j >= 0; j--) {
                int min = Math.min(arHori[i][j], arVert[i][j]);

                while (min > max) {
                    if (arHori[i- min + 1][j] >= max &&
                            arVert[i][j-min+1] >= max) {
                        max = min;
                    }
                    min--;
                }
            }
        return max;
    }

    public static void main(String[] args) {
        char mat[][] = {{'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}};
        GivenMatrixOXFindLargestSubsquareSurroundedX surroundedX = new GivenMatrixOXFindLargestSubsquareSurroundedX(mat);
        System.out.println(surroundedX.findSquareMatrix());
    }
}
