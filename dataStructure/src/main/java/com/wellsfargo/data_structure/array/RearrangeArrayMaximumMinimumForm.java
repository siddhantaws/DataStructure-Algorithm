package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RearrangeArrayMaximumMinimumForm {

    private int arr[];

    public RearrangeArrayMaximumMinimumForm(int[] arr) {
        this.arr = arr;
    }
    public void rearrange(){
        // initialize index of first minimum and first  maximum element
        int max_idx = arr.length - 1, min_idx = 0;
        // store maximum element of array
        int max_elem = arr[max_idx] + 1;
        // traverse array elements
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {// at even index : we have to put maximum element
                int num = (arr[max_idx] % max_elem) * max_elem;
                arr[i] += num;
                max_idx--;
            } else {// at odd index : we have to put minimum element
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }
        // array elements back to it's original form
        for (int i = 0; i < arr.length - 1; i++)
            arr[i] = arr[i] / max_elem;

        print();
    }

    private void print(){
        for(int i = 0; i < arr.length - 1; i++)
            System.out.print(arr[i]+" ");
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        RearrangeArrayMaximumMinimumForm  minimumForm =new RearrangeArrayMaximumMinimumForm(arr);
        minimumForm.rearrange();
    }
}
