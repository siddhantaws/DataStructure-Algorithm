package com.amazon.question;

public class WildcardMatching {
    private String str;

    private String pattern;

    public WildcardMatching(String str, String pattern) {
        this.str = str;
        this.pattern = pattern;
    }

    public boolean isMatch() {
        return isMatch(0,0,'/');
    }

    private boolean isMatch(int i , int j , char lastChar){
        if(i==str.length()  ||  j==pattern.length()) {
            if(j==pattern.length()-1 && pattern.charAt(j)=='*')
                return true;
            else if(i==str.length() &&  j==pattern.length())
                return true;
            else if(pattern.charAt(j)!='*')
                return false;
        }
        if(pattern.charAt(j)=='?')
            return isMatch(i+1,j+1, lastChar);
        if(pattern.charAt(j)=='*')
            return isMatch(i+1,j, lastChar) || isMatch(i,j+1, lastChar);
        if(pattern.charAt(j) == str.charAt(i)){
            if(i==str.length()-1 && j==pattern.length()-1)
                return true;
            return isMatch(i+1,j+1, lastChar);
        }
        else
            return false;
    }

    public static void main(String[] args) {
        WildcardMatching matching =new WildcardMatching("ho","ho**");
        System.out.println(matching.isMatch());
    }
}
