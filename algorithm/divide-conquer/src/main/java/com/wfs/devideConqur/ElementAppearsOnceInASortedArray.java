package com.wfs.devideConqur;

public class ElementAppearsOnceInASortedArray {
    private int[] arr;

    public ElementAppearsOnceInASortedArray(int[] arr) {
        this.arr = arr;
    }

    public int getUniqueElement(){
        return getUniqueElement(arr , 0 ,arr.length-1);
    }

    private int getUniqueElement(int arr[],int low,int high){
        if (low > high)
            return -1;

        if (low==high)
        {
            System.out.println("The required element is "+arr[low]);
            return -1;
        }

        // Find the middle point
        int mid = (low + high) / 2;

        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if (mid%2 == 0)
        {
            if (arr[mid] == arr[mid+1])
                getUniqueElement(arr, mid+2, high);
            else
                getUniqueElement(arr, low, mid);
        }
        else  // If mid is odd
        {
            if (arr[mid] == arr[mid-1])
                getUniqueElement(arr, mid-2, high);
            else
                getUniqueElement(arr, low, mid-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3, 3, 4, 4, 5, 5, 7, 7, 8,8} ;
        ElementAppearsOnceInASortedArray ele= new ElementAppearsOnceInASortedArray(arr);
        System.out.println(ele.getUniqueElement());
    }
}
