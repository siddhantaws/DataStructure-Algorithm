package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintNXNSpiralMatrixUsingO1ExtraSpace {
    private int n;

    public PrintNXNSpiralMatrixUsingO1ExtraSpace(int n) {
        this.n = n;
    }

    public void printInSpiralForm() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // x stores the layer in which (i, j)th element lies
                int x;
                // Finds minimum of four inputs
                x = Math.min(Math.min(i, j), Math.min(n - 1 - i, n - 1 - j));
                if (i <= j)// For upper right half
                    System.out.print((n - 2 * x) * (n - 2 * x) - (i - x) - (j - x) + "\t");
                else// for lower left half
                    System.out.print((n - 2 * x - 2) * (n - 2 * x - 2) + (i - x) + (j - x) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintNXNSpiralMatrixUsingO1ExtraSpace usingO1ExtraSpace = new PrintNXNSpiralMatrixUsingO1ExtraSpace(5);
        usingO1ExtraSpace.printInSpiralForm();
    }
}
