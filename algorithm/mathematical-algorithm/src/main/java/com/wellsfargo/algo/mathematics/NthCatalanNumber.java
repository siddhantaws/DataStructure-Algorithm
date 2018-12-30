package com.wellsfargo.algo.mathematics;

public class NthCatalanNumber {
    private int num;

    public NthCatalanNumber(int num) {
        this.num = num;
    }

    public int getCalatalnNumber(){
        int numArray[]=new int[num+1];
        numArray[0]=numArray[1]=1;
        int count =0;

        for(int i=0;i<num;i++)
            for(int j=0;j<i;j++)
                numArray[i] =numArray[i]+(numArray[j]*numArray[i-j-1]);
            return numArray[num];
    }
}
