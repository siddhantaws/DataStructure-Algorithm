package com.wellsfargo.algo.mathematics;

public class Pascal_Triangle {
    private int n;

    private int arr[][];

    public Pascal_Triangle(int n) {
        this.n=n;
        this.arr=new int[n][n];
    }

    public void printPascal()
    {
        // Iterate through every line and print entries in it
        for (int line = 0; line < n; line++)
        {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++)
                System.out.print(binomialCoeff(line, i)+"");
            System.out.println("\n");
        }
    }

    public void pascal(){
        // Iterate through every line and print integer(s) in it
        for (int line = 0; line < n; line++) {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++) {
                // First and last values in every row are 1
                if (line == i || i == 0)
                    arr[line][i] = 1;
                else // Other values are sum of values just above and left of above
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
                System.out.print(arr[line][i]);
            }
            System.out.println("");
        }
    }

    public static void printPascal(int n) {
        for(int line = 1; line <= n; line++)
        {
            int C=1;// used to represent C(line, i)
            for(int i = 1; i <= line; i++)
            {
                // The first value in a line is always 1
                System.out.print(C+" ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }

    private int binomialCoeff(int n, int k) {
        int res = 1;
        if (k > n - k)
            k = n - k;
        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Pascal_Triangle pascal_triangle=new Pascal_Triangle(3);
        pascal_triangle.printPascal();
    }
}
