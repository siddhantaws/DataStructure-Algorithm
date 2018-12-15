package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ComputeIntegerAbsoluteValueWithoutBranching {
    private int num;

    public ComputeIntegerAbsoluteValueWithoutBranching(int num) {
        this.num = num;
    }
    public int getAbs()
    {
        int mask = 31;
        int x = (num + mask);
        System.out.println(x ^ mask);
        return ( x ^ mask);
    }

    public static void main(String[] args) {
        ComputeIntegerAbsoluteValueWithoutBranching withoutBranching =new ComputeIntegerAbsoluteValueWithoutBranching(-4);
        withoutBranching.getAbs();
    }
}
