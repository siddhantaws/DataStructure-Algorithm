package com.wellsfargo.algo.mathematics;

public class MultiplyTwoIntegersWithoutUsingMultiplicationDivisionBitwiseOperatorsAndNoLloops
{

    int pow(int a, int b)
    {
        if(b>0)
            return multiply(a, pow(a, b-1));
        else
            return 1;
    }

    /* A recursive function to get x*y */
    int multiply(int x, int y)
    {
        if(y>0)
            return (x + multiply(x, y-1));
        else
            return 0;
    }

    public static void main(String[] args) {
        MultiplyTwoIntegersWithoutUsingMultiplicationDivisionBitwiseOperatorsAndNoLloops multiplyTwoIntegersWithoutUsingMultiplicationDivisionBitwiseOperatorsAndNoLloops=new MultiplyTwoIntegersWithoutUsingMultiplicationDivisionBitwiseOperatorsAndNoLloops();
        System.out.print(multiplyTwoIntegersWithoutUsingMultiplicationDivisionBitwiseOperatorsAndNoLloops.pow(5 , 3));
    }

}
