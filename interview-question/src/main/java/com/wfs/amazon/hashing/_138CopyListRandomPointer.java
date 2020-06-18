package com.wfs.amazon.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _138CopyListRandomPointer {

    private Node head;

    public _138CopyListRandomPointer(Node head) {
        this.head = head;
    }

    public Node copyRandomList(Node head) {

        Node curr =head;Node clonedNodeHeads =null;Node lastNode =null;
        Map<Integer,Node> mapOfClonedNodes =new HashMap<>();
        while(head!=null){
            if(mapOfClonedNodes.containsKey(head.val)){
                lastNode.next= mapOfClonedNodes.get(head.val);
            }else {
                Node node =lastNode = new Node(head.val);
                if (clonedNodeHeads == null)
                    clonedNodeHeads  =new Node(head.val);
                mapOfClonedNodes.put(head.val ,node );
            }
            //GO for Random Pointer
            if(head.random!=null){
                if(!mapOfClonedNodes.containsKey(head.random.val))
                    mapOfClonedNodes.put(head.random.val ,  new Node(head.random.val));
                lastNode.random = mapOfClonedNodes.get(head.random.val);
            }
            head = head.next;
        }
        return clonedNodeHeads;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
