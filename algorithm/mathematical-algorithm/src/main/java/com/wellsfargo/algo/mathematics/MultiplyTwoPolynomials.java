package com.wellsfargo.algo.mathematics;

public class MultiplyTwoPolynomials {

    private int arr1[];

    private int arr2[];

    private int m;

    private int n;

    public MultiplyTwoPolynomials(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.m= arr1.length;
        this.n= arr2.length;
    }

    private void printPoly(int[] arr1){
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]==0)
                continue;
            System.out.print(arr1[i]);
            if(i!=0)
                System.out.print("x^"+i);
            if(i!=arr1.length-1)
                System.out.print("+");
        }
    }

    public int[] multiply(){
        int prod[] = new int[m+n-1];

        // Initialize the porduct polynomial
        for (int i = 0; i<m+n-1; i++)
            prod[i] = 0;

        for (int i=0; i<m; i++)
        {
            // Multiply the current term of first polynomial
            // with every term of second polynomial.
            for (int j=0; j<n; j++)
                prod[i+j] += arr1[i]*arr2[j];
        }

        return prod;
    }


    public static void main(String[] args) {
        int arr1[] ={5, 0, 10, 6};int arr2[] ={5, 0, 10, 6};
        MultiplyTwoPolynomials polynomials =new MultiplyTwoPolynomials(new int[]{5, 0, 10, 6},new int[]{5, 0, 10, 6}) ;
        polynomials.printPoly(arr1);
        polynomials.printPoly(arr2);
        polynomials.printPoly(polynomials.multiply());
    }
}
