package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SwapTwoNibblesByte {
    private int num;

    public SwapTwoNibblesByte(int num) {
        this.num = num;
    }

    private int swapNibbles() {
        return ((num & 0x0F) << 4 | (num & 0xF0) >> 4);
    }

    public static void main(String[] args) {
        SwapTwoNibblesByte nibblesByte =new SwapTwoNibblesByte(100);
        System.out.println(nibblesByte.swapNibbles());
        System.out.println(0xF);
    }
}
