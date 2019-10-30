package com.amazon.question;

import java.util.*;

public class MostFrequentSubtreeSum {

    private TreeNode root;

    private Map<Integer,Integer> sum2CountMap;

    private Map<Integer,Map<Integer , List<Integer>>> countToNodeMap;

    private int maxCount;

    public MostFrequentSubtreeSum(TreeNode root) {
        this.sum2CountMap =new HashMap<>();
        this.countToNodeMap =new HashMap<>();
        this.root = root;
        this. maxCount =Integer.MIN_VALUE;
    }

    public int[] findFrequentTreeSum() {
        findFrequentTreeSum(root);
        Map<Integer , List<Integer>> listMap = countToNodeMap.get(maxCount);
        Collection<List<Integer>> collection = listMap.values();
        return null;
    }

    public int findFrequentTreeSum(TreeNode root) {
        if(root==null)
            return 0;
        else{
            int left = findFrequentTreeSum(root.left);
            int right = findFrequentTreeSum(root.right);
            int sum = root.val + left + right;
            int count = sum2CountMap.getOrDefault(sum , 0);
            if(count!=0){
                sum2CountMap.remove(sum);
                sum2CountMap.put(sum , count+1);
                maxCount =Math.max(maxCount ,count+1);
                List<Integer> list=  countToNodeMap.get(count).get(sum);
                if(list==null)
                    list = new ArrayList<>();
                list.add(root.val);
                countToNodeMap.get(count).remove(sum);
                Map<Integer , List<Integer>> listMap = countToNodeMap.getOrDefault(count+1 , new HashMap<>()) ;
                listMap.put(sum , list);
                countToNodeMap.put(count+1 ,listMap) ;
            }else{
                sum2CountMap.put(sum ,1);
                maxCount =Math.max(maxCount ,1);
                Map<Integer , List<Integer>> listMap= countToNodeMap.getOrDefault(1 , new HashMap<>());
                List<Integer> list =listMap.getOrDefault(sum , new ArrayList<>());
                list.add(root.val);listMap.put(sum , list);
                countToNodeMap.put(1 ,listMap );
            }
            return sum;
        }
    }


    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static void main(String[] args) {
        TreeNode treeNode =new TreeNode(11);
        treeNode.left = new TreeNode(2);treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(3);treeNode.right.right = new TreeNode(1);
        MostFrequentSubtreeSum subtreeSum =new MostFrequentSubtreeSum(treeNode);
        subtreeSum.findFrequentTreeSum();
    }
}
