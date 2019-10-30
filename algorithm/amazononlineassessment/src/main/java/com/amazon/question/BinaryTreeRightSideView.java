package com.amazon.question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    private TreeNode root;

    private List<Integer> integers;

    public BinaryTreeRightSideView(TreeNode root) {
        this.root = root;
        this.integers =new ArrayList<>();
    }

    private List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> integers1 =new ArrayDeque<>();
        Queue<TreeNode> integers2 =new ArrayDeque<>();
        integers1.add(root);
        while(!integers1.isEmpty() || !integers2.isEmpty()){
            boolean first= false;boolean second= false;
            while(!integers1.isEmpty()){
                TreeNode node =integers1.poll();
                if(!first){
                    integers.add(node.val);
                    first=true;
                }
                if(node.right!=null)
                    integers2.add(node.right);
                if(node.left!=null)
                    integers2.add(node.left);
            }

            while(integers2.isEmpty()){
                TreeNode node =integers2.poll();
                if(!second){
                    integers.add(node.val);
                    second=true;
                }
                if(node.right!=null)
                    integers1.add(node.right);
                if(node.left!=null)
                    integers1.add(node.left);
            }
        }
        return integers;
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
