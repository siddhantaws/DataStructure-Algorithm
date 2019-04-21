package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintKThElementSpiralFormMatrix {

    private int N ;
    private int M ;
    private int arr[][];

    public PrintKThElementSpiralFormMatrix(int n, int m) {
        N = n;
        M = m;
        this.arr=new int[N][M];
        int count =1;
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                arr[i][j]= count++;
    }
    public int element(int k){
        return element(0,0,N-1,M-1,k);
    }
    public int element(int fr,int fc,int lr,int lc,int k)
    {
        int m=lr-fr+1,n=lc-fc+1;
        if(k<=n) return arr[fr][fc+k-1];
        if(k<=n+m-1) {return arr[fr+k-n][lc];}
        if(k<=n+m-1+n-1) {return arr[lr][lc-(k-n-m+1)];}
        if(k<=n+m-1+n-1+m-2){ return arr[fc][lr-(k-(n-m-1-n-1))];}
        return element(fr+1,fc+1,lr-1,lc-1,k-(n+m-1+n-1+m-2));
    }


    public static void main(String[] args) {
        PrintKThElementSpiralFormMatrix elementSpiralFormMatrix =new PrintKThElementSpiralFormMatrix(4,4);
        System.out.println(elementSpiralFormMatrix.element(13));
    }

}
