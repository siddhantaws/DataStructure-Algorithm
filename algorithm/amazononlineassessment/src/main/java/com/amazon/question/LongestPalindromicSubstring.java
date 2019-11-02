package com.amazon.question;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    private char[] str;

    public LongestPalindromicSubstring(String str) {
        this.str = str.toCharArray();
    }

    public String longestPalindrome() {
        char str1[]=null;int index=0;
        if(str.length%2==0){
            str1 = new char[2*str.length+1];
            for(int i=0;i<str1.length;i++){
                   if(i%2==0)
                       str1[i]='#';
                   else
                       str1[i]=str[index++];
            }
        }else{
            str1 =str;
        }
        int tempArr[] =new int[str1.length];
        Arrays.fill(tempArr,1);

        for(int i=1;i<str1.length;i++){
            int lastPalimdrom =  tempArr[i-1]/2;

            for(int k=i;k<i+lastPalimdrom;i++){

            }
        }
        return null;
    }

    public int countSubstrings() {
        boolean arr[][] =new boolean[str.length][str.length];
        int result =0;
        for(int i=0;i<arr.length;i++){
            arr [i][i]=true;
            result++;
        }
        int l=2;
        while(l<=str.length){
            for(int i=0;i+l-1<str.length;i++){
                if(l>2){
                    arr[i][i+l-1] = str[i]==str[i+l-1] ? arr[i+1][i+l-2]  : false;
                }else{
                    arr[i][i+l-1] =  str[i]==str[i+l-1] ? true :false;
                }
                if(arr[i][i+l-1])
                    result++;
            }
            l++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring substring =new LongestPalindromicSubstring("aaa");
        System.out.println(substring.countSubstrings());
    }
}
