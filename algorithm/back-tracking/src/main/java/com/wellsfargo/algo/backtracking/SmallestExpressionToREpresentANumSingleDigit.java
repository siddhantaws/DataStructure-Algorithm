package com.wellsfargo.algo.backtracking;

public class SmallestExpressionToREpresentANumSingleDigit {

    private int minimum =Integer.MAX_VALUE;

    private void minLevel(int total , int N,int D ,int level){
        if(total==N){
            minimum =Math.min(minimum ,level);
            return;
        }
        if(level ==minimum)
            return;

        if(total%D == 0)
            minLevel(total/D , N ,D ,level+1);

        minLevel(total+D , N ,D ,level+1);

        if(total-D >0)
            minLevel(total-D , N ,D ,level+1);

        minLevel(total-D , N ,D ,level+1);
    }

    /*private boolean generate(int total , int N,int D ,int level){
        if(total==N)
            return true;
        if(level ==minimum)
            return false;

    }*/


}
