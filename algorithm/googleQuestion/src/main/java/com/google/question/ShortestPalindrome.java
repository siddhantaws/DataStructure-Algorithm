package com.google.question;

import java.util.ArrayList;
import java.util.List;

public class ShortestPalindrome {

    public String shortestPalindrome(String s){
        int n = s.length();
        String rev= new StringBuffer(s).reverse().toString();
        String s_new = s + "#" + rev;
        int n_new = s_new.length();
        List<Integer> l=new ArrayList(n_new);
        l.set(0,0);
        for (int i = 1; i < n_new; i++) {
            int t = l.get(i - 1);
            while (t > 0 && s_new.charAt(i) != s_new.charAt(t))
                t = l.get(i - 1);
            if (s_new.charAt(i) == s_new.charAt(t))
                ++t;
            l.set(i  , t);
        }
        return rev.substring(0, n -  l.get(n_new - 1)) + s;
    }

    public static void main(String[] args) {
        ShortestPalindrome palindrome =new ShortestPalindrome();
        palindrome.shortestPalindrome("abcd");
    }
}
