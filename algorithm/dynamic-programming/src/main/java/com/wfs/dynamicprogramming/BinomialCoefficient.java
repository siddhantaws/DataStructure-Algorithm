package com.wfs.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Suryasnata on 5/23/2017.
 * The value of C(n, k) can be recursively calculated using following standard formula for Binomial Coefficients.
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, 0) = C(n, n) = 1
 */
public class BinomialCoefficient {

    private int n ;
    private int k ;
    private Map<binomicalcoi ,Integer> binomicalcois=new HashMap<>();

    public BinomialCoefficient(int n, int k)
    {
        this.n=n;
        this.k=k;
    }

    public int getCooficientValue()
    {
        return  getCooficientValue(n,k);
    }

    private int getCooficientValue(int n , int k)
    {
        int coofi =0;
        if(k<0 || n<0)
            return 0;
        if( k==0 || (this.n == n && n == k))
            return 1;
        else
        {
            binomicalcoi bin=new binomicalcoi(n,k);
            if(binomicalcois.containsKey(bin))
                return binomicalcois.get(bin);
            else{
                    coofi= getCooficientValue(n-1 , k-1)+getCooficientValue(n-1 , k);
                binomicalcois.put(bin , coofi);
            }

        }
        return coofi;
    }

    public static void main(String[] args)
    {
        BinomialCoefficient  binomialCoefficient =new BinomialCoefficient(5 ,2);
        System.out.printf("binomialCoefficient" + binomialCoefficient.getCooficientValue());
    }
    class binomicalcoi{
        private int  k;
        private int v;

        public binomicalcoi(int k, int v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            binomicalcoi that = (binomicalcoi) o;

            if (k != that.k) return false;
            return v == that.v;
        }

        @Override
        public int hashCode() {
            int result = k;
            result = 31 * result + v;
            return result;
        }
    }
}
