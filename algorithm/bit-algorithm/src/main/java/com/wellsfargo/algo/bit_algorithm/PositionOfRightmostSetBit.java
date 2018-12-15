package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PositionOfRightmostSetBit {

    private int num ;

    public PositionOfRightmostSetBit(int num) {
        this.num = num;
    }

    public int getRightMostBit(){
        int m =1 ;
        int x =num;
        int count =0;
        while((x & m)==0){
            count++;
            m=m<<1;
        }
        return count;
    }
}
