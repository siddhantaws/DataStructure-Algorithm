package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class DetectIfTwoIntegerHaveOppositeSign {
    private int a ;

    private int b ;

    public DetectIfTwoIntegerHaveOppositeSign(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean isDifferentSign(){
         return (a ^ b >> 31) == 1;
    }
}
