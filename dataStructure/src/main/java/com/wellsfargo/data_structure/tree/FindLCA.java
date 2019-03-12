package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindLCA {

    private Node root;

    private int K1;

    private int K2;

    public FindLCA(Node root, int k1, int k2) {
        this.root = root;
        K1 = k1;
        K2 = k2;
    }

    public Node findLCA1(Node n){
        if(n==null)
            return null;
        if(n.data==K1 ||  n.data==K2)
            return n;
        Node l = findLCA1(n.left);
        Node r = findLCA1(n.right);
        if(l!=null && r!=null){
            System.out.print(n.data+" ");
            return n;
        }else if(l==null)
            return r;
        else
            return l;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);
        FindLCA lca =new FindLCA(root , 9,7);
        System.out.println(lca.findLCA1(root));
    }


    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
