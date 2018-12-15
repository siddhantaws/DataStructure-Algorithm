package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SwapAllOddAndEvenBits {
    private int num;

    public SwapAllOddAndEvenBits(int num) {
        this.num = num;
    }

    private int swap(){
        int even_bits = num & 0xAAAAAAAA;
        int odd_bits  = num & 0x55555555;
        return ((even_bits >>1 )| (odd_bits << 1)) ;
    }

    public static void main(String[] args) {
        System.out.println(0x55);
    }
}
