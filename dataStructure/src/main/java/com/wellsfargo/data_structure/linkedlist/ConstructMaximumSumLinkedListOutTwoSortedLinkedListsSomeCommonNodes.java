package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ConstructMaximumSumLinkedListOutTwoSortedLinkedListsSomeCommonNodes {

    private Node root1;

    private Node root2;

    public ConstructMaximumSumLinkedListOutTwoSortedLinkedListsSomeCommonNodes(Node root1, Node root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    public void finalMaxSumList() {// Method to adjust pointers and print final list
        Node result = null;
        /* assigning pre and cur to head of the linked list */
        Node pre1 = root1, curr1 = root1;
        Node pre2 = root2, curr2 = root2;
        /* Till either of current pointers is not null execute the loop */
        while (curr1 != null || curr2 != null) {
            // Keeping 2 local variables at the start of every loop run to keep track of the sum between pre and cur reference elements.
            int sum1 = 0, sum2 = 0;
            // Calculating sum by traversing the nodes of linked list as the merging of two linked list.  The loop stops at a common node
            while (curr1 != null && curr2 != null && curr1.data != curr2.data) {
                if (curr1.data<curr2.data) {
                    sum1 += curr1.data;
                    curr1 = curr1.next;
                } else {
                    sum2 += curr2.data;
                    curr2 = curr2.next;
                }
            }
            // If either of current pointers becomes null  carry on the sum calculation for other one.
            if (curr1 == null) {
                while (curr2 != null) {
                    sum2 += curr2.data;
                    curr2 = curr2.next;
                }
            }
            if (curr2 == null) {
                while(curr1 != null) {
                    sum1 += curr1.data;
                    curr1 = curr1.next;
                }
            }
            // First time adjustment of resultant head based on the maximum sum.
            if (pre1 == root1 && pre2 == root2)
                result = (sum1 > sum2) ? pre1 : pre2;
                // If pre1 and pre2 don't contain the head refernces of lists adjust the next pointers of previous pointers.
            else {
                if (sum1 > sum2)
                    pre2.next = pre1.next;
                else
                    pre1.next = pre2.next;
            }
            // Adjusting previous pointers
            pre1 = curr1;
            pre2 = curr2;
            // If curr1 is not NULL move to the next.
            if (curr1 != null)
                curr1 = curr1.next;
            // If curr2 is not NULL move to the next.
            if (curr2 != null)
                curr2 = curr2.next;
        }
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n =new Node(120);
        n.next = new Node(110);
        n.next.next= new Node(90);
        n.next.next.next= new Node(30);
        n.next.next.next.next= new Node(3);
        n.next.next.next.next.next= new Node(1);
        Node n1 =new Node(130);
        n1.next = new Node(120);
        n1.next.next= new Node(100);
        n1.next.next.next= new Node(90);
        n1.next.next.next.next= new Node(32);
        n1.next.next.next.next.next= new Node(12);
        n1.next.next.next.next.next.next= new Node(3);
        n1.next.next.next.next.next.next.next= new Node(0);

        ConstructMaximumSumLinkedListOutTwoSortedLinkedListsSomeCommonNodes outTwoSortedLinkedListsSomeCommonNodes =new ConstructMaximumSumLinkedListOutTwoSortedLinkedListsSomeCommonNodes(n,n1);
        outTwoSortedLinkedListsSomeCommonNodes.finalMaxSumList();
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

}
