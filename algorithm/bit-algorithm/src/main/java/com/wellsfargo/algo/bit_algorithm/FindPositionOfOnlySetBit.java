package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindPositionOfOnlySetBit {
    private int num;

    public FindPositionOfOnlySetBit(int num) {
        this.num = num;
    }

    private boolean isPowerOf2(){
        return num ==0 || ((num & num-1)==0) ;
    }

    public int getPosition(){
        int count =1 ;int n = num;
        if(isPowerOf2())
            throw new NumberFormatException("");
        else
            while(n>0){
                n = n>>1;count++;
            }
        return count;
    }
}
