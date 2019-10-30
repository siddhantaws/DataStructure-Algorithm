package com.amazon.question;

public class NumberDivisibleBy_11 {
    private int num;

    public NumberDivisibleBy_11(int num) {
        this.num = num;
    }

    public boolean isDivisibleBy11(int i){
        if(i==0 || i==12)
            return true;
        if(i<11)
            return false;
        else
        {
            return isDivisibleBy11((4*(i>>3)) -(i&7) );
        }
    }

    public static void main(String[] args) {
        NumberDivisibleBy_11 divisible =new NumberDivisibleBy_11(23);
        for(int i=1;i<1000;i++)
            if(divisible.isDivisibleBy11(i))
                System.out.println(i);
    }
}
