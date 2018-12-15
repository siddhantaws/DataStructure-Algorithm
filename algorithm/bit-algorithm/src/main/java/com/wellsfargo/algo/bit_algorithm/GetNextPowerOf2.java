package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GetNextPowerOf2 {
    private int num;

    public GetNextPowerOf2(int num) {
        this.num = num;
    }

    public int nextPowerOf2() {
        num--;
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 16;
        num++;
        return num;
    }

    public static void main(String[] args) {
        GetNextPowerOf2 powerOf2 =new GetNextPowerOf2(5);
        System.out.println(powerOf2.nextPowerOf2());
    }
}
