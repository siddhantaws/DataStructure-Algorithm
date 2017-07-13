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

    public long getPowXToN()
    {
        return  getPowXToN(x , n);
    }

    private long getPowXToN(int x ,int n)
    {
        if(n==0)
            return 1;
        else
        {
            long temp = getPowXToN(x , n/2);
            if(n%2==0)
                return temp*temp ;
            else
                return x*temp*temp ;
        }
    }

    public static void main(String[] args) {
        CalculatePow_x_To_n pow_x_to_n=new CalculatePow_x_To_n(2 ,5);
        System.out.println(pow_x_to_n.getPowXToN());
    }
}
