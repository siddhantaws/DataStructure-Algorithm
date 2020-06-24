package com.wfs.amazon.greedy;

public class _5LongestPalindromicSubstring {
    private String str;

    public _5LongestPalindromicSubstring(String str) {
        this.str = str;
    }

    public String longestPalindrom(){
        int length = 1; char stringArray[] = str.toCharArray();
        int start =-1,end =-1;int maxLength=1;
        for (int i=0;i<stringArray.length;i++) {
            int oddLengthPalimdrom = palindromLength(i,i,stringArray);
            int evenLengthPalimdrom = palindromLength(i,i+1,stringArray);
            int currentMaxLength = Math.max(oddLengthPalimdrom , evenLengthPalimdrom);
            if(currentMaxLength >1 && currentMaxLength>maxLength ){
                start = i - (maxLength-1)/2;
                end = start + maxLength-1;
                maxLength = currentMaxLength;
            }
        }
        return maxLength>1 ?  str.substring(start,end+1) : "";
    }

    private int palindromLength(int i, int j ,char stringArray[]){
        while (i>=0 && j<stringArray.length && stringArray[i]==stringArray[j]){
            i--;j++;
        }
        return j-i+1;
    }
}
