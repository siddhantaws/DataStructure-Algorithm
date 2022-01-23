package com.wfs.amazon.dynamicprograming;

public class _44WildcardMatching {

    private String str;

    private String pattern;

    public _44WildcardMatching(String str, String pattern) {
        this.str = str;
        this.pattern = pattern;
    }

    public boolean isMatch() {
        int sLen = str.length(), pLen = pattern.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {
            // If the pattern caracter = string character
            // or pattern character = '?'
            if (pIdx < pLen && (pattern.charAt(pIdx) == '?' || pattern.charAt(pIdx) == str.charAt(sIdx))){
                ++sIdx;
                ++pIdx;
            }
            // If pattern character = '*'
            else if (pIdx < pLen && pattern.charAt(pIdx) == '*') {
                // Check the situation
                // when '*' matches no characters
                starIdx = pIdx;
                sTmpIdx = sIdx;
                ++pIdx;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was no '*' character in pattern
            else if (starIdx == -1) {
                return false;
            }
            // If pattern character != string character
            // or pattern is used up
            // and there was '*' character in pattern before
            else {
                // Backtrack: check the situation
                // when '*' matches one more character
                pIdx = starIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }

        // The remaining characters in the pattern should all be '*' characters
        for(int i = pIdx; i < pLen; i++)
            if (pattern.charAt(i) != '*') return false;
        return true;
    }

    public static void main(String[] args) {
        _44WildcardMatching matching =new _44WildcardMatching("xaylmz","x?y*z");
        System.out.println(matching.isMatch());
    }
}
