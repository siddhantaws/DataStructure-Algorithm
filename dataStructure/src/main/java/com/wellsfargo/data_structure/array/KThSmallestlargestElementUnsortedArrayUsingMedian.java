package com.wellsfargo.data_structure.array;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class KThSmallestlargestElementUnsortedArrayUsingMedian {

    private int arr[];

    private int k ;

    public KThSmallestlargestElementUnsortedArrayUsingMedian(int[] arr, int k) {
        this.arr = arr;
        this.k=k;
    }

    private int findMedian(int start ,int end ) {
        if(end >arr.length)
            end = start + (arr.length-start-1);
        Arrays.sort(arr ,start,end);
        return arr[start + ((end-start)/2)];   // Return middle element
    }

    private int partitionPractise(int[] arr, int low, int high, int pivot) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                swap(arr, i, high);
                break;
            }
        }
        int index = low - 1;
        int i = low;
        while (i < high) {
            if (arr[i] < pivot) {
                index++;
                swap(arr, i, index);
            }
            i++;
        }
        index++;
        swap(arr, index, high);
        return index;
    }

    public int getKthSmallest(){
        return kthSmallest(arr , 0 ,arr.length-1,k);
    }

    public int kthSmallest(int arr[], int l, int r, int k) {// Returns k'th smallest element in arr[l..r] in worst case  linear time. ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT

        if (k > 0 && k <= r - l + 1) {// If k is smaller than number of elements in array
            int n = r-l+1; // Number of elements in arr[l..r]
            int i;// Divide arr[] in groups of size 5, calculate median of every group and store it in median[] array.
            int median[] =new int[(n+4)/5]; // There will be floor((n+4)/5) groups;
            for (i=0; i<=n/5; i++)
                median[i] = findMedian(i*5, ((i*5) +5)-1);
            // Find median of all medians using recursive call. If median[] has only one element, then no need of recursive call
            int medOfMed = (i == 1)? median[i-1]: kthSmallest(median, 0, i-1, i/2);
            // Partition the array around a random element and get position of pivot element in sorted array
            int partition = partitionPractise(arr, l, r, medOfMed);
            // If position is same as k
            if (partition - l == k - 1) {
                return arr[partition];
            }

            if (partition - l > k - 1) {
                return kthSmallest(arr, l, partition - 1, k);
            }
            return kthSmallest(arr, partition + 1, r, k - (partition + 1) + l);
        }
        // If k is more than number of elements in array
        return -1;
    }

    private void swap(int arr[],int source, int dest) {
        try{
            arr[source] = arr[source] ^ arr[dest];
            arr[dest] = arr[source] ^ arr[dest];
            arr[source] = arr[source] ^ arr[dest];
        }catch (Exception e){
            System.out.println(e);
            System.out.println(source+" " + dest);
            throw e;
        }
    }

    public static void main(String[] args) {
        int arr[]={12, 3, 5, 7, 4, 19, 26};int k =3;
        KThSmallestlargestElementUnsortedArrayUsingMedian arrayUsingMedian =new KThSmallestlargestElementUnsortedArrayUsingMedian(arr ,k );
        System.out.println(arrayUsingMedian.getKthSmallest());
    }
}
