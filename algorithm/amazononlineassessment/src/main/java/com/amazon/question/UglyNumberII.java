package com.amazon.question;

public class UglyNumberII {
    private int n;

    public UglyNumberII(int n) {
        this.n = n;
    }

    public int nthUglyNumber(){
        return nthUglyNumber(n);
    }

    private int nthUglyNumber(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 2;
        if(n==2)
            return 3;
        if(n==3)
            return 5;
        int low=1;
        int high =Integer.MAX_VALUE;
        while(low<high){
            int mid  = (high+low)/2;
            int A= mid/2;
            int B =mid/3;
            int C =mid/5;
            int AIB =mid / lcm(A,B);
            int BIC =mid/lcm(B,C);
            int CIA =mid/lcm(C,A);
            int AIBIC =mid/lcm(C , lcm(A,B));
            int totalCount =  A+B+C- AIB-BIC-CIA +AIBIC;
           if(totalCount>n)
               high =mid;
            else
               low=mid+1;
        }
        return low;
    }

    public static void main(String[] args) {
        UglyNumberII numberII =new UglyNumberII(10);
        System.out.println(numberII.nthUglyNumber());
    }

    private int lcm(int a , int b){
        return a*b/(gcd(a,b));
    }

    private int gcd (int a , int b){
        if(b==0)
            return a;
        if(a==0)
            return b;
        return gcd(b,b%a);
    }

}
