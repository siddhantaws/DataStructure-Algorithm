package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ReverseBitsOfANumber {
    private int number;

    public ReverseBitsOfANumber(int number) {
        this.number = number;
    }

    public int reverseBit(){
        return reverseBit(number);
    }

    private  int reverseBit(int num) {
        int count = (Integer.SIZE / Byte.SIZE) * 8 - 1;

        int reverse_num = num;
        num >>>= 1;
        while (num != 0) {
            reverse_num <<= 1;
            reverse_num |= num & 1;
            num >>>= 1;
            count--;
        }
        reverse_num <<= count;
        return reverse_num;
    }

    public static void main(String[] args) {
        ReverseBitsOfANumber bitsOfANumber =new ReverseBitsOfANumber(5);
        System.out.println(bitsOfANumber.reverseBit());
    }
}
