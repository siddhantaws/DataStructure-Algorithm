package com.wellsfargo.data_structure.array;

public class CountElementsDivideAllNumbersInRangeL_R {

    private Node[] nodes;

    private int[] inputArray;

    public CountElementsDivideAllNumbersInRangeL_R(int[] inputArray){
        this.inputArray=inputArray;
        this.nodes = new Node[isPowerOfTwo(inputArray.length) ? 2*inputArray.length-1 : 2*getNextPowerOf2(inputArray.length)-1];
    }

    private boolean isPowerOfTwo(int num){
        return num == 0 || (num & num-1 )==0;
    }

    private int getNextPowerOf2(int num){
        int count=0;
        while(num>0){
            num =num>>1;
            count++;
        }
        return 1<<count;
    }

    public void constructSegmentTree(){
        constructSegmentTree(0 , inputArray.length , 0);
    }

    private Node constructSegmentTree(int start , int end , int pos){
        if(start==end){
            nodes[pos] =new Node(inputArray[start]);
            return nodes[pos];
        }

        int mid =(start+end)/2;
        Node left= constructSegmentTree(start  ,mid , 2*start+1);
        Node right= constructSegmentTree(mid+1  ,end, 2*start+2);
        nodes[pos].gcd = gcd(left.gcd , right.gcd);

        if (left.min < right.min)
        {
            nodes[pos].min = left.min;
            nodes[pos].cnt = left.cnt;
        }// right subtree has the minimum element
        else if (left.min > right.min)
        {
            nodes[pos].min = right.min;
            nodes[pos].cnt = right.cnt;
        }// both subtree has the same minimum element
        else
        {
            nodes[pos].min = left.min;
            nodes[pos].cnt = left.cnt + right.cnt;
        }
        return null;
    }

    private int gcd(int num1 ,int num2){
        // Everything divides 0
        if (num1 == 0 || num2 == 0)
            return 0;

        // base case
        if (num1 == num2)
            return num1;

        // a is greater
        if (num1 >num2)
            return gcd(num1-num2, num2);
        return gcd(num1, num2-num1);
    }

    class Node{
        int gcd;
        int min;
        int cnt;
        int value;

        public Node(int gcd, int min, int cnt) {
            this.gcd = gcd;
            this.min = min;
            this.cnt = cnt;
        }

        public Node(int value) {
            this.value = value;
        }
    }
}
