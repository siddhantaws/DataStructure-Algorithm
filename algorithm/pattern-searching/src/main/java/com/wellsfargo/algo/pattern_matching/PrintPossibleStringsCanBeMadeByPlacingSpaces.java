package com.wellsfargo.algo.pattern_matching;

import java.util.ArrayList;
import java.util.List;

public class PrintPossibleStringsCanBeMadeByPlacingSpaces {

    private String text ;

    private List<String> allCombString;

    private int text_length;

    public PrintPossibleStringsCanBeMadeByPlacingSpaces(String text) {
        this.text = text;
        this.allCombString=new ArrayList<>();
        this.text_length=text.length();
    }

    public List<String> getAllCombString()
    {
        for(int i=1;i<text_length;i++)
        {
            getAllCombString(i);
        }
        return allCombString;
    }

    public void getAllCombString(int i)
    {
        for(;i<text_length-2;i++);

    }
}
