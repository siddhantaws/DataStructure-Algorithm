package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MagicSquare {
    private int N;
    private int[][]matrix ;

    public MagicSquare(int n) {
        N = n;
        this.matrix =new int[N][N];
    }

    public void fillMatrix(){
        int count =1;
        int i=N/2;int j=N/2;
        while(count<=N*N){
            if(matrix[i][j]!=0) {
                matrix[i][j]=count++;
                i= i-1== -1 ? N-1 : i-1 ; j= j+1 ==N ? 0: j+1;
            }else{
                   i=i+1 == N ? 0 : i+1;
                   j=j-2<0 ? N+j-2 : j-2 ;
            }
        }
    }
}
