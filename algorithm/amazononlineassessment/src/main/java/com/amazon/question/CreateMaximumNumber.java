package com.amazon.question;

import sun.java2d.cmm.ColorTransform;

public class CreateMaximumNumber {
    private int num1[];
    private int num2[];
    private int K;
    private int max_number = Integer.MIN_VALUE;
    public CreateMaximumNumber(int[] num1, int[] num2, int K) {
        this.num1 = num1;
        this.num2 = num2;
        this.K = K;
    }

    public  int[] getMaxNumber(){
        getMaxNumber(0,0,0,"");
        String s =max_number+"";
        int a [] = new int[s.length()];

        for(int i=0;i<s.length();i++)
            a[i]=s.charAt(i)-'0';
        return a;
    }

    private String getMaxNumber(int i, int j ,int k ,String s){
        if(k>=K)
            return s;
        else{
            int a= Integer.MIN_VALUE;int b = Integer.MIN_VALUE; int c= Integer.MIN_VALUE;
            if(i<num1.length)
                a = Integer.parseInt(getMaxNumber(i+1,j,k+1,s+num1[i]));
            if(j<num2.length)
                b = Integer.parseInt(getMaxNumber(i,j+1,k+1,s+num2[j]));
            if (i<num1.length && j<num2.length )
                c = Math.max(Integer.parseInt(getMaxNumber(i+1,j+1,k+2,s+ num1[i]+num2[j]))  ,Integer.parseInt(getMaxNumber(i+1,j+1,k+2,s+ num2[j]+num1[i])) );
            int maxNum =Math.max(Math.max(a,b),c);
            max_number =Math.max(max_number, maxNum);
            return maxNum+"";
        }
    }

    public static void main(String[] args) {
        CreateMaximumNumber number =new CreateMaximumNumber(new int[]{3, 4, 6, 5} ,new int[]{9, 1, 2, 5, 8, 3},5);
        for(int x :number.getMaxNumber())
            System.out.print( x+" ");
    }
}
