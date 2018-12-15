package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ProgramToCountNumberOfSetBitsInBbigArray {
    private int arr[];

    private int[] look = new int[256];


    public ProgramToCountNumberOfSetBitsInBbigArray(int[] arr) {
        this.arr = arr;
        setLookUp();
    }

    private void setLookUp() {
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 32; j++) {
                if (((i >> j) & 1) != 0) {
                    look[i]++;
                }
            }
        }
    }

    public int countSetBits()
    {
        int count = 0;
        int a; int b; int c; int d; int no;
        for (int i = 0;i < arr.length;i++)
        {
            no = arr[i];
            a = no & (0xff);
            b = (no >> 8) & (0xff);
            c = (no >> 16) & (0xff);
            d = (no >> 24) & (0xff);
            count += look[a] + look[b] + look[c] + look[d];
        }
        return count;
    }

    public static void main(String[] args) {
       // ProgramToCountNumberOfSetBitsInBbigArray program =new ProgramToCountNumberOfSetBitsInBbigArray();
    }
}
