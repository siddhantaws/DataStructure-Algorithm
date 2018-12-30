package com.wellsfargo.data_structure.matrix;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MedianInRowWiseSortedMatrix {

    private int arr[][] ;

    private int min = Integer.MAX_VALUE;

    private int max =Integer.MIN_VALUE ;

    public MedianInRowWiseSortedMatrix(int[][] arr) {
        this.arr = arr;
        calculateMinAndMax();
    }

    private void calculateMinAndMax(){
        for(int i=0;i<arr.length-1;i++)
            min =Math.min(min , arr[i][0]);
        for(int i=0;i<arr.length-1;i++)
            max =Math.max(max , arr[i][arr[0].length-1]);
    }

    public int getMedian() {
        int desired = (arr.length * arr[0].length + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            // Find count of elements smaller than mid
            for(int i = 0; i < arr.length; ++i) {
                get = Arrays.binarySearch(arr[i],mid);
                // If element is not found in the array the binarySearch() method returns
                // (-(insertion_point) - 1). So once we know the insertion point we can find elements
                // Smaller than the searched element by the following calculation
                if(get < 0)
                    get = Math.abs(get) - 1;
                // If element is found in the array it returns the index(any index in case of duplicate). So we go to last
                // index of element which will give  the number of elements smaller than the number including  the searched element.
                else {
                    while(get < arr[i].length && arr[i][get] == mid)
                        get += 1;
                }
                place = place + get;
            }
            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static void main(String[] args) {
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
        MedianInRowWiseSortedMatrix median=new MedianInRowWiseSortedMatrix(m);
        System.out.println(median.getMedian());
    }
}
