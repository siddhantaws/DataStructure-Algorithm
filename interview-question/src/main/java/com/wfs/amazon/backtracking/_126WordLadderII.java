package com.wfs.amazon.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class _126WordLadderII {
    private String beginWord;

    private String endWord;

    private List<String> wordList;

    private Set<String> setsOfWords ;

    private List<List<String>> returnList;

    private char charr[];

    public _126WordLadderII(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        this.wordList = wordList;
        this.setsOfWords =new HashSet<>();
        this.returnList =new ArrayList<>();
        this.setsOfWords.addAll(wordList);
        this.charr  =new char[beginWord.length()];
    }

    public List<List<String>> findLadders() {
        Queue<String> stringQueue =new LinkedList<>();
        stringQueue.add(beginWord);
        return findLadders(beginWord,endWord ,stringQueue );
    }

    private List<List<String>> findLadders(String beginWord, String endWord , Queue<String> stringQueue) {
        if(beginWord.equals(endWord)){
            returnList.add(getAllWords(stringQueue));
            return returnList;
        }
        if(setsOfWords.isEmpty())
            return returnList;
        System.arraycopy(beginWord.toCharArray() , 0 ,charr , 0,beginWord.length() );
        for(int j=0;j<beginWord.length();j++){
            for(int i=0;i<26;i++){
                char currChar = charr[j];
                charr[j]=(char)('a'+i);
                String newWord = new String(charr);
                if(setsOfWords.contains(newWord)){
                    setsOfWords.remove(newWord);
                    stringQueue.add(newWord);
                    findLadders(newWord , endWord ,stringQueue );
                    ((LinkedList)stringQueue).removeLast();
                    setsOfWords.add(newWord);
                }
                charr[j] =currChar;
            }
        }

        return returnList;
    }

    private List<String> getAllWords(Queue<String> stringQueue){
        return stringQueue.stream().collect(Collectors.toList());
    }


    public static void main(String[] args) {
        _126WordLadderII ladderII =new _126WordLadderII("hit","cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(ladderII.findLadders());
    }
}
