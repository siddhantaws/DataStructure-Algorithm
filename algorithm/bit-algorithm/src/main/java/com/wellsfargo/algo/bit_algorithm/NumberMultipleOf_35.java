package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class NumberMultipleOf_35 {

    private int num ;

    public NumberMultipleOf_35(int num) {
        this.num = num;
    }

    public boolean isDivisible(){
        return isDivisible(num);
    }

    private  boolean isDivisible(int num1){
        if(num1<0 )
            return false;
        else if(num1 ==0 || num1 ==35)
            return true ;
        else
        {
            int x =(num1>> 5);
            int y= (num1 & 31);
            return isDivisible( ((x<<1)+x)-y   );
        }

    }

    public static void main(String[] args) {
        NumberMultipleOf_35 numberMultipleOf_35 =new NumberMultipleOf_35(105);
        for(int i=1;i<500;i++) {
            numberMultipleOf_35.num =i;
            if(numberMultipleOf_35.isDivisible())
                System.out.println(i);
        }
    }
}
