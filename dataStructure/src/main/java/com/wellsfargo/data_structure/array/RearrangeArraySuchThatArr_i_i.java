package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RearrangeArraySuchThatArr_i_i {

    private int arr[];

    public RearrangeArraySuchThatArr_i_i(int[] arr) {
        this.arr = arr;
    }

    public void reArrange(){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=i){
                int temp = arr[arr[i]];
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={1,3,0,6,2,4,5};
        RearrangeArraySuchThatArr_i_i thatArrII =new RearrangeArraySuchThatArr_i_i(arr);
        thatArrII.reArrange();
    }
}
