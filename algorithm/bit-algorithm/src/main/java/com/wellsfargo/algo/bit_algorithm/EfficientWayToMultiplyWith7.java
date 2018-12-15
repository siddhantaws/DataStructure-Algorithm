package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class EfficientWayToMultiplyWith7 {
    private int num ;

    public EfficientWayToMultiplyWith7(int num) {
        this.num = num;
    }

    public int getMultiplyBy7(){
        return (num<<3 - num);
    }
}
