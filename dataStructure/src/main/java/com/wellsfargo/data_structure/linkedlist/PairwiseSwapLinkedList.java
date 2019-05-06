package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PairwiseSwapLinkedList {

    private Node head;


    public Node pairWisereverse(Node node){
        if(node==null || node.next==null)
            return node;
        Node nextElement= node.next.next;
        Node newHead =node.next;
        node.next.next=node;
        node.next =  pairWisereverse(nextElement);
        return newHead;
    }

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
        }
        @Override
        public String toString() {
            return data+"";
        }
    }

    public void print(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }

    }
    public static void main(String[] args) {
        PairwiseSwapLinkedList swapLinkedList =new PairwiseSwapLinkedList();
        swapLinkedList.head =new Node(10);
        swapLinkedList.head.next =new Node(20);
        swapLinkedList.head.next.next =new Node(30);
        swapLinkedList.head.next.next.next =new Node(40);
        swapLinkedList.head.next.next.next.next =new Node(50);
        swapLinkedList. print(swapLinkedList.pairWisereverse(swapLinkedList.head));

    }
}
