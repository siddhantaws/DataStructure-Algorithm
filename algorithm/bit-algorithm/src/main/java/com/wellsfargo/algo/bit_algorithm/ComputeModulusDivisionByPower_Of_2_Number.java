package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ComputeModulusDivisionByPower_Of_2_Number {
    private int num ;
    private int d ;

    public ComputeModulusDivisionByPower_Of_2_Number(int num, int d) {
        this.num = num;
        this.d = d;
    }

    public int getModolus(){
        if(d ==0 )
            throw new RuntimeException();
        else if( (d & d-1)!=0 )
            throw new RuntimeException();
        else
            return num & d-1 ;
    }
}
