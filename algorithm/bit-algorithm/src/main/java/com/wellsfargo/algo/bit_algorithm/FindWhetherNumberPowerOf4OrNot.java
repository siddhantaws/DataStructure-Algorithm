package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindWhetherNumberPowerOf4OrNot {
    private int num;

    public FindWhetherNumberPowerOf4OrNot(int num) {
        this.num = num;
    }

    private boolean isPowerOf4(int num){
        if(num == 0)
            return true;
        else if(num<4)
            return false;
        else
            return ( (num & num-1)==0) && isPowerOf4((int)Math.log(num));
    }
}
