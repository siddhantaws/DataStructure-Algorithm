package com.amazon.question;

public class DivideTwoIntegers {
    private int dividend;

    private int divisor ;

    public DivideTwoIntegers(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public int divide() {
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        int a =Math.abs(dividend);
        int b =Math.abs(divisor);
        int result =0;
        while(a-b>=0){
            int x =0;
            while(a -(b<<1<<x)>=0 ){
                x++;
            }
            result+= 1<<x;
            a -= b<<x;
        }
        return divisor<0 ? result*-1 : result;
    }

    public static void main(String[] args) {
        DivideTwoIntegers twoIntegers =new DivideTwoIntegers(7,-3);
        System.out.println(twoIntegers.divide() );
    }
}
