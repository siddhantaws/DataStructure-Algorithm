package com.wellsfargo.data_structure;

import java.util.HashMap;
import java.util.Map;

public class Tries {

    private Node rootNode;

    public Tries() {
        rootNode=new Node();
    }

    public void add(String word)
    {
        add(word.toCharArray()) ;
    }

    private void add(char []word )
    {
        Node currNode= rootNode;
        int index =0;
        while (index<word.length)
        {
            if(!currNode.getCharacterNodeMap().containsKey(word[index]))
                currNode.getCharacterNodeMap().put(word[index] , new Node());
            currNode =currNode.getCharacterNodeMap().get(word[index++]);
        }
        currNode.setEnd(true);
    }

    public void remove(String word)
    {
        remove(word.toCharArray() , 0 , rootNode , null);
    }

    private void remove(char []word ,int index , Node currNode , Node prevNode)
    {
        if(index<word.length)
        {
            if(currNode.getCharacterNodeMap().containsKey(word[index]))
            {
                remove(word , index+1 , currNode.getCharacterNodeMap().get(word[index]) , currNode );
                if(!currNode.isEnd() && currNode.characterNodeMap.size()==0 && index>0)
                    prevNode.getCharacterNodeMap().remove(word[index-1]);
            }else
            {
                System.out.println("String not present ");
                return ;
            }
        }else if(index==word.length)
        {
            if(currNode.characterNodeMap.size()==0)
                prevNode.getCharacterNodeMap().remove(word[index-1]);
            else
                currNode.setEnd(false);
        }
    }

    class Node{
        private boolean isEnd;

        private Map<Character , Node> characterNodeMap=new HashMap<>();

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public Map<Character, Node> getCharacterNodeMap() {
            return characterNodeMap;
        }

        public void setCharacterNodeMap(Map<Character, Node> characterNodeMap) {
            this.characterNodeMap = characterNodeMap;
        }
    }

    public static void main(String[] args) {
        Tries  tries=new Tries();
        tries.add("Cars");tries.add("Cat");tries.add("Cats");
        tries.add("Car");tries.remove("Carer");tries.remove("Cars");tries.remove("Cats");tries.remove("Cat");
        System.out.println(tries);
    }

}
