package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RussianPeasant_Multiply_NumbersUsingBitwise_Operators {

    private int a ;

    private int b;

    private int res=0;

    public RussianPeasant_Multiply_NumbersUsingBitwise_Operators(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int multiply(){
        return multiply(a,b);
    }

    private int multiply(int a, int b){
        if(b ==1)
            return a ;
        else {
            if((b & 1) ==0 )
                multiply( a <<1 , b>>1  );
            else{
                res = res + a ;
                multiply( a <<1 , b>>1  );
            }
        }
        return res;
    }
}
