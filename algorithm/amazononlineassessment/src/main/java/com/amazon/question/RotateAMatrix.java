package com.amazon.question;

public class RotateAMatrix {

    private int N;

    private int arr[][];

    public RotateAMatrix(int n) {
        N = n;
        this.arr = new int[N][N];
        init();
    }

    private void init(){
        int count=1;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                arr[i][j]=count++;
    }

    private void print(){
        for(int i=0;i<arr.length;i++){
            System.out.println();
            for(int j=0;j<arr[i].length;j++)
                System.out.print( arr[i][j]+"\t");
        }
    }

    public void rotateCLockWise(){
        System.out.println("Before Rotate");
        print();
        for(int i=0;i<N;i++)
            for(int j=N-i-1;j>=i;j--){
                int temp      =  arr[i][N-j-1];
                arr[i][N-j-1] = arr[N-j-1][i];
                arr[N-j-1][i] = arr[N-i-1][N-j-1];
                arr[N-i-1][N-j-1] = arr[j][N-i-1];
                arr[j][N-i-1] = temp;
            }
        System.out.println("After Rotate");
        print();
    }

    public void rotateAntiCLockWise(){
        System.out.println("Before Rotate");
        print();
        for(int i=0;i<N;i++)
            for(int j=i;j<N-i-1;j++){
                int temp  = arr[i][j];
                arr[i][j] = arr[j][N-i-1];
                arr[j][N-i-1] = arr[N-i-1][N-j-1];
                arr[N-i-1][N-j-1] = arr[N-j-1][i];
                arr[N-j-1][i] =temp;
            }
        System.out.println("After Rotate");
        print();
    }


    public static void main(String[] args) {
        RotateAMatrix matrix =new RotateAMatrix(5);
        matrix.rotateCLockWise();
    }
}
