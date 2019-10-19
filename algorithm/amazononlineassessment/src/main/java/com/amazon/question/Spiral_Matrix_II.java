package com.amazon.question;

public class Spiral_Matrix_II {
    private int N;
    private int [][]arr;

    public Spiral_Matrix_II(int n) {
        N = n;
        this.arr =new int[N][N];
    }

    public int[][] generateMatrix() {
       int x =0; int y=0;
       int x1=N-1;int y1=N-1;
       int num1=1;
       while(x<=x1 && y<=y1){
           int i;
            for(i=y;i<=y1;i++)
                arr[x][i]=num1++;
            x++;
           for(i=x;i<=x1;i++)
               arr[i][y1]=num1++;
           y1--;
           if(x<x1){
               for(i=y1;i>=y;i--)
                   arr[x1][i]=num1++;
               x1--;
           }
           if(y<y1){
               for(i=x1;i>=x;i--)
                   arr[i][y]=num1++;
               y++;
           }
       }
        print();
        return arr;
    }

    private void print(){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println( );
        }
    }

    public static void main(String[] args) {
        Spiral_Matrix_II matrixIi =new Spiral_Matrix_II(5);
        matrixIi.generateMatrix();
    }
}
