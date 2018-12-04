package com.wfs.devideConqur;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MergeSortWith_O_1 {
    private int arr[];

    public MergeSortWith_O_1(int[] arr) {
        this.arr = arr;
    }

    public void mergeSort() {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++)
            maxElement = Math.max(maxElement, arr[i]);
        mergeSortRec(0, arr.length - 1, maxElement+1);
    }

    void mergeSortRec(int start, int end, int maxElement) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortRec(start, mid, maxElement);
            mergeSortRec(mid + 1, end, maxElement);
            merge(start, mid, end, maxElement);
        }
    }

    public void merge(int start, int mid, int end, int maxElement) {
        int i = start;
        int j = mid + 1;
        int k = start;
        while (i <= mid && j <= end) {
            int x =arr[i] %  maxElement; int y =arr[j] % maxElement;
            if (arr[i] %  maxElement <=arr[j] % maxElement ) {
                arr[k] = arr[k] + (arr[i] %
                        maxElement) * maxElement;
                k++;
                i++;
            } else {
                arr[k] = arr[k] +
                        (arr[j] % maxElement) *
                                maxElement;
                k++;
                j++;
            }
        }
        while (i <= mid) {
            arr[k] = arr[k] + (arr[i] %
                    maxElement) * maxElement;
            k++;
            i++;
        }
        while (j <= end) {
            arr[k] = arr[k] + (arr[j] %
                    maxElement) * maxElement;
            k++;
            j++;
        }

        // Obtaining actual values
        for (i = start; i <= end; i++)
            arr[i] = arr[i] / maxElement;
    }

    public static void main(String[] args) {
        MergeSortWith_O_1 sort = new MergeSortWith_O_1(new int[]{2,5,7,4,9});
        sort.merge(0 ,2 , sort.arr.length-1, 10);
        for (int i = 0; i < sort.arr.length; i++) {
            System.out.println(sort.arr[i]);
        }
    }
}
