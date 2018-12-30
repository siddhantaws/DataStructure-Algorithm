package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class HornerMethodForPolynomialEvaluation {
    private int poly[];

    private int x;

    public HornerMethodForPolynomialEvaluation(int[] poly , int x ) {
        this.poly = poly;
        this.x = x;
    }

    public int evaluate(){
        int eval =0;
        for(int i=0;i<poly.length-1;i++){
            eval = (eval + poly[i])*x;
        }
        return eval +poly[poly.length-1];
    }

    public static void main(String[] args) {
        int arr []={2, -6, 2, -1};
        HornerMethodForPolynomialEvaluation method =new HornerMethodForPolynomialEvaluation(arr ,  3);
        method.evaluate();
    }
}
