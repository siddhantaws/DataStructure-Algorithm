package com.amazon.question;

public class FlattenMultilevelDoublyLinkedList {

    private Node node;

    public FlattenMultilevelDoublyLinkedList(Node node) {
        this.node = node;
    }

    public Node flatten(){
        Node n = flatten(node);
        print(n);
        return n;
    }

    private void print(Node n){
        while(n!=null){
            System.out.print(n.val+" ");
            n=n.next;
        }
    }

    public Node flatten(Node head) {
        if(head==null)
            return null;
        else{
            Node R = head.next;
            Node down = flatten(head.child);
            flatten(R);
            Node prev = down ==null ? head : down;
            head.next=down;
            while(down!=null){
                prev =down;
                down =down.next;
            }
            prev.next =R;
            return head;
        }
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
    }

    public static void main(String[] args) {
        Node root =new Node(15);root.next=new Node(17);root.next.next =new Node(19);root.next.child=new Node(18);
        root.child =new Node(16);root.child.next =new Node(20);root.child.next.next =new Node(21);root.child.next.next.next =new Node(22);
        root.child.child=new Node(23);root.child.child.next=new Node(24);
        FlattenMultilevelDoublyLinkedList linkedList =new FlattenMultilevelDoublyLinkedList(root);
        linkedList.flatten();
    }
}
