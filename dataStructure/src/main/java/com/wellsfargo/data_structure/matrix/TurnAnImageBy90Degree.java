package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TurnAnImageBy90Degree {
    private char ch [][];
    private int N ;
    private int M ;
    private char temp [][];

    public TurnAnImageBy90Degree(char[][] ch) {
        this.ch = ch;
        this.N = ch.length;
        this.M = ch[0].length;
        this.temp = new char[N][M];
    }

    public void rotate(){
        for(int i=0;i<ch.length;i++)
            for(int j=0;j<ch[0].length;j++)
                temp[j][i]=ch[i][j] ;
        MatrixUtil.print(temp);
    }

    public static void main(String[] args) {

    }
}
