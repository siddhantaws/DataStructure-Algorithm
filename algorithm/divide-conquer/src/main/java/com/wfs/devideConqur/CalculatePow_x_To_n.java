package com.wfs.devideConqur;

/**
 * Created by Suryasnata on 5/24/2017.
 */
public class CalculatePow_x_To_n
{
    private int x ;

    private int n ;

    public CalculatePow_x_To_n(int x, int n) {
        this.x = x;
        this.n = n;
    }

    public double getPowXToN()
    {
        return  getPowXToNInRecur(x , n);
    }

    private double getPowXToNInRecur(int x ,int n)
    {
        if(n==0)
            return 1;
        else
        {
            double temp = getPowXToNInRecur(x , n/2);
            if(n%2==0)
                return temp*temp ;
            else if(n>=0)
                return x*temp*temp ;
            else
                return (temp*temp)/x;
        }
    }

    private double getPowXToNInItera(){
        int result= 1;
        while(n>0){
            if(( n & 1)  ==1 ) //odd
                result = result * x;
            n = n >>2;
            x = x *x ;
        }
        return result;
    }

    public static void main(String[] args) {
        CalculatePow_x_To_n pow_x_to_n=new CalculatePow_x_To_n(2 ,-2);
        System.out.println(pow_x_to_n.getPowXToN());
    }
}
