package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class NumberOfPrimesInSubarray {

    private int[]arr;

    private boolean isPrime[];

    private static int MAX =1000;

    private int[] st;

    public NumberOfPrimesInSubarray(int[] arr) {
        this.arr = arr;
        this.isPrime=new boolean[MAX];
        this.st=new int[2*arr.length+1];
    }

    void sieveOfEratosthenes() {
        isPrime[1] = false;
        for (int p = 2; p * p <= MAX; p++) {
            // If prime[p] is not changed, then it is a prime
            if (isPrime[p] == true) {
                // Update all multiples of p
                for (int i = p * 2; i <= MAX; i += p)
                    isPrime[i] = false;
            }
        }
    }

    int getMid(int s, int e) {// A utility function to get the middle index from corner indexes.
        return s + (e - s) / 2;
    }

    public void constructSegmentTree(int l ,int r , int pos){
        if(l==r){
            if(isPrime[pos])
                st[pos] =1;
            else
                st[pos] =0;
        }
        int mid =getMid(l,r);
        constructSegmentTree(l,mid, 2*pos+1);
        constructSegmentTree(mid+1,r, 2*pos+2);
        st[pos] =  st[2*pos+1] +st[2*pos+2];
    }

    public int primeInRange(int l , int r ,int l1,int r1 , int pos){
        if(l1<=l && r1>=r)
            return st[pos];
        else if(l1>r ||  r1<l)
            return 0;
        else{
            int mid = l+(r-l)/2;
            int left = primeInRange(l,mid,l1,r1,2*pos+1);
            int right = primeInRange(mid+1,r,l1,r1,2*pos+2);
            return left+ right;
        }
    }
}
