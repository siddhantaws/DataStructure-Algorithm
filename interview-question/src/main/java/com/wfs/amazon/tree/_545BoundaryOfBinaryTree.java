package com.wfs.amazon.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _545BoundaryOfBinaryTree {

    private TreeNode head;

    public _545BoundaryOfBinaryTree(TreeNode head) {
        this.head = head;
    }

    public List<Integer> boundaryOfBinaryTree() {
        return boundaryOfBinaryTree(head);
    }

    private List<Integer> boundaryOfBinaryTree(TreeNode head) {
        List<Integer> listOFLeftNodes = new ArrayList<>();
        List<Integer> listOFRightNodes = new ArrayList<>();
        List<Integer> listOfLeafNodes = new ArrayList<>();

        traverseSideLeft(head.left ,true, listOFLeftNodes);
        traverseSideLeft(head.right ,false, listOFRightNodes);
        allLeafNodes(head , listOfLeafNodes);
        List<Integer> allNodes = new ArrayList<>();
        allNodes.add(head.val);
        allNodes.addAll(listOFLeftNodes);
        allNodes.addAll(listOfLeafNodes);Collections.reverse(listOFRightNodes);
        allNodes.addAll(listOFRightNodes);
        return allNodes;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left =new TreeNode(2);head.right =new TreeNode(3);
        head.left.left = new TreeNode(4);head.left.right =new TreeNode(5);head.left.right.left =new TreeNode(7);head.left.right.right =new TreeNode(8);
        head.right.left =new TreeNode(6);head.right.left.left =new TreeNode(9);head.right.left.right =new TreeNode(10);
        _545BoundaryOfBinaryTree boundary =new _545BoundaryOfBinaryTree(head);
        for(Integer node:boundary.boundaryOfBinaryTree())
            System.out.print(node+" ");
    }


    private void allLeafNodes(TreeNode head ,  List<Integer> listOfLeafNodes ) {
        if(head==null )
            return;
        if(head.left==null && head.right==null){
            listOfLeafNodes.add(head.val);
            return;
        }
        allLeafNodes(head.left , listOfLeafNodes);
        allLeafNodes(head.right , listOfLeafNodes);
    }

    private void traverseSideLeft(TreeNode head,boolean left,  List<Integer> listOfNodes){
        if(head==null || (head.left ==null && head.right==null))
            return;
        listOfNodes.add(head.val);
        if(left){
            if(head.left!=null)
                traverseSideLeft(head.left,left,listOfNodes);
            else if (head.right!=null)
                traverseSideLeft(head.right,left,listOfNodes);
        }else{
            if(head.right!=null)
                traverseSideLeft(head.right,left,listOfNodes);
            else if (head.left!=null)
                traverseSideLeft(head.left,left,listOfNodes);
        }
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
