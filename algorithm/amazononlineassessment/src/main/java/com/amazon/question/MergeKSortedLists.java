package com.amazon.question;

import org.w3c.dom.NodeList;

public class MergeKSortedLists {

    private ListNode[] lists ;

    public MergeKSortedLists(ListNode[] lists) {
        this.lists = lists;
    }

    private  ListNode mergeKLists(){
        mergeKLists(0 , lists.length-1);
        for(int i=0;i<lists.length;i++)
            if(lists[i]!=null)
                return lists[i];
        return null;
    }

    private  void mergeKLists(int l ,int r) {
        if(l>r)
            return;
        else{
            int mid = l + (r-l)/2;
            mergeKLists(l,mid);
            mergeKLists(mid+1,r);
            ListNode first =null;ListNode second =null;
            int fIndex =-1; int secondIndex =-1;
            while(l<mid){
                if(first==null && lists[l]!=null){
                    first =lists[l];
                    fIndex=l;
                    break;
                }
            }
            l=mid+1;
            while(l<r){
                if(second==null && lists[l]!=null){
                    second =lists[l];
                    secondIndex=l;
                    break;
                }
            }
            ListNode nodeList1 =merge(first , second);
            lists[secondIndex]=null;
            lists[fIndex]=nodeList1;
        }
    }

    private ListNode merge(ListNode first, ListNode second){
         if(first==null)
             return second;
         if(second==null)
             return first;
         else{
             if(first.val<second.val){
                 first.next =merge(first.next,second);
                 return first;
             }else {
                 second.next =merge(first,second.next);
                 return second;
             }
         }
    }

    public static void main(String[] args) {
        ListNode node[] =new ListNode[3];
        node[0]= new ListNode(1);node[0].next =new ListNode(4);node[0].next.next =new ListNode(5);
        node[1]= new ListNode(1);node[1].next =new ListNode(3);node[1].next.next =new ListNode(4);
        node[2]= new ListNode(2);node[2].next =new ListNode(6);
        MergeKSortedLists sortedLists =new MergeKSortedLists(node);
        ListNode node1 =sortedLists.mergeKLists();
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
    }
}
