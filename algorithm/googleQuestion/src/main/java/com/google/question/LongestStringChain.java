package com.google.question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    private String[] words;

    public LongestStringChain(String[] words) {
        this.words = words;
    }

    public static void main(String[] args) {
        LongestStringChain stringChain =new LongestStringChain(new String[]{"a","b","ba","bca","bda","bdca"});
        System.out.println(stringChain.longestStrChain());
    }

    public int longestStrChain() {
        if(words.length==0)
            return 0;
        int len = words.length;
        int[] table = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(table,1);
        Arrays.sort(words, (s1, s2) -> s1.length()-s2.length());
        map.put(words[0].length(), 0);
        for(int i=1; i<len; i++){
            if(words[i].length()>words[i-1].length()) map.put(words[i].length(), i);
        }
        int max=1;
        for(int i=0; i<len; i++){
            int l=words[i].length();
            int start = map.containsKey(l+1)? map.get(l+1):len;
            int end= map.containsKey(l+2)? map.get(l+2):len;
            for(int j=start;j<end; j++){
                if(check(words[i].toCharArray(), words[j].toCharArray())){
                    table[j]=Math.max(table[i]+1, table[j]);
                }
            }
            max=Math.max(table[i], max);
        }
        return max;
    }

    private boolean check(char[] s1, char[] s2){
        int[] table = new int[26];
        for(int i=0; i<s2.length; i++){
            table[s2[i]-'a']++;
        }
        for(int i=0; i<s1.length; i++){
            if(--table[s1[i]-'a']<0) return false;
        }
        return true;
    }
}
