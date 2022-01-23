package com.wfs.amazon.tree;

import java.util.ArrayList;
import java.util.List;

public class _472ConcatenatedWords {
    private String[] words;

    public _472ConcatenatedWords(String[] words) {
        this.words = words;
    }

    public List<String> findAllConcatenatedWordsInADict() {
        List<String> listOfStrings =new ArrayList<>();
        Node head = new Node('/');
        for(String str:words){
            Node curr =head;
            for(char ch :str.toCharArray()){
                curr =curr.add(ch);
            }
            curr.setIsEnd(true);
        }
        for(String str:words){
            Node curr =head;int currLength=0;Node headNode =head;
            char carrays []=str.toCharArray();
            boolean charEndFound =false;
            for(int i=0;i<str.length();i++){
                currLength++;
                curr =curr.get(carrays[i]);
                if(!charEndFound)
                    continue;
                if(curr.getIsEnd()){
                    headNode = head;
                    continue;
                }
                if(headNode.get(curr.ch)!=null)
                    headNode = headNode.get(curr.ch);
                else{
                    break;
                }
            }
            if(charEndFound && curr.getIsEnd() && headNode.getIsEnd())
                listOfStrings.add(str);
        }
        return listOfStrings ;
    }
    static class Node{
        boolean isEnd =false;
        char ch;
        Node nodes[] =new Node[26];

        Node (char ch){
            this.ch=ch;
        }

        public Node get(char ch){
            return nodes[ch-'a'];
        }

        public Node add(char ch){
            if(nodes[ch-'a']==null)
                nodes[ch-'a'] =new Node(ch);
            return nodes[ch-'a'];
        }

        public void setIsEnd(boolean flag){
            this.isEnd =flag;
        }

        public boolean getIsEnd(){
            return isEnd;
        }
        public char getChar(){
            return ch;
        }
    }

    public static void main(String[] args) {
        String str [] = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        _472ConcatenatedWords words1 =new _472ConcatenatedWords(str);
        for(String strs :words1.findAllConcatenatedWordsInADict()){
            System.out.println(strs);
        }
    }
}
