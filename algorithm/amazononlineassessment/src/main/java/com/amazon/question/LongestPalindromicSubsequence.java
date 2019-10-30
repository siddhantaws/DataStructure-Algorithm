package com.amazon.question;

public class LongestPalindromicSubsequence {

    private String str;

    private int arr[][];

    public LongestPalindromicSubsequence(String str) {
        this.str = str;
        this.arr = new int[str.length()][str.length()];
    }

    public int longestPalindromeSubseq() {
        for(int i=0;i<arr.length;i++)
          arr[i][i]=1;
        int l=2;
        while(l<=arr.length){
            for(int i=0;i+l-1<arr.length;i++){
                if(str.charAt(i)==str.charAt(i+l-1)){
                    if(l==2)
                        arr[i][i+l-1]=2;
                    else
                        arr[i][i+l-1]=2 + arr[i+1][i+l-2];
                }else{
                    if(l==2)
                        arr[i][i+l-1]=1;
                    else
                        arr[i][i+l-1]= Math.max(arr[i+1][i+l-1],arr[i][i+l-2]);
                }
            }
            l++;
        }
        return arr[0][arr.length-1];
    }


    public static void main(String[] args) {
        LongestPalindromicSubsequence palindromicSubsequence =new LongestPalindromicSubsequence("cbbd");
        System.out.println(palindromicSubsequence.longestPalindromeSubseq());
    }
}
