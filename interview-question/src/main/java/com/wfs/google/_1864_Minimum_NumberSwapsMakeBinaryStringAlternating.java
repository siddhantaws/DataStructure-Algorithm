package com.wfs.google;

public class _1864_Minimum_NumberSwapsMakeBinaryStringAlternating {
    public static void main(String[] args) {
        System.out.println(minSwaps("1001100"));
    }

    public static int minSwaps(final String s) {
        if(s==null || s.length()==0)
            return -1;
        int numOfZeros=0;int numOfOnes= 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='0')
                numOfZeros++;
        numOfOnes = s.length()-numOfZeros;
        if(Math.abs(numOfOnes - numOfZeros)>1)
            return -1;
        if(numOfOnes>numOfZeros){
            return getMinSwap(s , '1');
        }else if(numOfZeros>numOfOnes){
            return getMinSwap(s , '0');
        }else{
            return Math.min(getMinSwap(s , '0') ,getMinSwap(s , '1') );
        }
    }

    public static int getMinSwap(final String s , char ch){
        int count=0;
        for(int i=0;i<s.length();i=i+2){
            if(s.charAt(i)!=ch)
                count++;
        }
        return count;
    }
}
