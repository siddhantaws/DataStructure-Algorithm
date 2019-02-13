package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MergeKSortedLinkedLists {

    private Node arr[];

    private int last;

    public MergeKSortedLinkedLists(Node[] arr) {
        this.arr = arr;
        this.last=arr.length-1;
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
    /* Function to print nodes in a given linked list */
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
    }
    /* Takes two lists sorted in increasing order, and merge their nodes together to make one big sorted list. Below
    function takes O(Log n) extra space for recursive calls, but it can be easily modified to work with same time and
    O(1) extra space  */
    public Node SortedMerge(Node a, Node b) {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        else if(b == null)
            return a;
        /* Pick either a or b, and recur */
        if(a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return result;
    }
    // The main function that takes an array of lists arr[0..last] and generates the sorted output
    public Node mergeKLists() {
        while (last != 0) {// repeat until only one list is left
            int i = 0, j = last;
            while (i < j) {// (i, j) forms a pair
                // merge List i with List j and store // merged list in List i
                arr[i] = SortedMerge(arr[i], arr[j]);
                // consider next pair
                i++; j--;
                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list
        Node arr[]=new Node[k];
        arr[0] = new Node(1); arr[0].next = new Node(3); arr[0].next.next = new Node(5);arr[0].next.next.next = new Node(7);
        arr[1] = new Node(2);arr[1].next = new Node(4);arr[1].next.next = new Node(6);arr[1].next.next.next = new Node(8);
        arr[2] = new Node(0);arr[2].next = new Node(9);arr[2].next.next = new Node(10);arr[2].next.next.next = new Node(11);
        MergeKSortedLinkedLists sortedLinkedLists =new MergeKSortedLinkedLists(arr);
        Node node = sortedLinkedLists.mergeKLists();
        sortedLinkedLists.printList(node);
    }

}
