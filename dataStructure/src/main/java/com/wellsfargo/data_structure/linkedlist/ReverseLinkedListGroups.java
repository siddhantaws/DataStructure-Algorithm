package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ReverseLinkedListGroups {

    private Node head;

    private Node tail;

    private int k ;

    public ReverseLinkedListGroups(int arr[],int k){
        for(int a:arr)
            add(a);
        this.k=k;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    private Node add(int a) {
        if (head ==null) {
            head = tail = new Node(a);
        } else {
            tail = tail.next = new Node(a);
        }
        return head;
    }

    public Node reverse(Node head , int a){

        Node curr =head , prev =null;
        while(curr!=null && a>0){
            Node n = curr.next;
            curr.next = prev;
            prev= curr;
            curr= n;
            a--;
        }
        if(curr!=null)
            head.next= reverse(curr ,k);
        return prev;
    }
}
