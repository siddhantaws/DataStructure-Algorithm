package com.wellsfargo.data_structure.tree;

public class ConnectNodesSameLevelWithO1ExtraSpace {

    private static Node root;

    static class Node {
        int data;
        Node left, right , nextRight ;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data->" + data;
        }
    }
    /* This function returns the leftmost child of nodes at the same level
       as p. This function is used to getNExt right of p's right child
       If right child of is NULL then this can also be sued for the
       left child */
    static Node getNextRight(Node p)
    {
        Node temp = p.nextRight;
        /* Traverse nodes at p's level and find and return the first node's first child */
        while (temp != null)
        {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.nextRight;
        }
        /*If all the nodes at p's level are leaf nodes then return NULL*/
        return null;
    }

    static void connect(Node p) {
        Node temp = null;

        if (p == null)
            return;

        // Set nextRight for root
        p.nextRight = null;

        // set nextRight of all levels one by one
        while (p != null)
        {
            Node q = p;

            /* Connect all childrem nodes of p and children nodes of all other
               nodes at same level as p */
            while (q != null)
            {
                // Set the nextRight pointer for p's left child
                if (q.left != null)
                {

                    // If q has right child, then right child is nextRight of
                    // p and we also need to set nextRight of right child
                    if (q.right != null)
                        q.left.nextRight = q.right;
                    else
                        q.left.nextRight = getNextRight(q);
                }

                if (q.right != null)
                    q.right.nextRight = getNextRight(q);

                // Set nextRight for other nodes in pre order fashion
                q = q.nextRight;
            }

            // start from the first node of next level
            if (p.left != null)
                p = p.left;
            else if (p.right != null)
                p = p.right;
            else
                p = getNextRight(p);
        }
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        connect(root);
    }
}
