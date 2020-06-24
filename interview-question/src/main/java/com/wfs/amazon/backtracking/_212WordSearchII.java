package com.wfs.amazon.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _212WordSearchII {


    public List<String> findWords(char[][] board, String[] words) {
        Tries tries=constructDictionary(new Tries() , words);
        List<String> listOfMatchedWords = new ArrayList<>();
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                findMatch(tries.head ,i,j,listOfMatchedWords);
        return listOfMatchedWords;
    }

    private void findMatch(Node head ,int i, int j ,List<String> listOfMatchedWords ){

    }

    private Tries constructDictionary(Tries tries, String[] words){
        for(String word:words)
            tries.add(word.toCharArray());
        return tries;
    }

    static class Tries {

        private Node head = new Node();

        public Node getTrieHead(){
            return head;
        }

        public void add(char chArr[]){
            Node curr =head;int i =0;
            while(i<chArr.length){
                if(!curr.getMapOfCharacter2Nodes().containsKey(chArr[i]))
                    curr.getMapOfCharacter2Nodes().put(chArr[i], new Node());
                curr = curr.getMapOfCharacter2Nodes().get(chArr[i++]);
            }
            curr.setEnd(true);
        }


    }
    static class Node{
        Map<Character , Node> mapOfCharacter2Nodes =new HashMap<>();

        boolean isEnd =false;

        public Map<Character , Node> getMapOfCharacter2Nodes(){
            return this.mapOfCharacter2Nodes;
        }

        public void setEnd(boolean isEnd){
            this.isEnd =isEnd;
        }

        public boolean getIsEnd(){
            return isEnd;
        }
    }
}
