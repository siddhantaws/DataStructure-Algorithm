package com.amazon.question;

public class PopulatingNextRightPointersEachNode {

    private Node root;

    public PopulatingNextRightPointersEachNode(Node root) {
        this.root = root;
    }

    private Node connect(){
        connect(root);
        return root;
    }

    private Node connect(Node root) {
        if(root==null || root.left==null || root.right==null ){
            return root;
        }else{
            root.left.next=root.right;
            if(root.next!=null)
                root.right.next=root.next.left;
            Node left = connect(root.left);
            Node right = connect(root.right);
            return root;
        }
    }


    public static void main(String[] args) {
        Node n =new Node(1);n.left=new Node(2);n.right=new Node(3);
        n.left.left =new Node(4);n.left.right =new Node(5);
        n.right.left =new Node(6);n.right.right =new Node(7);
        PopulatingNextRightPointersEachNode eachNode =new PopulatingNextRightPointersEachNode(n);
        eachNode.connect();
    }
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
    }

}
