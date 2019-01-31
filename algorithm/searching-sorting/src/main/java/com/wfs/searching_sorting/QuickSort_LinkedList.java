package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class QuickSort_LinkedList {

    private Node head;

    private Node tail;

    Node newHead = null, newEnd = null;

    public QuickSort_LinkedList(int arr[]){
        for(int a:arr)
            add(a);
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

    private Node getTail(Node cur) {
        while (cur != null && cur.next != null)
            cur = cur.next;
        return cur;
    }

    // Partitions the list taking the last element as the pivot
    private Node partition(Node head, Node end) {
        Node pivot = end;
        Node prev = null, cur = head, tail = pivot;
        // During partition, both the head and end of the list might change
        // which is updated in the newHead and newEnd variables
        while (cur!=null && cur != pivot) {
            if (cur!=null && cur.data
                    < pivot.data) {
                // First node that has a value less than the pivot - becomes the new head
                if (newHead == null)
                    newHead = cur;
                prev = cur;
                cur = cur.next;
            } else {// If cur node is greater than pivot
                // Move cur node to next of tail, and change tail
                if (prev != null)
                    prev.next = cur.next;
                Node tmp = cur.next;
                cur.next = null;
                tail.next = cur;
                tail = cur;
                cur = tmp;
            }
        }
        // If the pivot data is the smallest element in the current list, pivot becomes the head
        if (newHead == null)
            newHead = pivot;
        // Update newEnd to the current last node
        newEnd = tail;
        // Return the pivot node
        return pivot;
    }

    //here the sorting happens exclusive of the end node
    Node quickSortRecur(Node head, Node end) {
        // base condition
        if (head == null || head == end)
            return head;
        newHead = null;  newEnd = null;
        // Partition the list, newHead and newEnd will be updated by the partition function
        Node pivot = partition(head, end);
        // If pivot is the smallest element - no need to recur for the left part.
        if (newHead != pivot) {
            // Set the node before the pivot node as NULL
            Node tmp = newHead;
            while (tmp.next != pivot)
                tmp = tmp.next;
            tmp.next = null;
            // Recur for the list before pivot
            newHead = quickSortRecur(newHead, tmp);
            // Change next of last node of the left half to pivot
            tmp = getTail(newHead);
            tmp.next = pivot;
        }
        // Recur for the list after the pivot element
        pivot.next = quickSortRecur(pivot.next, newEnd);
        return newHead;
    }

    // The main function for quick sort. This is a wrapper over recursive function quickSortRecur()
    void quickSort(Node headRef) {
        head = headRef = quickSortRecur(headRef, getTail(headRef));
        print();
        return;
    }

    private void print(){
        Node n =head;
        while(n!=null){
            System.out.println(n.data);
            n= n.next;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private Node add(int a) {
        if (head ==null) {
            head = tail = new Node(a);
        } else {
            tail = tail.next = new Node(a);
        }
        return head;
    }

    public static void main(String[] args) {
        QuickSort_LinkedList  quickSortLinkedList =new QuickSort_LinkedList(new int[]{10,5,17,12,15,30,25});
        quickSortLinkedList.quickSort(quickSortLinkedList.head);
    }
}
