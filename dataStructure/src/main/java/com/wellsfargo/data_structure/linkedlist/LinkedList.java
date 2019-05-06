package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LinkedList {
    private Node root;
    private Node last;
    private Node head;

    public void push(int data) {
        if (root != null)
            last = last.next = new Node(data);
        else
            root = last = new Node(data);
    }

    public void print(Node n) {
        while (n != null) {
            System.out.print(n);
            n = n.next;
        }
    }

    public void reverse(){
        reverse(root);
        print(head);
    }

    public Node reverse(Node n){
        if(n==null || n.next==null)
            return n;
        Node n1= reverse(n.next);
        if(head==null)
            head=n1;
        n1.next=n;
        n.next=null;
        return n;
    }

    public Node reverserIteratevily(){
        Node current =root;
        Node next ;
        while(current.next!=null){
            next = current.next;
            current.next = next.next;
            next.next = root;
            root = next;
        }
        return root;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "-";
        }
    }

    public static void main(String[] args) {
        LinkedList l =new LinkedList();
        l.push(10);
        l.push(20);
        l.push(30);
        l.print(l.reverserIteratevily());
    }
}
