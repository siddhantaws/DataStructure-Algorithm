package com.wellsfargo.data_structure.heap;

public class PriorityQueueUsingDoublyLinkedList<E extends Comparable> {

    static Node<? extends Comparable> front, rear;

    public boolean isEmpty() {
        return front == null;
    }

    public E peek() {
        return (E) front.data;
    }

    // Removes the element with the
    // least priority value form the list
    E pop(Node fr, Node rr) {
        Node temp = fr;
        Comparable res = temp.data;
        fr = fr.next;
        if (fr == null)
            rr = null;
        return (E) res;
    }

    void push(E n) {
        Node news = new Node(n);
        // If linked list is empty
        if (front == null) {
            front = rear = news;
        } else {
            if (front.data.compareTo(n) >= 0) {// If p is less than or equal front node's priority, then insert at the front.
                news.next = front;
                front.prev = news.next;
                front = news;
            } else if (n.compareTo(rear.data) > 0) { // If p is more rear node's priority, then insert after the rear.
                news.next = null;
                rear.next = news;
                news.prev = rear.next;
                rear = news;
            } else {// Handle other cases  // Find position where we need to insert.
                Node start = front.next;
                while (start.data.compareTo(news.data) > 0){
                    if(start.next==null)
                        break;
                        start = start.next;
                }

                start.prev.next = news;
                news.next = start.prev;
                news.prev = start.prev.next;
                start.prev = news.next;
            }
        }
    }

    static class Node<E extends Comparable> {
        E data;
        Node prev, next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data->" + data;
        }
    }

    public static void main(String[] args) {
        PriorityQueueUsingDoublyLinkedList<Integer> linkedList =new PriorityQueueUsingDoublyLinkedList();
        linkedList.push(10);
        linkedList.push(5);
        linkedList.push(7);
        linkedList.push(8);
        linkedList.push(2);
    }
}
