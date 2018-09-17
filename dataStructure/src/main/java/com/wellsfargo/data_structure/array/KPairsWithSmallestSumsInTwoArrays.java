package com.wellsfargo.data_structure.array;

public class KPairsWithSmallestSumsInTwoArrays {

    private int arr1[];

    private int arr2[];

    private int k;

    public KPairsWithSmallestSumsInTwoArrays(int[] arr1, int[] arr2 , int k) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.k = k;
    }

    public void getKthSmallestPair(){

        if (k > arr1.length*arr2.length)
        {
            System.out.print("k pairs don't exist");
            return ;
        }

        int index2[] = new int[arr1.length];

        while (k > 0) {
            // Initialize current pair sum as infinite
            int min_sum = Integer.MAX_VALUE;
            int min_index = 0;

            // To pick next pair, traverse for all
            // elements of arr1[], for every element, find
            // corresponding current element in arr2[] and
            // pick minimum of all formed pairs.
            for (int i1 = 0; i1 < arr1.length; i1++)
            {
                // Check if current element of arr1[] plus
                // element of array2 to be used gives
                // minimum sum
                if (index2[i1] < arr2.length
                        && arr1[i1] + arr2[index2[i1]] < min_sum)
                {
                    // Update index that gives minimum
                    min_index = i1;

                    // update minimum sum
                    min_sum = arr1[i1] + arr2[index2[i1]];
                }
            }
            System.out.print("(" + arr1[min_index] + ", " +
                    arr2[index2[min_index]]+ ") ");

            index2[min_index]++;
            k--;
        }
    }

    public static void main(String[] args) {
        KPairsWithSmallestSumsInTwoArrays kPairs = new KPairsWithSmallestSumsInTwoArrays(new int[]{1, 3, 11}, new int[]{2, 4, 8} , 3);
        kPairs.getKthSmallestPair();
    }
}
