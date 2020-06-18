package com.wfs.amazon.devideconqur;

public class _23_Merge_K_SortedLists {

    private  ListNode listNode[];

    public _23_Merge_K_SortedLists(ListNode[] listNode) {
        this.listNode = listNode;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists , 0 ,lists.length-1);
    }

    private ListNode merge(ListNode[] lists , int l, int r){
        if(l>r)
            return null;
        if(l==r)
            return lists[l];
        int mid =l + (r-l)/2;
        ListNode leftMergedNode = merge(lists, 0 , mid);
        ListNode rightMergedNode = merge(lists, mid+1 , r);
        return join(leftMergedNode , rightMergedNode);
    }

    private ListNode join(ListNode leftMergedNode ,ListNode rightMergedNode){
        ListNode temp =null;
        if(leftMergedNode==null || rightMergedNode==null)
            return leftMergedNode==null ? rightMergedNode : leftMergedNode;
        if(leftMergedNode.val<rightMergedNode.val){
            temp = leftMergedNode;
            temp.next= join(leftMergedNode.next, rightMergedNode);
        }else{
            temp = rightMergedNode;
            temp.next= join(leftMergedNode ,rightMergedNode.next);
        }
        return temp;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }
}
