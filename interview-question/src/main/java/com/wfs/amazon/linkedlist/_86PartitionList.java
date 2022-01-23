package com.wfs.amazon.linkedlist;

public class _86PartitionList {
    private ListNode head;

    private int x;

    public _86PartitionList(ListNode head, int x) {
        this.head = head;
        this.x = x;
    }

    public ListNode partition() {
        if(head==null || head.next==null)
            return head;
        ListNode last =head;
        while(last.next!=null)
            last =last.next;
        ListNode currentLast =last;
        ListNode currHead =head;
        while(currHead!=currentLast.next){
            if(currHead.val>=x){
                ListNode curr = currHead.next;
                currentLast.next=currHead;
                currHead=null;
                currHead =curr;
            }else{
                currHead= currHead.next;
            }

        }
        return currHead;
    }


    public static void main(String[] args) {
        ListNode l =new ListNode(1);l.next =new ListNode(4);l.next.next=new ListNode(3);l.next.next.next=new ListNode(2);l.next.next.next.next=new ListNode(5);
        l.next.next.next.next.next=new ListNode(2);
        _86PartitionList list =new _86PartitionList(l , 3);
        ListNode head =list.partition();
        while(head!=null){
            System.out.print(head.val+" ");
        }
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
