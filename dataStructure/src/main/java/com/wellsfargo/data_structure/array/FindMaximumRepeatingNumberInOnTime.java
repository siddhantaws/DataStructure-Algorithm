package com.wellsfargo.data_structure.array;

public class FindMaximumRepeatingNumberInOnTime {

    private int arr[];

    private int k;

    public FindMaximumRepeatingNumberInOnTime(int[] arr , int k) {
        this.arr = arr;
        this.k = k;
    }

    int maxRepeating()
    {
        int  n =arr.length;
        // Iterate though input array, for every element
        // arr[i], increment arr[arr[i]%k] by k
        for (int i = 0; i< n; i++)
            arr[(arr[i]%k)] += k;

        // Find index of the maximum repeating element
        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }

        /* Uncomment this code to get the original array back */
        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k;

        // Return index of the maximum element
        return result;
    }

    public static void main(String[] args) {
        FindMaximumRepeatingNumberInOnTime numberInOnTime =new FindMaximumRepeatingNumberInOnTime(new int[]{2, 3, 45, 45, 3, 45, 1, 7} , 8);
        System.out.println(numberInOnTime.maxRepeating());
    }

}
