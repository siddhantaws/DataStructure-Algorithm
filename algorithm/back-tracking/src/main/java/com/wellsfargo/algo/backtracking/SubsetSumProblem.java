package com.wellsfargo.algo.backtracking;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SubsetSumProblem {

    private int[] numArray;

    private int sumTotal;

    private List<Integer> subsetSum;

    public SubsetSumProblem(int[] numArray, int sumTotal) {
        this.numArray = numArray;
        this.sumTotal = sumTotal;
        this.subsetSum =new LinkedList<>();
    }

    public void getSubSetSum()
    {
        getSubSetSum(sumTotal , 0 , numArray.length-1);
    }

    private void getSubSetSum(int sum ,int source , int dest)
    {
        if(sum==0)
        {
            flush();
            return ;
        }else if(sum<=0 || source >dest)
        {
            return ;
        }else
        {
            for(int i=source;i<=dest;i++) {
                ((LinkedList)subsetSum).addFirst(numArray[i]);
                getSubSetSum(sum-numArray[i] , i+1, dest);
                ((LinkedList)subsetSum).removeLast();
            }
        }
    }

    private void flush()
    {
        StringBuffer sb=new StringBuffer();
        Iterator iterator =subsetSum.iterator();
        while(iterator.hasNext())
        {
            sb.append(iterator.next()+",");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int set[] = {5 , 6 , 3 , 4} ;int sum =9;
        SubsetSumProblem subsetSumProblem=new SubsetSumProblem(set , sum);
        subsetSumProblem.getSubSetSum();
    }
}
