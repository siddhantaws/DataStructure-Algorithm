package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RotateBitsIOfNumber {
    private int num ;

    private int d;

    private static int BIT_LENGTH = 31;

    public RotateBitsIOfNumber(int num, int d) {
        this.num = num;
        this.d = d;
    }

    public int getAfterRotation(){
        return (num >>d ) | (num << BIT_LENGTH-d);
    }

}
