package com.amazon.question;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {
    private Node head;

    public CopyListRandomPointer(Node head) {
        this.head = head;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Integer,Node> nodeMap =new HashMap<>();
        Node head1=head;
        while(head1!=null){
            nodeMap.put(head1.val , new Node(head1.val,null,null));
            head1 =head1.next;
        }
        head1=head;
        while(head!=null){
            Node n =nodeMap.get(head.val);
            if(head.next!=null)
                n.next = nodeMap.get(head.next.val);
            if(head.random!=null)
            n.random = nodeMap.get(head.random.val);
            head =head.next;
        }
        return nodeMap.get(head.val);
    }
}
