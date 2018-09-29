package com.wellsfargo.data_structure.tree;

public class CreatingTreeWithLeftChildRightSibling {


    public static NodeTemp addChild(NodeTemp node,int data)
    {
        if(node == null)
            return null;

        // Check if child is not empty.
        if(node.child != null)
            return(addSibling(node.child,data));
        else
            return(node.child = new NodeTemp(data));
    }

    public static NodeTemp addSibling(NodeTemp node, int data)
    {
        if(node == null)
            return null;
        while(node.next != null)
            node = node.next;
        return(node.next = new NodeTemp(data));
    }

    public void traverseTree(NodeTemp root)
    {
        if(root == null)
            return;
        while(root != null)
        {
            System.out.print(root.data + " ");
            if(root.child != null)
                traverseTree(root.child);
            root = root.next;
        }
    }

    public static void main(String[] args) {
        NodeTemp root = new NodeTemp(10);
        NodeTemp n1 = addChild(root,2);
        NodeTemp n2 = addChild(root,3);
        NodeTemp n3 = addChild(root,4);
        NodeTemp n4 = addChild(n3,6);
        NodeTemp n5 = addChild(root,5);
        NodeTemp n6 = addChild(n5,7);
        NodeTemp n7 = addChild(n5,8);
        NodeTemp n8 = addChild(n5,9);
    }

    static class NodeTemp
    {
        int data;
        NodeTemp next, child;
        public NodeTemp(int data)
        {
            this.data = data;
            next = child = null;
        }
    }
}
