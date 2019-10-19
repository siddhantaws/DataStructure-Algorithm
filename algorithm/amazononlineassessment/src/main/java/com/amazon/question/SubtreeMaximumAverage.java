package com.amazon.question;

import java.util.ArrayList;
import java.util.List;

public class SubtreeMaximumAverage {

    private TreeNode treeNode;

    public SubtreeMaximumAverage(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public int getMaxAvrageSum(){
        return getMaxAvrageSum(treeNode).node;
    }

    private AvgSum getMaxAvrageSum(TreeNode treeNode){
        if(treeNode==null)
            return null;
        else{
            int maxAvg = Integer.MIN_VALUE;
            int maxNode =-1;
            int currAvg = 0;
            int totalCount =1;
            for(int i=0;i<treeNode.getTreeNodes().size();i++){
                AvgSum avgSum = getMaxAvrageSum(treeNode.getTreeNodes().get(i));
                if(maxAvg<avgSum.maxAvg){
                    maxAvg = avgSum.maxAvg ;
                    maxNode = avgSum.node;
                }
                totalCount +=avgSum.totalCount;
                currAvg += (avgSum.avg* avgSum.totalCount);

            }
            currAvg = (treeNode.val +currAvg)/totalCount;
            if(maxAvg<currAvg){
                maxAvg = currAvg ;
                maxNode = treeNode.val;
                return new AvgSum(maxAvg, totalCount, maxAvg , maxNode);
            }
            return new AvgSum(currAvg, totalCount, maxAvg , maxNode);
        }
    }

    public static void main(String[] args) {
        TreeNode t =new TreeNode(20);
        TreeNode t1 =new TreeNode(12);
        TreeNode t2 =new TreeNode(18);
        t.getTreeNodes().add(t1);t.getTreeNodes().add(t2);
        t1.getTreeNodes().add(new TreeNode(11));t1.getTreeNodes().add(new TreeNode(2));t1.getTreeNodes().add(new TreeNode(3));
        t2.getTreeNodes().add(new TreeNode(15));t2.getTreeNodes().add(new TreeNode(8));
        SubtreeMaximumAverage maximumAverage =new SubtreeMaximumAverage(t);
        System.out.println(maximumAverage.getMaxAvrageSum());
    }


    class AvgSum {
        int avg ;
        int totalCount;
        int maxAvg ;
        int node;

        AvgSum(int avg, int totalCount, int maxAvg, int node) {
            this.avg = avg;
            this.totalCount = totalCount;
            this.maxAvg = maxAvg;
            this.node = node;
        }

    }

    static class TreeNode {
        int val;
        List<TreeNode> treeNodes =new ArrayList<>();
        public List<TreeNode> getTreeNodes() {
            return treeNodes;
        }
        TreeNode(int x) {
            val = x;
        }

    }
}
