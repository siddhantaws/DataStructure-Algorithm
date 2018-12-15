package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CountSetBitsInAnInteger {
    private int num;

    public CountSetBitsInAnInteger(int num) {
        this.num = num;
    }

    public int getTotalSetBit1() {
        int count = 0;
        int x = num;
        while ((x & 1) > 0) {
            x = x >> 1;
            count++;
        }
        return count;
    }

    private  int getTotalSetBit2(int x) {
        if(x==0)
            return 0;
        return 1+ getTotalSetBit2(x & (x-1));
    }
}
