package com.wfs.amazon.graph;

import java.util.Random;

public class _973KClosestPointsOrigin {
    private int[][] points;
    private int K;

    public _973KClosestPointsOrigin(int[][] points, int k) {
        this.points = points;
        K = k-1;

    }
    public int[][] kClosest() {
        int initialPoints = kClosest( 0 , points.length-1 , K);
        int returedArr[][]= new int[initialPoints-0+1][2];
        System.arraycopy(points, 0 ,returedArr ,0 ,returedArr.length);
        return returedArr;
    }
    private int kClosest(int l, int r,int k){
        if(l==r){
            return l;
        }
        int pivotIndex = l + new Random().nextInt(r-l);
        int pos= quickSelect(l , r , pivotIndex);
        if(pos==k)
            return pos;
        else if(pos>k)
            return kClosest(l,pos-1,k);
        else
            return kClosest(pos+1,r,k);
    }

    private int quickSelect(int l,int r, int pivotIndex){
        swap(pivotIndex,r);
        int pivotPoint[]  = points[pivotIndex];
        pivotIndex =l;
        for(int i=l;i<=r;i++){
            if(diffDistances(i)<diffDistances(r)){
                swap(i,l);
                pivotIndex++;
            }
        }
        swap(pivotIndex,r);
        return pivotIndex;
    }

    private int diffDistances(int l){
        return Math.abs(points[l][0]) + Math.abs(points[l][1]);
    }

    private void swap(int l , int r){
        points[l][0] =points[l][0]^points[r][0];
        points[r][0] =points[l][0]^points[r][0];
        points[l][0] =points[l][0]^points[r][0];
        points[l][1] =points[l][1]^points[r][1];
        points[r][1] =points[l][1]^points[r][1];
        points[l][1] =points[l][1]^points[r][1];
    }

    public static void main(String[] args) {

    }
}

