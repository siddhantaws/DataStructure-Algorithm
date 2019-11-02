package com.amazon.question;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthBinaryTree {

    private TreeNode root ;
    Map<Integer, Integer> left;int ans;
    public MaximumWidthBinaryTree(TreeNode root) {
        this.root = root;
        this.left=new HashMap<>();
    }

    private int widthOfBinaryTree() {
        widthOfBinaryTree(root,0,0);
        return ans;
    }

    private void widthOfBinaryTree(TreeNode root , int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        widthOfBinaryTree(root.left, depth + 1, 2 * pos);
        widthOfBinaryTree(root.right, depth + 1, 2 * pos + 1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(1);
        treeNode.left=new TreeNode(3);treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(5);treeNode.right.right=new TreeNode(9);
        treeNode.left.left.left=new TreeNode(6);treeNode.right.right.right=new TreeNode(7);
        MaximumWidthBinaryTree widthBinaryTree =new MaximumWidthBinaryTree(treeNode);
        System.out.println(widthBinaryTree.widthOfBinaryTree());

    }
}
