package com.amazon.question;

import java.util.List;

public class RotateList {

    private ListNode head;

    public RotateList(ListNode head) {
        this.head = head;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        int L= getLength(head);
        k%=L;
        if(k==0)
            return head;
        ListNode l =getKthNode(L-k, head);
        ListNode l1=l.next;ListNode head1=l1;
        l.next=null;
        while(l1.next!=null){
            l1=l1.next;
        }
        l1.next=head;
        return head1;
    }

    private ListNode getKthNode(int k,ListNode head){
        while(--k>0){
            head=head.next;
        }
        return head;
    }

    private int getLength(ListNode head){
        int x=0;
        while(head!=null){
            head=head.next;
            x++;
        }
        return x++;
    }


    public static void main(String[] args) {
        ListNode node =new ListNode(1);node.next=new ListNode(2);node.next.next =new ListNode(3);
        node.next.next.next =new ListNode(4);node.next.next.next.next =new ListNode(5);
        RotateList list =new RotateList(node);
        ListNode listNode =list.rotateRight(node , 7);
        while(listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
