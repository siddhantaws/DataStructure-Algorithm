package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckGivenNumberIsFibonacciNumber {

    private int num ;

    public CheckGivenNumberIsFibonacciNumber(int num) {
        this.num = num;
    }

    private boolean isPerfectSquare(int n){
        int n1= (int)Math.sqrt(n);
        return n1*n1 == n;
    }

    public boolean isFibonacii(){
        return isPerfectSquare((5*num*num) -4 ) || isPerfectSquare((5*num*num) + 4 );
    }
}
