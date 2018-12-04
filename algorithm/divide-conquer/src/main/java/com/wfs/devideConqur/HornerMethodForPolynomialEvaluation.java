package com.wfs.devideConqur;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class HornerMethodForPolynomialEvaluation {

    private int arr[];

    private int k;

    public HornerMethodForPolynomialEvaluation(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    public int evaluate(){
        int result =arr[0]*k ;
        int count = k-1 ;
        for(int i=1;i<arr.length;i++){
            result =+ arr[i];
            if(count>0)
                result =result* count--;
        }
        return result;
    }

    public static void main(String[] args) {
        HornerMethodForPolynomialEvaluation method =new HornerMethodForPolynomialEvaluation(new int[]{2, -6, 2, -1},3);
        System.out.println(method.evaluate());
    }
}
