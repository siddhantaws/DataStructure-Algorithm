package com.wfs.amazon.tree;

import java.util.List;

public class _1305AllElementsTwoBinarySearchTrees {
    private TreeNode head1 =new TreeNode(Integer.MAX_VALUE);
    private TreeNode head2 =new TreeNode(Integer.MAX_VALUE);
    private TreeNode prev =null;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        convertToLinkedList(root1,head1);
        prev=null;
        convertToLinkedList(root2,head2);
        return null;
    }


    public static void main(String[] args) {
        TreeNode root= new TreeNode(2);
        root.left =new TreeNode(1);
        root.right =new TreeNode(4);
        _1305AllElementsTwoBinarySearchTrees binarySearchTrees =new _1305AllElementsTwoBinarySearchTrees();
        binarySearchTrees.getAllElements(root,root);
    }
    private void convertToLinkedList(TreeNode root1 , TreeNode head){
        if(root1==null)
            return ;
        convertToLinkedList(root1.left, head1);
        if(head1.val==Integer.MAX_VALUE){
            head1 = root1;
        }else{
            prev.right =root1;
            root1.left = prev;
        }

        prev = root1;
        convertToLinkedList(root1.right, head1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
