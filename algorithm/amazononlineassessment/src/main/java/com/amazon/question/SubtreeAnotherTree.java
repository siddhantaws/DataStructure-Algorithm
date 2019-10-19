package com.amazon.question;

public class SubtreeAnotherTree {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }
    }

    public boolean isSubtree(Node s, Node t) {
        if(s==null)
            return false;
        return equals(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean equals(Node s, Node t){
        if(s==null && t==null)
            return true;
        if(s==null && t!=null)
            return false;
        if(s!=null && t==null)
            return false;
        return s.val == t.val && equals(s.left , t.left) && equals(s.right , t.right);
    }
}
