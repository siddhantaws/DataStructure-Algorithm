package com.wellsfargo.algo.mathematics;

/*
* e^x = 1 + x/1! + x^2/2! + x^3/3! + ......
* e^x = 1 + (x/1) (1 + (x/2) (1 + (x/3) (........) ) )
 * */
public class E2PowerX {

    private int n;

    private float x;

    public E2PowerX(int n, float x) {
        this.n = n;
        this.x = x;
    }

    public float  calcuate(){
        float sum =1;

        for(int i=n;i>=1;i++)
            sum  =1 + sum *(x/i);
        return sum;
    }

    public static void main(String[] args) {
        E2PowerX powerX =new E2PowerX(10 , 1);
    }
}
