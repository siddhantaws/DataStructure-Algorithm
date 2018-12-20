package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PowerWithoutUsingMultiplicationAndDivisionOperators {

    private int num ;
    private int pow ;

    public PowerWithoutUsingMultiplicationAndDivisionOperators(int num, int pow) {
        this.num = num;
        this.pow = pow;
    }

    private int multiPly(int x ,int y){
        if(y ==0)
            return 0 ;
        else
            return x + multiPly(x , y-1) ;
    }

    private int power(int x, int y){
        if(y==0)
            return 1;
        else
           return multiPly(x, power(x, y-1));
    }

    public static void main(String[] args) {
        PowerWithoutUsingMultiplicationAndDivisionOperators andDivisionOperators =new PowerWithoutUsingMultiplicationAndDivisionOperators(5 , 3);
        System.out.println(andDivisionOperators.power(5,3));
    }
}
