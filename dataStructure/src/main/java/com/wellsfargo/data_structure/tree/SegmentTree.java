package com.wellsfargo.data_structure.tree;

public class SegmentTree<K extends Comparable> {
    private K[] inputArray;

    private K[] segmentArray;

    public SegmentTree(K[] inputArray) {
        this.inputArray = inputArray;
        this.segmentArray = (K[])new Comparable[isPowerOf2(inputArray.length) ? (2*inputArray.length)-1 : (2*getNextPowOf2(inputArray.length))-1];
    }

    private boolean isPowerOf2(int num){
        return num ==0 || (num & num-1)==0;
    }

    private int getNextPowOf2(int num){
        int count=0;
        while(num>0 ){
            num =num>>1;
            count++;
        }
        return 1<<count;
    }

    public void constructSegmentTree(){
        constructSegmentTree(0,inputArray.length -1, 0);
    }

    private void constructSegmentTree(int low, int high , int pos){
        if(low == high){
            segmentArray[pos] =inputArray[low];
            return;
        }
        int mid =(low+high)/2;
        constructSegmentTree(low,mid,2*pos+1);
        constructSegmentTree(mid+1,high,2*pos+2);
        segmentArray[pos] =segmentArray[2*pos+1].compareTo(segmentArray[2*pos+2]) <0 ? segmentArray[2*pos+1]: segmentArray[2*pos+2];
    }

    public K getMinimum(int start , int end ){
        return getMinimum(start , end , 0 , segmentArray.length , 0);
    }

    private K getMinimum(int qStart,int qEnd , int start, int end , int pos){
        if(qStart<=start && qEnd>=end)//total overlap
            return segmentArray[pos];
        else if(qStart > start || qEnd< end) // no Overlap;
            return (K)((Integer)Integer.MAX_VALUE);

        int mid = (start+end)/2;
        K left=getMinimum(qStart,qEnd , start, mid,2*pos+1);
        K right=getMinimum(qStart,qEnd , start, mid,2*pos+2);
        return left.compareTo(right) < 0 ? left : right;
    }

    public static void main(String[] args) {
        SegmentTree<Integer> segmentTree=new SegmentTree<Integer>(new Integer[]{1,2,4,5,17 ,3,25,9});
        segmentTree.constructSegmentTree();
    }
}
