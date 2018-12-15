package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckIfNumberDivisibleBy8 {

    private int x ;

    public CheckIfNumberDivisibleBy8(int x) {
        this.x = x;
    }

    public boolean isDivisibleBy(){
        return ((x >>3 )<<3 ) == x;
    }

    public static void main(String[] args) {
        CheckIfNumberDivisibleBy8 divisibleBy8 =new CheckIfNumberDivisibleBy8(16);
        divisibleBy8.isDivisibleBy();
    }


}
