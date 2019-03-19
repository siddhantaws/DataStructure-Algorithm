package com.wellsfargo.data_structure.linkedlist;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LengthLongestPalindromeInLinkedList {

    private Node head;

    public LengthLongestPalindromeInLinkedList(Node head) {
        this.head = head;
    }

    static class Node {//structure of the linked list
        int data;
        Node next;

        @Override
        public String toString() {
            StringBuffer sb=new StringBuffer();
            sb.append(data);
            Node t1=next;
            while(t1!=null) {
                sb.append("=>"+t1.data);
                t1=t1.next;
            }
            return sb.toString();
        }
    }

    private int countCommon(Node a, Node b) {// function for counting the common elements
        printNode(a,b);
        int count = 0;
        // loop to count coomon in the list starting from node a and b
        for (; a != null && b != null; a = a.next, b = b.next)
            // increment the count for same values
            if (a.data == b.data)
                ++count;
            else
                break;
        return count;
    }

    public int maxPalindrome(){
        return  maxPalindrome(head);
    }
    // Returns length of the longest palindrome sublist in given list
    private  int maxPalindrome(Node head) {

        int result = 0;
        Node prev = null, curr = head;
        while (curr != null) {// loop till the end of the linked list
            // The sublist from head to current reversed.
            Node next = curr.next;
            curr.next = prev;
            // check for odd length  palindrome by finding longest common list elements beginning from prev and from next (We exclude curr)
            result = Math.max(result, 2 * countCommon(prev, next)+1);
            // check for even length palindrome by finding longest common list elements beginning from curr and from next
            result = Math.max(result, 2*countCommon(curr, next));
            // update prev and curr for next iteration
            prev = curr;
            curr = next;
        }
        return result;
    }

    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    public void printNode(Node n1, Node n2){
        System.out.print("Comparing n1 ");
        while(n1!=null && n1.next!=null) {
            System.out.print(n1.data+" ");
            n1=n1.next;
        }
        System.out.print(" n2 ");
        while(n2!=null && n2.next!=null) {
            System.out.print(n2.data+" ");
            n2=n2.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = newNode(2);
        head.next = newNode(4);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(15);

        LengthLongestPalindromeInLinkedList palindrome =new LengthLongestPalindromeInLinkedList(head);
        System.out.println(palindrome.maxPalindrome());
    }
}
