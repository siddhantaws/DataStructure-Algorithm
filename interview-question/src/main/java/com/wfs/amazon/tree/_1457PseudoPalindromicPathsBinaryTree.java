package com.wfs.amazon.tree;

import java.util.HashMap;
import java.util.Map;

public class _1457PseudoPalindromicPathsBinaryTree {


    public int pseudoPalindromicPaths (TreeNode root) {
        return pseudoPalindromicPaths(root, new HashMap<>() , 0);
    }

    private int pseudoPalindromicPaths(TreeNode root , Map<Integer , Integer> mapOfNodesToCount, int count ){
        if(root==null){
            return  0 ;
        }
        mapOfNodesToCount.put(root.val ,mapOfNodesToCount.getOrDefault(root.val ,0)+1);
        int x = 0;
        if(mapOfNodesToCount.get(root.val)%2==1)
            x=count+1;
        else
            x= count-1;
        if(root.left==null && root.right==null)
            return (x==1 || x==0 ) ? 1 : 0;
        int leftCount=  pseudoPalindromicPaths(root.left , mapOfNodesToCount,x);
        int rightCount = pseudoPalindromicPaths(root.right , mapOfNodesToCount,x);
        mapOfNodesToCount.compute(root.val , (k,v)-> v==1 ? null : v-1);
        return leftCount+rightCount;
    }

    public static void main(String[] args) {
        _1457PseudoPalindromicPathsBinaryTree binaryTree =new _1457PseudoPalindromicPathsBinaryTree();
        TreeNode root =new TreeNode(2);
        root.left =new TreeNode(3);root.left.left =new TreeNode(3);root.left.right =new TreeNode(1);
        root.right =new TreeNode(1);root.right.right =new TreeNode(1);
        System.out.println(binaryTree.pseudoPalindromicPaths(root));
    }

    static  class TreeNode {
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
