package com.wfs.amazon.dynamicprograming;


public class _943FindShortestSuperstring {
    private String str[];

    public _943FindShortestSuperstring(String[] str) {
        this.str = str;
    }

    public String shortestSuperstring() {
        return shortestSuperstring(0 , str.length-1);
    }

    private String shortestSuperstring(int l, int r) {
        if(l==r)
            return str[l];
        int mid =l +(r-l)/2;
        String left = shortestSuperstring(l,mid);
        String right = shortestSuperstring(mid+1,r);
        return getShottestSuperString(left, right);
    }

    private String getShottestSuperString(String s1, String s2 ){
        int dpArray[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<s1.length();i++)
            for(int j=1;j<s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dpArray[i][j]= 1+dpArray[i-1][j-1];
                else
                    dpArray[i][j]= Math.max(Math.max(dpArray[i-1][j] ,dpArray[i][j-1] ) , dpArray[i-1][j-1]);
            }
        return getShottestSuperString(dpArray, s1.length()+1, s2.length()+1 , s1,s2 );
    }

    private String getShottestSuperString(int dpArray[][], int m,int n,String s1, String s2 ){
        if(m==0 && n==0)
            return "";
        if(m==0 || n==0 ){
            if(m==0){
                return s2.substring(0,n);
            }else{
                return s1.substring(0,m);
            }
        }
        if(s1.charAt(m-1)== s2.charAt(n-1))
            return s1.charAt(m-1)+""+getShottestSuperString(dpArray, m-1,n-1 , s1,s2);
        else if(dpArray[m-1][n]>dpArray[m][n-1])
            return s1.charAt(m-1)+""+ getShottestSuperString(dpArray , m-1 , n ,s1,s2);
        else
            return s1.charAt(n-1)+""+ getShottestSuperString(dpArray , m , n-1 ,s1,s2);
    }
}
