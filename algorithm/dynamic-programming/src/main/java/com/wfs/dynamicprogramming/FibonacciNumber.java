package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 5/10/2017.
 */
public class FibonacciNumber
{
    private int[] fibSeries ;
    private int fibNumber ;

    public int getFibNumber() {
        return fibNumber;
    }

    public FibonacciNumber(int num)
    {
        this.fibSeries=new int[num + 1];
        this.fibNumber =num;
    }
    public int topDownFib(int n )
    {
        if(fibSeries[n]==0)
        {
            if(n<=1)
                fibSeries[n] =n;
            else
                fibSeries[n] = topDownFib(n-1) + topDownFib(n-2);
        }
        return  fibSeries[n];
    }

    public int buttomUp(int num)
    {
        reset();
        fibSeries[1]=1 ;
        for(int i=2;i<fibSeries.length;i++)
            fibSeries[i] =fibSeries[i-1]+fibSeries[i-2];
        return fibSeries[fibSeries.length-1];
    }

    private void reset()
    {
        this.fibSeries=new int[fibNumber + 1];
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber=new FibonacciNumber(11);
        System.out.println("Fibonacii Number TopDown: "+fibonacciNumber.topDownFib(fibonacciNumber.fibNumber));
        System.out.println("Fibonacii Number ButtomUp: "+fibonacciNumber.buttomUp(fibonacciNumber.fibNumber));
    }
}
