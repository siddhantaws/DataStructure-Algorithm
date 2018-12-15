package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckIfNumberDivisibleBy17 {

    public static void main(String[] args) {
        int n= 20;
        int y = Math.floorDiv(n ,8);
        int x = (n%8)/8;
        System.out.println(x+y);
    }
}
