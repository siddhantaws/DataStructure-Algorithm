package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MergeSortLinkedList {

    private Node head;

    public Node split(Node n){
        Node slow =n , fast =n;
        while(slow.next!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next.next=null;
        return slow.next ;
    }

    public Node mergeSort(Node n){
        if(n==null || n.next==null)
            return n;
        Node node =split(n);
        Node left =mergeSort(n);
        Node right =mergeSort(node);
        return merge(left,right);
    }


    public Node merge(Node n1, Node n2){

        while(n1!=null && n2!=null){

        }
        if(n1!=null ){
            n2.next =n1;
            return n2;
        }
        if(n2!=null ){
            n1.next =n2;
            return n1;
        }
        return n1==null ? n2 : n1 ;
    }

    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data=data;
        }
        @Override
        public String toString() {
            return data+"";
        }
    }
}
