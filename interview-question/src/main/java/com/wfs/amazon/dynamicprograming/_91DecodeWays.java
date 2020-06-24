package com.wfs.amazon.dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class _91DecodeWays {
    private String str;

    private Map<Integer,Integer> mapOfIndexesToCount;

    public _91DecodeWays(String str) {
        this.str = str;
        this.mapOfIndexesToCount =new HashMap<>();
    }

    public int numDecodings() {
        return numDecodings(0);
    }

    private int numDecodings(int i){
        if(i> str.length())
            return 0;

        if(i== str.length())
            return 1;
        if(str.charAt(i)=='0')
            return 0;
        if(i==str.length()-1)
            return 1;
        if(mapOfIndexesToCount.containsKey(i))
            return mapOfIndexesToCount.get(i);
        int totalCount =  numDecodings(i+1);
        if(Integer.parseInt(str.substring(i,i+2))<=26)
            totalCount+=numDecodings(i+2);
        mapOfIndexesToCount.put(i,totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        _91DecodeWays decodeWays =new _91DecodeWays("2126");
        System.out.println(decodeWays.numDecodings());
    }
}
