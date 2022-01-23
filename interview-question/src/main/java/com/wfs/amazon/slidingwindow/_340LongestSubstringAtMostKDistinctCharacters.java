package com.wfs.amazon.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _340LongestSubstringAtMostKDistinctCharacters {
    private String str ;
    private int k ;

    public _340LongestSubstringAtMostKDistinctCharacters(String str, int k) {
        this.str = str;
        this.k = k;
    }

    public int lengthOfLongestSubstringKDistinct() {

        Map<Character,Integer> mapOfCharacterToStr =new HashMap<Character,Integer>();

        int maxLength = Integer.MIN_VALUE;
        int l=0;int r=0;
        while(r<str.length()){
            char ch = str.charAt(r);
            mapOfCharacterToStr.compute(ch  , (k,v) ->  v==null ? 1 :v+1 );
            if(mapOfCharacterToStr.size()>k){
                maxLength =Math.max(maxLength ,r-l);

                while(mapOfCharacterToStr.size()!=k){
                    char ch1 = str.charAt(l);
                    mapOfCharacterToStr.compute(ch1 , (k,v)-> v==1? null : v-1);
                    l++;
                }
                maxLength = Math.max(maxLength ,r-l+1);
            }
            r++;
        }

        return Math.max(maxLength , r-l);
    }

    public static void main(String[] args) {
        _340LongestSubstringAtMostKDistinctCharacters substring =new _340LongestSubstringAtMostKDistinctCharacters("eceba",2);
        System.out.println(substring.lengthOfLongestSubstringKDistinct());
    }
}
