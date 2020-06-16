package com.wfs.amazon.greedy;

import java.util.HashMap;
import java.util.Map;

public class _316_Remove_Duplicate_Letters {

    private String currentString;

    public _316_Remove_Duplicate_Letters(String currentString){
        this.currentString=currentString;
    }

    public static void main(String[] args) {
        _316_Remove_Duplicate_Letters duplicate_letters =new _316_Remove_Duplicate_Letters("bcabc");
        System.out.println(duplicate_letters.removeDuplicateLetters());
    }

    public String removeDuplicateLetters() {
        Map<Character,Node> mapOfCharacter2Nodes =new HashMap<>();
        Node linkedNodes=null;Node headNodes=null;
        for(int i=0;i<currentString.toCharArray().length;i++){
            if(mapOfCharacter2Nodes.containsKey(currentString.toCharArray()[i]) && mapOfCharacter2Nodes.get(currentString.toCharArray()[i]).next!=null &&
                    mapOfCharacter2Nodes.get(currentString.toCharArray()[i]).compareTo(mapOfCharacter2Nodes.get(currentString.toCharArray()[i]).next)> 0){
                Node currentNode = mapOfCharacter2Nodes.get(currentString.toCharArray()[i]);
                currentNode.prev .next= currentNode.next;
                currentNode.next.prev =  currentNode.prev ;
                currentNode.prev =linkedNodes;linkedNodes.next=currentNode;
                linkedNodes = currentNode;
            }else if(mapOfCharacter2Nodes.containsKey(currentString.toCharArray()[i])){
                continue;
            } else {
                Node node = new Node(currentString.toCharArray()[i]);
                mapOfCharacter2Nodes.put(currentString.toCharArray()[i] ,node  );
                if(linkedNodes==null)
                    headNodes =linkedNodes =node ;
                else {
                    node.prev =linkedNodes;
                    linkedNodes =  linkedNodes.next = node;
                }
            }
        }
        StringBuilder sb =new StringBuilder();
        while(headNodes!=null){
            sb.append(headNodes.character.toString());
            headNodes=headNodes.next;
        }
        return sb.toString();
    }

    class Node implements Comparable<Node>{
        Character character;

        Node next ;

        Node prev ;

        Node(Character character){
            this.character =character;
        }

        public void setNext(Node nextNode){
            this.next=nextNode;
        }

        public void setPrev(Node nextNode){
            this.next=nextNode;
        }

        public int compareTo(Node n){
            return this.character.compareTo(n.character);
        }
    }

}
