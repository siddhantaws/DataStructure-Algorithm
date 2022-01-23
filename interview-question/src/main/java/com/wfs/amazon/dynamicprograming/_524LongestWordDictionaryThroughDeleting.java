package com.wfs.amazon.dynamicprograming;

import java.util.Arrays;
import java.util.List;

public class _524LongestWordDictionaryThroughDeleting {
    private String str;

    private List<String> stringList;

    private Node head ;

    public _524LongestWordDictionaryThroughDeleting(String str, List<String> stringList) {
        this.str = str;
        this.stringList = stringList;
        this.head =new Node('/');
        init();
    }

    private void init(){
        Node root =null;
        for(String str:stringList){
            root =head;
            for(int i=0;i<str.length();i++){
                root = root.addOrGet(str.charAt(i));
            }
            root.setEnd(true);
        }
    }

    public String findLongestWord() {
        return findLongestWord(0,head);
    }

    private String findLongestWord(int i ,Node root ) {
        if(i>=str.length())
            return "";
        if(root.isEnd)
            return "";
        String firstMatchingStr ="";String secondMatchingStr ="";
        if(root.get(str.charAt(i))!=null && str.charAt(i)==root.get(str.charAt(i)).character)
            firstMatchingStr = str.charAt(i)+""+findLongestWord(i+1 , root.get(str.charAt(i)));
        secondMatchingStr = findLongestWord(i+1 , root);
        if(firstMatchingStr.length()==0 || secondMatchingStr.length()==0)
            return firstMatchingStr.length()==0 ? secondMatchingStr : firstMatchingStr;
        return firstMatchingStr.length()>secondMatchingStr.length() ? firstMatchingStr : secondMatchingStr;
    }

    public static void main(String[] args) {
        _524LongestWordDictionaryThroughDeleting wordDictionaryThroughDeleting =new _524LongestWordDictionaryThroughDeleting("abpcplea", Arrays.asList(new String[]{"ale","apple","monkey","plea"}));
        System.out.println(wordDictionaryThroughDeleting.findLongestWord());
    }
    static class Node{

        private boolean isEnd;
        private char character;
        private Node[] nodes;

        public Node(char character) {
            this.character = character;
            this.nodes = new Node[26];
        }

        public Node addOrGet(char ch){
            if(nodes[ch-'a']==null)
                nodes[ch-'a'] =new Node(ch);
            return nodes[ch-'a'];
        }

        public Node get(char ch){
            return nodes[ch-'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

        public Node[] getNodes() {
            return nodes;
        }

    }
}
