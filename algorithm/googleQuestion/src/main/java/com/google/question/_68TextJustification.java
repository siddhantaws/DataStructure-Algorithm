package com.google.question;

import java.util.ArrayList;
import java.util.List;

public class _68TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> justificationList = new ArrayList<>();
        for(int left =0;left<words.length;){
            int right = getRightPos(words ,left ,  maxWidth);
            justificationList.add(justify(left , right ,words , maxWidth));
            left = right+1;
        }
        return justificationList;
    }

    public int getRightPos(String[] word , int left , int maxWidth) {
        int right =left;
        int length =word[right++].length();
        while(right<word.length && length+1+word[right].length()<=maxWidth)
            length+= 1+word[right++].length();
        return right-1;
    }

    public String justify(int left , int right , String[] words ,int maxWidth) {
        if (left ==right)
            return words[left]+appendSpaces(maxWidth-words[left].length());
        int numSpaces = right-left ;
        int totalSpaces =  maxWidth - getLength(words , left , right );

        String spaces = appendSpaces(totalSpaces/numSpaces);
        int remainder = totalSpaces%numSpaces;
        StringBuilder sb =new StringBuilder();
        for(int i=left ;i<=right;i++){
            sb.append(words[i]).append(spaces).append(remainder-- >0 ? " " :"");
        }
        return padResult(sb.toString().trim() ,maxWidth );
    }

    public int getLength(String[]  s , int left , int right){
        int count =0;
        for(;left<=right;left++)
            count+=s[left].length();
        return count;
    }

    public String padResult(String result, int maxWidth) {
        return result + appendSpaces(maxWidth - result.length());
    }

    public String appendSpaces(int length) {
        return new String(new char[length]).replace("\0"," ");
    }

    public static void main(String[] args) {
        _68TextJustification justification =new _68TextJustification();
        justification.fullJustify(new String []{"This", "is", "an", "example", "of", "text", "justification."} , 16).stream().forEach(System.out::println);
    }
}
