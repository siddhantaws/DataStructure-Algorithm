package com.amazon.question;

public class MaximumProductSubarray {
    private int arr[];

    public MaximumProductSubarray(int[] arr) {
        this.arr = arr;
    }

    public int maxProduct() {
        int positiveMaxProduct = 1;
        int negetiveMinProduct = 1;
        int currMax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                positiveMaxProduct *=arr[i];
                currMax = Math.max(positiveMaxProduct,currMax);
                if(negetiveMinProduct<0)
                    negetiveMinProduct =Math.min(negetiveMinProduct *arr[i] ,negetiveMinProduct);
            }else if(arr[i]==0){
                positiveMaxProduct=1;
                negetiveMinProduct=1;
                currMax = Math.max(currMax,0);
            }else{
                if(negetiveMinProduct<0){
                    negetiveMinProduct*=arr[i];
                    positiveMaxProduct =Math.max (negetiveMinProduct,positiveMaxProduct);
                    currMax =  Math.max(positiveMaxProduct,currMax);
                    negetiveMinProduct=arr[i];
                }else{
                    negetiveMinProduct= Math.min( positiveMaxProduct* arr[i], arr[i]);
                    currMax =  Math.max(negetiveMinProduct,currMax);
                    positiveMaxProduct=1;
                }
            }
        }
        return currMax ;
    }

    public static void main(String[] args) {
        MaximumProductSubarray productSubarray =new MaximumProductSubarray(new int[]{-1,-2,-9,-6});
        System.out.println(productSubarray.maxProduct());
    }
}
