package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 5/31/2017.
 * Given a sequence, find the length of the longest palindromic subsequence in it. For example, if the given sequence is “BBABCBCAB”,
 * then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
 */
public class LongestPalindromicSubsequence {

    private char[] inputString ;

    private int[][] resultArray ;

    public LongestPalindromicSubsequence(String inputString)
    {
        this.inputString = inputString.toCharArray() ;
        this.resultArray = new int[inputString.length()][inputString.length()] ;
    }

    public String getPalimdromicString()
    {
        for(int i=0;i<resultArray.length;i++)
            resultArray[i][i]=1;
        int result=0;
        while(++result < inputString.length)
            for(int i=0;(i+result) <inputString.length ;i++)
                if(inputString[i]==inputString[i+result])
                    resultArray[i][i+result]=2  +((result ==1) ? 0 : resultArray[i+1][i+result-1]);
                else
                    resultArray[i][i+result] = Math.max(resultArray[i][i+result-1] ,resultArray[i+1][i+result]);
        return getString();
    }

    public int getPalimdromicSubsequenceRecur(int i, int j) {
        if (i>j)
            return 0;
        if (i==j)
            return 0;
        if(i==j+1 && inputString[i]==inputString[j])
            return 2;
        if (resultArray[i][j]!=0)
            return resultArray[i][j];
        resultArray[i][j] = Math.max(getPalimdromicSubsequenceRecur(i+1,j),getPalimdromicSubsequenceRecur(i,j-1));
        return  resultArray[i][j];
    }

    public int getPalimdromicSubsequenceRecur() {
        return getPalimdromicSubsequenceRecur(0,inputString.length-1);
    }

    private String getString()
    {
        int i=0, j =inputString.length-1;
        char ch[]=new char[resultArray[i][j]];
        while(resultArray[i][j]!=0)
        {
            if(resultArray[i][j]!=resultArray[i+1][j-1])
            {
                ch[i]=   inputString[j];
                ch[resultArray[i][j]]=   inputString[j];
            }else
            {
                i++;j--;
            }

        }
        return null;
    }
    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence=new LongestPalindromicSubsequence("BBABCBCAB");
        System.out.printf(longestPalindromicSubsequence.getPalimdromicString());;

    }
}
