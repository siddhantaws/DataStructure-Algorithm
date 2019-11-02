package com.amazon.question;

public class AddTwoNumbers_II {
    private ListNode l1;
    private ListNode l2;

    public AddTwoNumbers_II(ListNode l1, ListNode l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    public ListNode addTwoNumbers() {
        int L1 =length(l1);
        int L2 =length(l2);
        int diff = Math.abs(L1-L2);
        int carry =  L1>L2 ? addNumbers(l1,l2 ,diff) : addNumbers(l2,l1,diff);
        ListNode node=null;
        if(carry>0){
            node =new ListNode(carry);
            node.next = l1;
        }
        return node== null ? l1 : node;
    }

    public int addNumbers(ListNode l1, ListNode l2 , int diff) {
        if(l1==null && l2==null)
            return 0;
        else{
            int prev = diff>0 ? addNumbers(l1.next , l2, diff-1 ) : addNumbers(l1.next,l2.next,diff);
            int result=0;
            if(diff==0 && prev!=0){
                result = l1.val+l2.val+prev;
            }else if(diff>=1 && prev==0){
                result =l1.val;
            }else if(diff>=1 && prev==1){
                result =l1.val+prev;
            }
            l1.val =result%10;
            return result>9 ? 1 : 0;
        }
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(7);l1.next =new ListNode(2);l1.next.next=new ListNode(4);l1.next.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);l2.next =new ListNode(6);l2.next.next=new ListNode(4);
        AddTwoNumbers_II numbers_ii =new AddTwoNumbers_II(l1,l2);
        ListNode result = numbers_ii.addTwoNumbers();
        while(result!=null){
            System.out.print(result.val+" ->");
            result =result.next;
        }
    }

    private int length(ListNode listNode){
        int count=0;
        while(listNode!=null){
            count++;
            listNode=listNode.next;
        }
        return count;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
