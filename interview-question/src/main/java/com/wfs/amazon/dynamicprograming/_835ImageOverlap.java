package com.wfs.amazon.dynamicprograming;

public class _835ImageOverlap {
    private int[][] A;

    private int[][] B;

    public _835ImageOverlap(int[][] a, int[][] b) {
        A = a;
        B = b;
    }

    public int largestOverlap() {
        int N = A.length;
        int maxOverlap = 0;
        for (int i = -N + 1; i < N; i++) {
            for (int j = -N + 1; j < N; j++) {
                int count = 0;
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        int dx = x + i;
                        int dy = y + j;
                        if (dx < N && dx >= 0 && dy < N && dy >= 0 && B[dx][dy] + A[x][y] == 2)
                            count++;
                    }
                }
                System.out.print(count+"  ");
                maxOverlap = Math.max(maxOverlap, count);
            }
            System.out.println();
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
       int A[][] = {{1,1,0},{0,1,0},{0,1,0}};int B[][] = {{0,0,0},{0,1,1},{0,0,0}};
        _835ImageOverlap overlap =new _835ImageOverlap(A,B);
        //System.out.println(overlap.largestOverlap());
        System.out.println(225%10);
    }

}
