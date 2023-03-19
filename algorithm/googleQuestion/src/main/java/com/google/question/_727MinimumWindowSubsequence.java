package com.google.question;

import java.util.HashMap;
import java.util.TreeSet;

public class _727MinimumWindowSubsequence {
    private final String s1 ;

    private final String s2 ;

    public _727MinimumWindowSubsequence(final String s1 ,final String s2 ){
        this.s1 = s1;
        this.s2 = s2;
    }

    public static void main(String[] args) {
        _727MinimumWindowSubsequence minimumWindowSubsequence =new _727MinimumWindowSubsequence("abcdebdde", "bde");
        System.out.println(minimumWindowSubsequence.minWindow());
    }

    public String minWindow(){
        return minWindow(s1 , s2);
    }

    public String minWindow(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        HashMap<Character, TreeSet<Integer>> map=new HashMap<>();

        for(int i=0;i<m;i++){
            char c=s1.charAt(i);
            map.put(c,map.getOrDefault(c,new TreeSet<>()));
            map.get(c).add(i);
        }

        char c=s2.charAt(0);
        TreeSet<Integer> set=map.get(c);
        if(set==null){
            return "";
        }
        if(n==1){
            return s2;
        }

        int minLen=Integer.MAX_VALUE;
        int minIndex=Integer.MAX_VALUE;

        for(int startIndex:set){
            Integer higher=startIndex;
            for(int i=1;i<n;i++){
                char c2=s2.charAt(i);
                set=map.get(c2);
                if(set==null){
                    return "";
                }
                higher=set.higher(higher);
                if(higher==null){
                    break;
                }
                if(i==n-1 && higher-startIndex+1<minLen){
                    minIndex=startIndex;
                    minLen=higher-startIndex+1;
                }
            }
        }
        return minIndex==Integer.MAX_VALUE ? "" : s1.substring(minIndex,minIndex+minLen);
    }
}
