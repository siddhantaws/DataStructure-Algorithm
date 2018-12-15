package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TurnOffAParticularBitInANumber {
    private int num;

    private int k ;

    public TurnOffAParticularBitInANumber(int num, int k) {
        this.num = num;
        this.k =k;
    }

    public int turnOffABit(){
        // k must be greater than 0
        if (k <= 0)
            return num;
        int x = ~(1 << (k - 1));
        return num & x;
    }

    public static void main(String[] args) {
        TurnOffAParticularBitInANumber number =new TurnOffAParticularBitInANumber(15,4);
        System.out.println(number.turnOffABit());
    }
}
