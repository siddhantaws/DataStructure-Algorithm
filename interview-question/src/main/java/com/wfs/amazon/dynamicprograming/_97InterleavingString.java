package com.wfs.amazon.dynamicprograming;

public class _97InterleavingString {
    private String s1;
    private String s2;
    private String s3;

    public _97InterleavingString(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public boolean isInterleave() {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        boolean dpArray [][]= new boolean[s2.length()+1][s1.length()+1];
        dpArray[0][0] =true;
        for(int i=1;i<dpArray[0].length;i++)
            dpArray[0][i] = s1.charAt(i-1)==s3.charAt(i-1) ? true : false;
        for(int i=1;i<dpArray.length;i++)
            dpArray[i][0] = s2.charAt(i-1)==s3.charAt(i-1) ? true : false;

        for(int i=1;i<s2.length();i++)
            for(int j=1;j<s1.length();j++){
                if((s3.charAt(i+j-1) ==s1.charAt(j-1)) || (s3.charAt(i+j-1) ==s2.charAt(i-1)) ){
                    if(s3.charAt(i+j-1) ==s1.charAt(j-1))
                        dpArray[i][j] =dpArray[i][j-1];
                    else
                        dpArray[i][j] =dpArray[i-1][j];
                }else{
                    dpArray[i][j] =false;
                }
            }

        return dpArray[s2.length()][s1.length()];
    }

    public static void main(String[] args) {
        _97InterleavingString interleavingString =new _97InterleavingString("aabcc","dbbca","aadbbcbcac");
        System.out.println(interleavingString.isInterleave());
    }
}
