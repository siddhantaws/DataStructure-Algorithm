package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class KSmallestElementsInSameOrderUsing_O_1ExtraSpace {

    private int arr[];

    private int k;

    public KSmallestElementsInSameOrderUsing_O_1ExtraSpace(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    public void printKthSmallest(){

        // For each arr[i] find whether  it is a part of n-smallest with insertion sort concept
        for (int i = k; i < arr.length; ++i) {
            // find largest from first k-elements
            int max_var = arr[k-1];
            int pos = k-1;
            for (int j=k-2; j>=0; j--) {
                if (arr[j] > max_var) {
                    max_var = arr[j];
                    pos = j;
                }
            }
            // if largest is greater than arr[i] shift all element one place left
            if (max_var > arr[i]) {
                int j = pos;
                while (j < k-1) {
                    arr[j] = arr[j+1];
                    j++;
                }
                // make arr[k-1] = arr[i]
                arr[k-1] = arr[i];
            }
        }
        // print result
        for (int i=0; i<k; i++)
            System.out.println(arr[i]);
    }

    public static void main(String[] args) {
        int arr1[]={20,15,17,18,10,5,4,3,2,1};
        KSmallestElementsInSameOrderUsing_O_1ExtraSpace elements =new KSmallestElementsInSameOrderUsing_O_1ExtraSpace(arr1, 5);
        elements.printKthSmallest();
    }
}
