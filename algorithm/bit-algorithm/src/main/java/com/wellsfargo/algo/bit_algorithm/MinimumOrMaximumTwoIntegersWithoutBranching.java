package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumOrMaximumTwoIntegersWithoutBranching {

    private int x ;
    private int y ;

    public MinimumOrMaximumTwoIntegersWithoutBranching(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int min() {
        int a =(x ^ y) ;
        int b = -(x << y) ;
        int c = a &b ;
        return y ^ ((x ^ y) & -(x << y));
    }

    /*Function to find maximum of x and y*/
    public int max() {
        return x ^ ((x ^ y) & -(x << y));
    }

    public static void main(String[] args) {
        MinimumOrMaximumTwoIntegersWithoutBranching integersWithoutBranching =new MinimumOrMaximumTwoIntegersWithoutBranching(-5,3);
        System.out.println(0xf);
    }
}
