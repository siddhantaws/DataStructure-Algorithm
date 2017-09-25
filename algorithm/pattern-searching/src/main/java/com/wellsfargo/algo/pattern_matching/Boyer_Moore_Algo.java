package com.wellsfargo.algo.pattern_matching;

public class Boyer_Moore_Algo  extends PatternMatch {

    private int badCharacterArray[][] ;

    private int goodSuffixArray[] ;

    public Boyer_Moore_Algo(String text, String pattern) {
        super(text, pattern);
        this.badCharacterArray =new int[patternlength][numberOfUniqueCharacter];
        this.goodSuffixArray =new int[patternlength];
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

    }

    private void constructGoodSuffixTable()
    {

    }
}
