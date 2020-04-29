/*
package com.google.question;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    private String str;

    private int count =0;

    private Map<Integer , Integer> integerMap;

    public DecodeWays(String str) {
        this.str = str;
        this.integerMap =new HashMap<>();
    }

    public int numDecodings() {
        numDecodings(0,1);
        return count;
    }

    private void numDecodings(int i , int count){
        if(i>str.length() || Integer.valueOf(str.substring(i,i+count))>26)
            return;
        else{
            if(integerMap.containsKey(i)){
                count = count+integerMap.get(i);
                return;
            }else{
                numDecodings(i+1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
*/
