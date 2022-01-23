package com.wfs.amazon.bit;

public class _421MaximumXORTwoNumbersArray_1 {
    private int nums[];
    private Node head;

    public _421MaximumXORTwoNumbersArray_1(int[] arr) {
        this.nums = arr;
        this.head =new Node();
        init();
    }
    private void init(){
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            Node currentNode =head;Node n =null;
            for(int j=31;j>=0;j--){
                if(((num>>j)&1)==1){
                    if(currentNode.right==null)
                        currentNode.right=new Node();
                    currentNode = currentNode.right;
                }else{
                    if(currentNode.left==null)
                        currentNode.left=new Node();
                    currentNode = currentNode.left;
                }
            }
        }
    }

    public int findMaxXorPair(){
        int max_xor =0;
        for(int i=0;i<nums.length;i++){
            int currMaxXor =0; int num =nums[i];Node currentHead = head;
            for(int j=31;j>=0;j--){
                if(((num>>j)&1)==1){
                    if(currentHead.left!=null){
                        currMaxXor+=Math.pow(10,j);
                        currentHead =currentHead.left;
                    }else{
                        currentHead =currentHead.right;
                    }
                }else{
                    if(currentHead.right!=null){
                        currMaxXor+=Math.pow(10,j);
                        currentHead =currentHead.right;
                    }else{
                        currentHead =currentHead.left;
                    }
                }
            }
            max_xor =Math.max( max_xor , currMaxXor );
        }
        return max_xor;
    }

    static class Node{
        Node left;
        Node right;
    }
}
