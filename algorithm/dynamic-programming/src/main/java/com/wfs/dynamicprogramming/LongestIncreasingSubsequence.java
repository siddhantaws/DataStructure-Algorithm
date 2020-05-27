package com.wfs.dynamicprogramming;

import java.util.Collections;
import java.util.TreeMap;

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

    private TreeMap<Integer ,Integer> integerTreeMap;

    public LongestIncreasingSubsequence(int [] arr){
        this.arr=arr;
        this.integerTreeMap =new TreeMap<>();
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


    private int getlongestIncreasingSubsequenceBinarySearch(){
        int min_value= arr[0];int max_value= arr[0];integerTreeMap.put(arr[0],1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min_value){
                integerTreeMap.remove(min_value);
                if (min_value==max_value)
                    max_value=arr[i];
                min_value =arr[i];
                integerTreeMap.put(min_value,1);
            }else if(arr[i]>max_value){
                integerTreeMap.put(arr[i] , integerTreeMap.get(max_value)+1);
                max_value=arr[i];
            }else{
                Integer key = integerTreeMap.tailMap(arr[i] , true).firstEntry().getKey();
                if (key.intValue()!=arr[i])
                    integerTreeMap.put(arr[i], integerTreeMap.remove(key));
                if (key==max_value)
                    max_value =arr[i];
            }
        }
        return integerTreeMap.get(integerTreeMap.lastKey());
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
        System.out.println(longestIncreasingSubsequence.getlongestIncreasingSubsequenceBinarySearch());
    }
}
