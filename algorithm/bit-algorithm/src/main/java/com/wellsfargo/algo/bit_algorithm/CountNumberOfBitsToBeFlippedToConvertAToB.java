package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CountNumberOfBitsToBeFlippedToConvertAToB {

    private int A ;

    private int B ;

    public CountNumberOfBitsToBeFlippedToConvertAToB(int a, int b) {
        A = a;
        B = b;
    }

    public int getCount(){
        int count =0;
        int x = A ^ B ;
        while(x >0){
            if((x & 1)>0){
                count++;
            }
            x = x >>1;
        }
        return count;
    }
}

