package com.wellsfargo.algo.pattern_matching;

import java.util.Map;

public class Boyer_Moore_Algo  extends PatternMatch {

    private int badCharacterArray[][] ;

    private int goodSuffixArray[] ;

    public Boyer_Moore_Algo(String text, String pattern) {
        super(text, pattern);
        this.badCharacterArray =new int[numberOfUniqueCharacter][patternlength];
        this.goodSuffixArray =new int[patternlength];
        init();
    }

    @Override
    public boolean match() {
        return false;
    }

    public int[][] getBadCharacterArray() {
        return badCharacterArray;
    }

    public int[] getGoodSuffixArray() {
        return goodSuffixArray;
    }

    public void init()
    {
        constructBadMatchTable();
        constructGoodSuffixTable();
    }

    private void constructBadMatchTable()
    {
        for(int i=0;i<numberOfUniqueCharacter;i++)
            for(int j=0;j<patternlength;j++)
                badCharacterArray[i][j] = Integer.MAX_VALUE;
        constructBadMatchTable(patternlength-1);
    }

    private void constructBadMatchTable(int index)
    {
       while (index>=0)
       {
           Character ch =pattern.charAt(index);
           int k=0 , charIndex =characterToIndexMap.get(ch);
           badCharacterArray[charIndex][index]=k;
           for(int i=index+1;( i<patternlength && badCharacterArray[charIndex][i]==Integer.MAX_VALUE);i++)
               badCharacterArray[charIndex][i]=++k;
           constructBadMatchTable(index-1);
           for(int i=index-1; i>=0 && badCharacterArray[charIndex][i]==Integer.MAX_VALUE;i--)
               badCharacterArray[charIndex][i]=i+1;
           index --;
       }
    }


    private void constructGoodSuffixTable()
    {

    }

    public static void main(String[] args) {
        PatternMatch patternMatch=new Boyer_Moore_Algo("AGTCTDSHDHDHD","ATGCTAGC");

    }
}
