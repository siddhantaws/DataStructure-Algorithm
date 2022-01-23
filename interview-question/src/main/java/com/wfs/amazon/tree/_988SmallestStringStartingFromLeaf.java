package com.wfs.amazon.tree;

public class _988SmallestStringStartingFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        if(root==null)
            return "";
        String left =smallestFromLeaf(root.left);
        String right =smallestFromLeaf(root.right);
        if((left.trim().length()> 0 && left.charAt(0)<=(char)root.val) || (right.trim().length()>0 && right.charAt(0)<=(char)root.val) ){
            if(left.charAt(0)<=(char)root.val && right.charAt(0)<=(char)root.val && left.length()==right.length()){
                return left.charAt(0)<right.charAt(0) ?  ((char)root.val+'A'+"")+left : ((char)root.val+'A'+"")+right ;
            }else if(left.charAt(0)<=(char)root.val){
                return ((char)root.val+'A'+"")+left;
            }else{
                return ((char)root.val+'A'+"")+right ;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        _988SmallestStringStartingFromLeaf starting =new _988SmallestStringStartingFromLeaf();
        TreeNode root =new TreeNode(0);
        root.left =new TreeNode(1);root.right =new TreeNode(2);
        root.left.left= new TreeNode(3);root.left.right= new TreeNode(4);
        root.right.left=new TreeNode(3);root.right.right=new TreeNode(4);
        System.out.println(starting.smallestFromLeaf(root));
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
