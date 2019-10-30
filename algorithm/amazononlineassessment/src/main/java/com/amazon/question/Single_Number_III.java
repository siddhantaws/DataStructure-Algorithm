package com.amazon.question;

public class Single_Number_III {

    private int arr[];

    public Single_Number_III(int[] arr) {
        this.arr = arr;
    }

    public int[] singleNumber(){
        return  singleNumber(arr);
    }

    private int[] singleNumber(int nums[]) {
        int temp[] =new int[2];
        int xor =nums[0];
        for(int i=1;i<nums.length;i++)
            xor =xor^ nums[i];
        int left =-1; int right=-1;
        boolean leftI =false ;boolean rightI= false;
        xor = xor & ~(xor-1);
        for(int i=0;i<nums.length;i++){
            if((nums[i] & xor)==0){
                if(!leftI){
                    leftI =!leftI;
                    left=nums[i];
                }else{
                    left^=nums[i];
                }
            }else{
                if(!rightI){
                    rightI =!rightI;
                    right=nums[i];
                }else{
                    right^=nums[i];
                }
            }
        }
        temp[0]=left;temp[1]=right;
        return temp;
    }

    public static void main(String[] args) {
        Single_Number_III numberIii =new Single_Number_III(new int[]{1,2,1,3,2,5});
        for(int ar : numberIii.singleNumber())
            System.out.println(ar);
    }
}
