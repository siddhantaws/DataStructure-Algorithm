package com.wfs.amazon.tree;

public class _1022SumofRootToLeafBinaryNumbers {

    private int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        sumRootToLeaf(root,new StringBuilder());
        return sum;
    }
    private void  sumRootToLeaf(TreeNode root ,StringBuilder sb){
        if(root==null){
            sum+= Integer.parseInt(sb.toString(),2);
            return ;
        }
        sb.append(root.val);
        sumRootToLeaf(root.left ,sb );
        sumRootToLeaf(root.right ,sb );
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        _1022SumofRootToLeafBinaryNumbers toLeafBinaryNumbers =new _1022SumofRootToLeafBinaryNumbers();
        TreeNode treeNode =new TreeNode(1);
        treeNode.left=new TreeNode(0);treeNode.left.left=new TreeNode(0);treeNode.left.right=new TreeNode(1);
        treeNode.right=new TreeNode(1);treeNode.right.left=new TreeNode(0);treeNode.right.right=new TreeNode(1);
        System.out.println(toLeafBinaryNumbers.sumRootToLeaf(treeNode));
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
