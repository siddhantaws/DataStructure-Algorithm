package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class IterativelyReverseLinkedListUsing2Pointers {

    private Node head,tail ;

    public IterativelyReverseLinkedListUsing2Pointers(int arr[]){
        for(int a:arr)
            add(a);
    }

    private Node add(int a) {
        if (head ==null) {
            head = tail = new Node(a);
        } else {
            tail = tail.next = new Node(a);
        }
        return head;
    }


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
       public String toString() {
           return data+"";
       }
   }

    public Node reverse() {
        Node current = head;
        Node next;
        while (current.next != null) {
            next = current.next;
            current.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }


    public static void main(String[] args) {
        IterativelyReverseLinkedListUsing2Pointers using2Pointers =new IterativelyReverseLinkedListUsing2Pointers(new int[]{10,20,30,40});
        using2Pointers.reverse();
    }
}
