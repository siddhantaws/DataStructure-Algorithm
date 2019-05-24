package com.wellsfargo.data_structure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LowestCommonAncestorBinaryTreeRMQ {

    private Node root;

    private int N;

    private int eulerPath[];

    private int[] levelArr;

    private Map<Integer,Integer> integerMap ;

    private int segmentTree[];

    private int count=-1;
    static class Node {
        int data ;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public LowestCommonAncestorBinaryTreeRMQ(Node root, int N) {
        this.root = root;
        this.N=N;
        this.eulerPath =new int[(2*N)-1];
        this.levelArr = new int[(2*N)-1];
        this.integerMap =new HashMap<>();
        this.segmentTree =new int[2*levelArr.length-1];
        constructEulerAndLevel();
        segmentTree();
    }

    public void constructEulerAndLevel(){
        constructEulerAndLevel(root,1);
        for(int a :eulerPath)
            System.out.print(a+" ");
        System.out.println();
        for(int a :levelArr)
            System.out.print(a+" ");
        System.out.println();
        System.out.println(integerMap);
    }

    public void segmentTree(){
        segmentTree(0 , segmentTree.length-1 , 0);
    }

    private void segmentTree(int l ,  int r , int pos){
        if(l>r)
            return;
        if(l==r){
            segmentTree[pos] =levelArr[pos];
            return;
        }
        int mid = l + (r-l)/2;
        segmentTree(0,mid, 2*pos+l);
        segmentTree(mid+1, r, 2*pos+2);
        segmentTree[pos] = Math.min(segmentTree[2*pos+1] , segmentTree[2*pos+2]);
    }

    public int getLCA(int data1 , int data2){
        return eulerPath[getMin(0 ,levelArr .length-1 ,  integerMap.get(data1) , integerMap.get(data2) , 0)];
    }


    public int getMin(int l ,int r , int ql , int qr, int pos){
           if(ql<=l && qr >=r)
                return pos;
            if(ql>l && qr <r)
                return -1;
            int mid =l+(r-l)/2;
            int leftIndex = getMin(l,mid , ql,qr , 2*pos+1);
            int rightIndex = getMin(mid+1,r , ql,qr , 2*pos+2);
            if(leftIndex ==-1 || rightIndex==-1 )
                return  leftIndex == -1 ? rightIndex : leftIndex;
            return segmentTree[leftIndex] > segmentTree[rightIndex] ? rightIndex : leftIndex;
    }

    private Node constructEulerAndLevel(Node node,int level){
        if(node==null)
            return null;
        eulerPath[++count] = node.data;
        levelArr[count] =level;
        if(!integerMap.containsKey(node.data))
            integerMap.put(node.data, count);
        Node left= constructEulerAndLevel(node.left ,  level+1);
        if(left!=null){
            eulerPath[++count] = node.data;
            levelArr[count] =level;
        }
        Node right= constructEulerAndLevel(node.right,  level+1);
        if(right!=null){
            eulerPath[++count] = node.data;
            levelArr[count] =level;
        }
        return node;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        LowestCommonAncestorBinaryTreeRMQ lowest= new  LowestCommonAncestorBinaryTreeRMQ(root  ,9);
        System.out.println(lowest.getLCA(2,8));
    }


}
