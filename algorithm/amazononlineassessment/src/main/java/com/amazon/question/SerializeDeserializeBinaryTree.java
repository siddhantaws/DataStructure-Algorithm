package com.amazon.question;

public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.

    private String serailizeString;

    private int count =-1;

    public String serialize(TreeNode root) {
        serailizeString = serialize(root,new StringBuilder()).toString();
        return serailizeString;
    }

    private StringBuilder serialize(TreeNode root,StringBuilder builder) {
        if(root==null){
            return null;
        }else{
            builder.append(root.val+",");
            StringBuilder left = serialize(root.left , builder);
            StringBuilder right = serialize(root.right , builder);
            if(left==null)
                builder.append("NULL"+",");
            if(right==null)
                builder.append("NULL"+",");
        }
        return builder;
    }

    private TreeNode deserialize(){
        return  deserialize(serailizeString);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode treeNode =deserialize(data.split(","));
        printInOrderTraversal(treeNode);
        return treeNode;
    }

    private TreeNode deserialize(String[] data) {
        count++;
        if(data[count].equals("NULL"))
            return null;
        else{
            TreeNode node =new TreeNode(Integer.parseInt(data[count]));
            node.left = deserialize(data);
            node.right = deserialize(data);
            return node;
        }
    }


    private void printInOrderTraversal(TreeNode treeNode){
        if(treeNode==null)
            return;
        else{
            printInOrderTraversal(treeNode.left);
            System.out.println(treeNode.val);
            printInOrderTraversal(treeNode.right);
        }
    }

    public static void main(String[] args) {
        /*TreeNode treeNode =new TreeNode(1);
        treeNode.left =new TreeNode(8);treeNode.right =new TreeNode(7);
        treeNode.left.left =new TreeNode(6);treeNode.left.right =new TreeNode(5);
        treeNode.right.left =new TreeNode(4);treeNode.right.right =new TreeNode(2);*/
        TreeNode treeNode =new TreeNode(1);
        treeNode.right =new TreeNode(2);
        SerializeDeserializeBinaryTree binaryTree =new SerializeDeserializeBinaryTree();
        System.out.println(binaryTree.serialize(treeNode));
        binaryTree.deserialize();

    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
