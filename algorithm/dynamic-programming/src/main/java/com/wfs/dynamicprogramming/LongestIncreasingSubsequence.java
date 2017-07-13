package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 5/10/2017.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and
 * LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence
{
    private int [] arr;

    public LongestIncreasingSubsequence(){}

    public LongestIncreasingSubsequence(int [] arr)
    {
        this.arr=arr;
    }

    public char[] getlongestIncreasingSubsequence()
    {
        int i=0 ,j=++i , maxPos=0;
        int arrTemp[] =new int[arr.length];
        for(int k=0;k<arrTemp.length;k++)
            arrTemp[k]=1;
        while(j!=arr.length-1 && i==j)
        {
            for(;i<j;i++)
            {
                if(arr[i]<arr[j])
                {
                    arrTemp[j]=arrTemp[i] +1;
                    maxPos =arrTemp[j] > arrTemp[maxPos] ? j : maxPos;
                }
            }
            i=0;
        }
        return  getArray(arrTemp ,  maxPos);
    }

    private char[] getArray( int arrTemp[] , int maxPos)
    {
        StringBuffer sb=new StringBuffer();
        for(int i=maxPos;i>=1;i--)
        {
            if(arrTemp[i] > arrTemp[i-1])
                sb.append(arrTemp[i]);
        }
        return null;
    }

    public static void main(String[] args)
    {
        int arr[]={10 , 22, 9, 33, 21, 50, 41, 60, 80};
        LongestIncreasingSubsequence longestIncreasingSubsequence= new LongestIncreasingSubsequence(arr);
        System.out.println(longestIncreasingSubsequence.getlongestIncreasingSubsequence());
    }
}
