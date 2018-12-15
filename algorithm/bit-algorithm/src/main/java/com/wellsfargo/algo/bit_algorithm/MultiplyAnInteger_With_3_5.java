package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MultiplyAnInteger_With_3_5 {
    private int num ;

    public MultiplyAnInteger_With_3_5(int num) {
        this.num = num;
    }

    public int getMultiplication(){
        return (num<<3) >>1 ;
    }
}
