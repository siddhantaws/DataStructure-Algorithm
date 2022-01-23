package com.wfs.amazon.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _76MinimumWindowSubstring {
    private String str;

    private String pattern;

    public _76MinimumWindowSubstring(String str, String pattern) {
        this.str = str;
        this.pattern = pattern;
    }

    public String minWindow() {
        int requiredLength =pattern.length();
        int currentLength =0;
        Map<Character,Integer> mapOfCharacterPattern =new HashMap<>();
        Map<Character,Integer> mapOfCharacterString =new HashMap<Character,Integer>();
        for(char c : pattern.toCharArray())
            mapOfCharacterPattern.compute(c , (k,v)-> {return v==null? 1 : v+1 ;});

        int l=0;int r=0;int arr[] =new int[3];

        while(r<str.length()){
            char ch = str.charAt(r);

            mapOfCharacterString.compute(ch , (k,v)-> {return v==null? 1 : v+1;});
            if(mapOfCharacterPattern.containsKey(ch) &&  mapOfCharacterString.get(ch) == mapOfCharacterPattern.get(ch))
                currentLength++;

            while(l<r && currentLength==requiredLength){
                char leftchar = str.charAt(l);
                if(arr[0]==0 || arr[0]> r-l+1){
                    arr[0] =r-l+1;
                    arr[1] =l;arr[2] =r;
                }

                mapOfCharacterString.put(leftchar , mapOfCharacterString.get(leftchar)-1);
                if(mapOfCharacterPattern.containsKey(leftchar) &&  mapOfCharacterString.get(leftchar)<mapOfCharacterPattern.get(leftchar))
                    currentLength--;
                l++;
            }
            r++;
        }

        return str.substring(arr[1], arr[2]);
    }

    public static void main(String[] args) {
        _76MinimumWindowSubstring substring =new _76MinimumWindowSubstring("ADOBECODEBANC","ABC");
        System.out.println(substring.minWindow());
    }
}
