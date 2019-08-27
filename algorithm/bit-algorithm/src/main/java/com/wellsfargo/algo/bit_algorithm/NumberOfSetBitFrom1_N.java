package com.wellsfargo.algo.bit_algorithm;

public class NumberOfSetBitFrom1_N {
    private int num;

    public NumberOfSetBitFrom1_N(int num) {
        this.num = num;
    }

    private int getCount(int num){
        if(num ==0)
            return 0;
        Double d =Math.log(num) /Math.log(2);
        int b= ((Double)Math.ceil((Double)d)).intValue();
        if(((num+1) &  num)==0){
            return b*((Double)Math.pow(2, b-1)).intValue();
        }
        return getCount(((Double)Math.pow(2, b-1)).intValue() -1)+
                getCount(num -((Double)Math.pow(2,b-1)).intValue()) + (num - ((Double)Math.pow(2,b)).intValue() + 1);
    }

    public int getCount(){
        return getCount(num);
    }

    public static void main(String[] args) {
        NumberOfSetBitFrom1_N numberOfSetBitFrom1_n =new NumberOfSetBitFrom1_N(14);
        System.out.println(numberOfSetBitFrom1_n.getCount());
    }

}
