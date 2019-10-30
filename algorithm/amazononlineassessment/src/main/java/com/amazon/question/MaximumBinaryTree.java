package com.amazon.question;

public class MaximumBinaryTree {

    private int nums[];

    public MaximumBinaryTree(int[] nums) {
        this.nums = nums;
    }

    public TreeNode constructMaximumBinaryTree(){
        TreeNode node= constructMaximumBinaryTree(0, nums.length-1);
        inOrderTraversal(node);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int l , int r) {
         if(l>r)
             return null;
         else if(l==r)
             return new TreeNode(nums[l]);
         else{
             int maxIndex = getMax(l,r);
             TreeNode root = new TreeNode(nums[maxIndex]);
             root.left = constructMaximumBinaryTree(l,maxIndex-1);
             root.right = constructMaximumBinaryTree(maxIndex+1,r);
             return root;
         }
    }

    private int getMax(int l, int r){
        int max = nums[l];int maxIndex =l;
        for(int i=l+1;i<=r;i++)
            if(max>nums[i]){
                max = nums[i];
                maxIndex =i;
            }
        return maxIndex;
    }


    private void inOrderTraversal(TreeNode node){
        if(node==null)
            return;
        else
            inOrderTraversal(node.left);
        System.out.print(node.val+" ");
        inOrderTraversal(node.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MaximumBinaryTree binaryTree =new MaximumBinaryTree(new int[]{3,2,1,6,0,5});
        binaryTree.constructMaximumBinaryTree();
    }
}
