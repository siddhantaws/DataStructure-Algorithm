package com.wfs.amazon.bit;

public class    _29DivideTwoIntegers {
    private int dividend;
    private int divisor;

    public _29DivideTwoIntegers(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    private int divide() {
        if(dividend == Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        int a =Math.abs(dividend);
        int b =Math.abs(divisor);
        int result =0;
        while(a-b>=0){
            int x=0;
            while(a-(b<<1<<x)>=0)
                x++;
            result+=1<<x;
            a-= b<<x;
        }
        return  ( (dividend>0 && divisor>=0) ||(dividend<0 && divisor<0) ) ?  result : result*-1 ;
    }

    public static void main(String[] args) {
        _29DivideTwoIntegers twoIntegers =new _29DivideTwoIntegers(24,3);
        System.out.println(twoIntegers.divide());
    }
}
