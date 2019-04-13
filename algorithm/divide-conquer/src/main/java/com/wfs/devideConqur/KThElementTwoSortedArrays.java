package com.wfs.devideConqur;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class KThElementTwoSortedArrays {
    private int arr1[];

    private int arr2[];

    private int k;

    public KThElementTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.k = k;
    }

    public int getKthHigest(){
        return getKthHighest(0 , arr1.length-1 , 0,arr2.length-1,k);
    }

    private int getKthHighest(int i1,int j1, int i2, int j2, int kth){
        if(j1==i1)
            return arr2[i2+kth];
        if(i2==j2)
            return arr1[i1+kth];
        int mid1 = i1+ (j1-i1)/2;
        int mid2 = i2+ (j2-i2)/2;

        if(mid1+mid2 < kth){
            if(arr1[mid1]>arr2[mid2]){
                return getKthHighest(i1,j1,i2+mid2 , j2 , kth -mid2-1 );
            }else{
                return getKthHighest(i1+mid1 , j1 , i2,j2 , kth -mid1-1 );
            }
        }else{
            if(arr1[mid1]>arr2[mid2]){
                return getKthHighest(i1,i1+mid1,i2 , j2 , kth  );
            }else{
                return getKthHighest(i1 , j1 , i2,i2+mid2 , kth );
            }
        }
    }
    private int getKthHighestLogK(int[] arr1, int m, int[] arr2, int n, int k){
        if (k > (m + n) || k < 1)
        {
            return -1;
        }
        // let m <= n
        if (m > n) {
            return getKthHighestLogK(arr2, n, arr1, m, k);
        }
        // if arr1 is empty returning k-th element of arr2
        if (m == 0)  {
            return arr2[k - 1];
        }
        // if k = 1 return minimum of first two elements of both arrays
        if (k == 1) {
            return Math.min(arr1[0], arr2[0]);
        }
        // now the divide and conquer part
        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);
        if (arr1[i - 1] > arr2[j - 1])  {
            // Now we need to find only k-j th element since we have found out the lowest j
            return getKthHighestLogK(arr1, m, arr2 + j, n - j, k - j);
        }
        else {
            // Now we need to find only k-i th element since we have found out the lowest i
            return kth(arr1 + i, m - i, arr2, n, k - i);
        }

    }
}

