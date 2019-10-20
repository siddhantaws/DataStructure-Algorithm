package com.amazon.question;

import java.util.*;

public class WordLadder {
    private String source;
    private String destination;
    private List<String> dictionary;

    public WordLadder(String source, String destination, List<String> dictionary) {
        this.source = source;
        this.destination = destination;
        this.dictionary = dictionary;
    }

    public int getNumberOfWordNeedToConvert(){
        Set<String> dictionaryOfWord =new HashSet<>(dictionary);
        int result=0;
        Queue<String> queue =new LinkedList<>();
        queue.add(source);
        result++;
        while (!queue.isEmpty()){
            String str =queue.poll();
            if(str.equals(destination))
                return result+1;
            char chArray[]=str.toCharArray();

            for(int i=0;i<chArray.length;i++){
                for(int j=0;j<26;j++){
                    char ch1=chArray[i];
                    chArray[i]= (char)('a'+j);
                    String s1= new String(chArray);
                    if(dictionaryOfWord.contains(s1) && !s1.equals(str)){
                        queue.offer(s1);
                        dictionaryOfWord.remove(s1);
                    }
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        WordLadder ladder =new WordLadder("hit", "cog",Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(ladder.getNumberOfWordNeedToConvert());
    }
}
