package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ComputeMinimumOrMaximumOfTwoIntegersWithoutBranching {
    private int x;
    private int y;

    public ComputeMinimumOrMaximumOfTwoIntegersWithoutBranching(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int min() {
        int A = (x - y);
        int B = (x - y) >> 31;
        int C = A & B ;
        return y + C;
    }

    public static void main(String[] args) {
        ComputeMinimumOrMaximumOfTwoIntegersWithoutBranching maximum =new ComputeMinimumOrMaximumOfTwoIntegersWithoutBranching(3,6);
        System.out.println(maximum.min());
    }
}
