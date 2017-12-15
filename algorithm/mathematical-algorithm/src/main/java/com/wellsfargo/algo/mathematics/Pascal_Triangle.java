package com.wellsfargo.algo.mathematics;

public class Pascal_Triangle {
    private int n;

    public Pascal_Triangle(int n) {
        this.n=n;
    }

    public void printPascal()
    {
        // Iterate through every line and print entries in it
        for (int line = 0; line < n; line++)
        {
            // Every line has number of integers equal to line number
            for (int i = 0; i <= line; i++)
                System.out.println(binomialCoeff(line, i));
            System.out.println("\n");
        }
    }

    private int binomialCoeff(int n, int k)
    {
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
