package com.wellsfargo.data_structure.tree;

public class LazyPropagationSegmentTree {
    private int arr[];

    private int segmentArr[];

    private int lazySegmentArr[];

    private int n;

    public LazyPropagationSegmentTree(int[] arr) {
        this.arr = arr;
        this.n=arr.length;
        this.segmentArr =new int[isPowerOf2(n) ? 2*n-1 : getNextPowerOf2(n)];
        this.lazySegmentArr =new int[isPowerOf2(n) ? 2*n-1 : getNextPowerOf2(n)];
        buildSegmentTree(0,n-1,0);
    }

    private boolean isPowerOf2(int num){
        return (num & num-1)==0;
    }

    private int getNextPowerOf2(int num){
        int count=0;
        while(num>0){
            num =(num & num-1);
            count++;
        }
        return 1<<count;
    }

    private void buildSegmentTree(int l ,int r ,int pos){
        if(l==r){
            segmentArr[pos] =arr[l];
            return;
        }
        int mid = l+(r-l)/2;
        buildSegmentTree(l,mid, 2*pos+1);
        buildSegmentTree(mid+1,r, 2*pos+2);
        segmentArr[pos] =Math.min(segmentArr[2*pos+1] , segmentArr[2*pos+2]);
    }


    public int getMinimum(int start , int end ,int l , int r , int pos){
        int mid =start+(end-start)/2;
        if( (start>l && end>r)  || (start<l && end<r)) // no verlap
            return Integer.MAX_VALUE;
        else if(l>=start && r<=end){ // partial  overlap
            int leftMin = getMinimum(start , mid ,  l, r, 2*pos+1);
            int rightMin =getMinimum(mid+1 , end ,  l, r, 2*pos+2);
            return Math.min(leftMin,rightMin);
        }else if ( (start>=l && end<=r)){
            return segmentArr[pos];
        }
        return -1;
    }

    public void update (int start , int end ,int l , int r , int pos, int updateVal){
        int mid =start+(end-start)/2;
        if( (start>l && end>r)  || (start<l && end<r)) // no verlap
            return ;
        if(lazySegmentArr[pos]!=0){
            propagateToDown(pos ,lazySegmentArr[pos] );
            segmentArr[pos]+=lazySegmentArr[pos];
            lazySegmentArr[pos]=0;
        }
        if(l>=start && r<=end){ // partial  overlap
            update(start , mid ,  l, r, 2*pos+1,updateVal);
            update(mid+1 , end ,  l, r, 2*pos+2,updateVal);
        }else if ( (start>=l && end<=r)){
            return ;
        }
    }

    private void propagateToDown(int pos, int value){
        if(2*pos+1 <lazySegmentArr.length)
            lazySegmentArr[2*pos+1]+=value;
        if(2*pos+2 <lazySegmentArr.length)
            lazySegmentArr[2*pos+2]+=value;
    }
}
