package com.google.question;

public class WiggleSort_II {

    private int num[];

    public WiggleSort_II(int[] num) {
        this.num = num;
    }

    public void wiggleSort() {
        for(int i=0;i<num.length-1;i++){
            if(i%2==0){
                if(num[i]>num[i+1])
                    swap(i,i+1);
            }else{
                if(num[i]<num[i+1])
                    swap(i,i+1);
            }
        }
    }

    private void swap(int i,int j ){
        num[i] = num[i] ^ num[j];
        num[j] = num[i] ^ num[j];
        num[i] = num[i] ^ num[j];
    }
}
