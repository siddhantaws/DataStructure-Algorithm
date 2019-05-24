package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SumNodesKLevelInTreeRepresentedString {
    private String str;

    private int K;

    private int index;

    private int sum ;
    public SumNodesKLevelInTreeRepresentedString(String str, int k) {
        this.str = str;
        this.K = k;
    }

    public int calculateSum(){
        return calculateSum(0);
    }

    public int calculateSum(int k ){
        if(str.charAt(++index)==')')
            return sum;
        if(k==K){
            sum =sum + str.charAt(index) -'0';
        }
        if(index<str.length() && str.charAt(++index)=='(')
            calculateSum(k+1);
        if(index<str.length() &&  str.charAt(++index)=='(')
            calculateSum(k+1);
        if(index<str.length() &&  str.charAt(index++)==')')
            return sum;
        return sum;
    }

    public static void main(String[] args) {
        SumNodesKLevelInTreeRepresentedString representedString =new SumNodesKLevelInTreeRepresentedString("(0(5(6()())(4()(9()())))(7(1()())(3()())))", 3);
        System.out.println(representedString.calculateSum());
    }

}
