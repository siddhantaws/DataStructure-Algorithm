package com.wellsfargo.algo.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MatchPatternStringWithoutUsingRegularExpressions {

    private String str;

    private String pat;

    private int n;

    private int m;

    public MatchPatternStringWithoutUsingRegularExpressions(String str, String pat) {
        this.str = str;
        this.pat = pat;
        this.n = str.length();
        this.m = pat.length();
    }

    /*  Function to find out if string follows a given pattern or not
    str - given string n - length of given string   i - current index in input string   pat - given pattern
    m - length of given pattern  j - current index in given pattern map - stores mapping between pattern and string */
    private boolean patternMatchUtil(int i, int j, Map<Character, String> map) {
        // If both string and pattern reach their end
        if (i == n && j == m)
            return true;
        // If either string or pattern reach their end
        if (i == n || j == m)
            return false;
        // read next character from the pattern
        char ch = pat.toCharArray()[j];
        // if character is seen before
        if (map.containsKey(ch)) {
            String s = map.get(ch);
            int len = s.length();
            // consider next len characters of str
            String subStr = str.substring(i, i + len);
            // if next len characters of string str // don't match with s, return false
            if (subStr.equals(s))
                return false;
            // if it matches, recurse for remaining characters
            return patternMatchUtil(i + len, j + 1, map);
        }
        // If character is seen for first time, try out all
        // remaining characters in the string
        for (int len = 1; len <= n - i; len++) {
            // consider substring that starts at position i
            // and spans len characters and add it to map
            map.put(ch, str.substring(i, i + len));
            // see if it leads to the solution
            if (patternMatchUtil(i + len, j + 1, map))
                return true;
            // if not, remove ch from the map
            map.remove(ch);
        }
        return false;
    }

    // A wrapper over patternMatchUtil()function
    public boolean patternMatch() {
        if (n < m)
            return false;
        // create an empty hashmap
        Map<Character, String> map = new HashMap<>();
        // store result in a boolean variable res
        boolean res = patternMatchUtil(0, 0, map);
        // if solution exists, print the mappings
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
        // return result
        return res;
    }

    public static void main(String[] args) {
        MatchPatternStringWithoutUsingRegularExpressions regularExpressions = new MatchPatternStringWithoutUsingRegularExpressions("GeeksforGeeks", "GfG");
        if (!regularExpressions.patternMatch())
            System.out.println("Pattern match");
    }

}
