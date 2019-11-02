package com.amazon.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

    private TreeNode root;

    public BinaryTreeZigzagLevelOrderTraversal(TreeNode root) {
        this.root = root;
    }
    public List<List<Integer>> zigzagLevelOrder(){
            return zigzagLevelOrder(root);
    }


    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists =new ArrayList<>();
        Stack<TreeNode> stack1 =new Stack<>();
        Stack<TreeNode> stack2 =new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() ||  !stack2.isEmpty()){
            List<Integer> list =new ArrayList<>();
            while(!stack1.isEmpty()){
                TreeNode  node =stack1.pop();
                list.add(node.val);
                if(node.left!=null)
                    stack2.push(node.left);
                if(node.right!=null)
                    stack2.push(node.right);

            }
            if(list.size()>0)
                lists.add(list);
            list =new ArrayList<>();
            while(!stack2.isEmpty()){
                TreeNode  node =stack2.pop();
                list.add(node.val);
                if(node.right!=null)
                    stack1.push(node.right);
                if(node.left!=null)
                    stack1.push(node.left);
            }
            if(list.size()>0)
                lists.add(list);
        }
        return lists;
    }


    public static void main(String[] args) {
        TreeNode node =new TreeNode(1);
        node.left = new TreeNode(2);node.right =new TreeNode(3);
        node.left.left =new TreeNode(4);node.left.right =new TreeNode(5);
        node.right.left =new TreeNode(6);node.right.right =new TreeNode(7);
        node.left.left.left =new TreeNode(8);node.left.left.right =new TreeNode(9);
        node.left.right.left =new TreeNode(10);node.left.right.right =new TreeNode(11);
        node.right.left.left= new TreeNode(12);node.right.left.right =new TreeNode(13);
        node.right.right.left =new TreeNode(14);node.right.right.right = new TreeNode(15);
        node.left.left.left.left =new TreeNode(16);node.left.left.left.right =new TreeNode(17);
        BinaryTreeZigzagLevelOrderTraversal traversal =new BinaryTreeZigzagLevelOrderTraversal(node);
        for(List<Integer> list :traversal.zigzagLevelOrder()){
            System.out.println();
            System.out.print("[");
            for(Integer integer:list)
                System.out.print(integer+" ");
            System.out.print("]");
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
