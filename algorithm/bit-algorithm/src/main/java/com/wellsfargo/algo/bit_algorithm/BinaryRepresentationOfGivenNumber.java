package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class BinaryRepresentationOfGivenNumber {
    private int num ;

    public BinaryRepresentationOfGivenNumber(int num) {
        this.num = num;
    }

    public String getAsBinary(){
        int x =num;
        StringBuffer sb=new StringBuffer();
        long i=1 << 31;
        for( ;i>0;i=i>>1)
            sb.append((num & i )> 0 ? "1" : "0");
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryRepresentationOfGivenNumber ofGivenNumber =new BinaryRepresentationOfGivenNumber(5);
        System.out.println(ofGivenNumber.getAsBinary());
    }
}
