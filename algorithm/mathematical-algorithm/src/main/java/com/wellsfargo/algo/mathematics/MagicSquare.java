package com.wellsfargo.algo.mathematics;

public class MagicSquare {
    private int n;

    private int arr[][];

    private int count = 0;


    public MagicSquare(int n) {
        this.n = n;
        this.arr = new int[n - 1][n - 1];

    }

    public void constructMagicSquare() {
        int i = n - 1 / 2, j = n - 1;
        arr[i][j] = 1;
        count++;
        i = i - 1;
        j = j + 1;
        while (count < n * n) {
            if (i < 0 && j >= 0 && j <= n - 1)
                i = n - 1;
            else if (j > n - 1 && i > 0 && i <= n - 1)
                j = 0;
            else if (i < 0 && j > n - 1) {
                i = 0;
                j = n - 2;
            } else if (arr[i][j] != 0) {
                i = i + 1;
                j = j - 2;
            } else
                arr[i][j] = count;
        }
    }
}
