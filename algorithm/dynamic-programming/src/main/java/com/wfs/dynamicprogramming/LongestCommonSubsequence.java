package com.wfs.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Suryasnata on 5/11/2017.
 * LCS for input Sequences ABCDGH and AEDFHR is ADH of length 3.
 * LCS for input Sequences AGGTAB and GXTXAYB is GTAB of length 4.
 */
public class LongestCommonSubsequence
{
    String str1 = "abcabcaa";
    String str2 = "acbacba";

    public LongestCommonSubsequence(String str1 , String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }
    public LongestCommonSubsequence(){}
    public static void main(String[] args)
    {
        LongestCommonSubsequence longestCommonSubsequence =new LongestCommonSubsequence();
        System.out.println("LongestCommonSubsequence "+ longestCommonSubsequence.lcsDynamic());
        System.out.println("LongestCommonSubsequence "+ longestCommonSubsequence.lcsDynamicTopdown());
    }
    public String lcsDynamic()
    {
        return  lcsDynamic(str1.toCharArray() , str2.toCharArray());
    }

    public int lcsDynamicTopdown()
    {
        return  lcsDynamicTopdown(str1.toCharArray() , str2.toCharArray());
    }

    public String lcsDynamic(char[] s1 ,char[] s2)
    {
        int[][] temp=new int[s1.length+1][s2.length+1];
        int max=0;
        for(int i=1;i<=s1.length;i++)
            for(int j=1;j<=s2.length;j++) {
                if (s2[j - 1] == s1[i - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                }
                max = temp[i][j] > max ? temp[i][j] : max;
            }
        return getLongestCommonSubsequence(temp , s1 ,s2);
    }

    private String getLongestCommonSubsequence(int[][] temp ,char[] s1 ,char[] s2 )
    {
        StringBuffer sb=new StringBuffer();
        int row = s1.length , col= s2.length;
        while(temp[row][col] != 0)
        {
            if(temp[row][col] >  temp[row][col-1]  &&  temp[row][col] > temp[row-1][col-1])
            {
                sb.append(s2[--col]);
                row --;
            }
            else{
                col-- ;
            }
        }
        return new String(sb.reverse());
    }

    public int lcsDynamicTopdown(char[] s1 ,char[] s2){
        final Map<String , Integer> mapOfStringToCommonLength = new HashMap<String , Integer>();
        return lcsDynamicTopdown(s1 ,  s1.length-1 , s2 , s2.length-1  ,mapOfStringToCommonLength );
    }

    public int lcsDynamicTopdown(char[] s1 ,int s1End , char[] s2 , int s2End , final Map<String , Integer> mapOfStringToCommonLength ){
        if(s1End==-1 || s2End==-1)
            return 0;
        final String one = new String(s1 , 0 ,s1End );
        final String two = new String(s2 , 0 ,s2End );
        if(mapOfStringToCommonLength.containsKey(one+"$"+two))
            return mapOfStringToCommonLength.get(one+"$"+two);
        if(s1[s1End]==s2[s2End])
            mapOfStringToCommonLength.put(one+"$"+two , 1+ lcsDynamicTopdown(s1, s1End-1 ,s2 ,s2End-1 , mapOfStringToCommonLength));
        else
            mapOfStringToCommonLength.put(one+"$"+two ,Math.max(lcsDynamicTopdown(s1, s1End-1 ,s2 ,s2End , mapOfStringToCommonLength) ,lcsDynamicTopdown(s1, s1End ,s2 ,s2End-1 , mapOfStringToCommonLength) ));
        return mapOfStringToCommonLength.get(one+"$"+two);
    }
}
