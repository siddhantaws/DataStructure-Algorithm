package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TurnOffTheRightmostSetBit {
    private int num;

    public TurnOffTheRightmostSetBit(int num) {
        this.num = num;
    }

    public int getNumberAfterTurnOff(){
        return num & num-1 ;
    }

}
