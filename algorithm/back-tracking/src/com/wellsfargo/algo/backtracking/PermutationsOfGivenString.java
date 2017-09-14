package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfGivenString {
    private String word ;
    private List<String> stringList;

    public PermutationsOfGivenString(String word) {
        this.word = word;
        stringList =new ArrayList<>();
    }

    public List<String> getAllPermutation()
    {
        return getAllPermutation(word);
    }

    private List<String> getAllPermutation(String word)
    {
         getAllPermutation(word.toCharArray() , 0 , word.toCharArray().length-1);
         return stringList;
    }

    private void getAllPermutation(char array[] , int source ,int dest )
    {
        int temp =source;
        if(source==dest)
            stringList.add(new String(array));
        else
            while(temp<=dest)
            {
                array = swap(array ,source ,temp  );
                getAllPermutation(array , source+1 , dest);
                array = swap(array , temp ,source);
            }
    }

    private char [] swap(char array[] ,int source , int dest)
    {
        char temp =array[dest];
        array[dest] =array[source];
        array[source] =temp;
        return array;
    }

    public static void main(String[] args) {
        PermutationsOfGivenString permutations =new PermutationsOfGivenString("ABC");
        permutations.getAllPermutation();
    }
}
