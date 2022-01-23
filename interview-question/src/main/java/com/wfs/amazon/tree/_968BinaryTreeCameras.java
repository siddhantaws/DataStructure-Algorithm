package com.wfs.amazon.tree;

import java.util.*;

public class _968BinaryTreeCameras {
    int ans;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        covered = new HashSet<>();
        covered.add(null);
        dfs(root, null);
        return ans;
    }

    public String serialize(TreeNode root) {
        if(root==null)
            return "X";
        String left =serialize(root.left);
        String right =serialize(root.right);
        return root.val+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue =new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue){
        if(queue.isEmpty())
            return null;
        String currString =queue.poll();
        if(currString.equals("X"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(currString));
        node.left = deserializeHelper(queue);
        node.right =deserializeHelper(queue);
        return node;
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if (par == null && !covered.contains(node) ||  !covered.contains(node.left) || !covered.contains(node.right)) {
                ans++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        root.left =new TreeNode(3);root.left.left =new TreeNode(3);root.left.right =new TreeNode(1);
        _968BinaryTreeCameras treeCameras =new _968BinaryTreeCameras();
        System.out.println(treeCameras.minCameraCover(root));
        //root.right =new TreeNode(1);root.right.right =new TreeNode(1);
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
