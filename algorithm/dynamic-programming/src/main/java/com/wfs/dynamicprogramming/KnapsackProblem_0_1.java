package com.wfs.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Suryasnata on 5/23/2017.
 *
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 */
public class KnapsackProblem_0_1
{
    private int totalWeightSum ;

    private Map<Integer , Integer> weightToPriceMap;

    private int[][] tempArraySoln;
    private int[] tempArrayProiceSoln;

    public KnapsackProblem_0_1(int totalWeightSum, Map<Integer, Integer> weightToPriceMap) {
        this.totalWeightSum = totalWeightSum;
        this.weightToPriceMap = weightToPriceMap;
        tempArraySoln = new int[totalWeightSum+1][weightToPriceMap.size()+1];
        tempArrayProiceSoln = new int[totalWeightSum+1];
    }

    public List<Integer> getKnapsackSoln()
    {
        return  getKnapsackSoln(totalWeightSum  ,weightToPriceMap);
    }

    private List<Integer> getKnapsackSoln(int totalWeightSum ,Map<Integer , Integer> weightToPriceMap)
    {
        int i =1;
        for(Map.Entry<Integer , Integer > entry : weightToPriceMap.entrySet())
        {
            for(int j=1;i<tempArraySoln[i].length;j++)
            {
                if(entry.getKey() > tempArraySoln[i][j])
                    tempArraySoln[i][j]=tempArraySoln[i][j-1];
                else
                {
                    if((entry.getValue() + tempArraySoln[i-1][j -entry.getKey()] )  >tempArraySoln[i][j-1] )
                    {
                        tempArraySoln[i][j] = entry.getValue() + tempArraySoln[i-1][j -entry.getKey()] ;
                        tempArrayProiceSoln [j] = entry.getKey();
                    }else
                        tempArraySoln[i][j] = tempArraySoln[i][j-1] ;
                }
            }
            i++;
        }
        return null;
    }

    private List<Integer> getKnapsack()
    {
        /*weightToPriceMap.size()+1;
        while(totalWeightSum!=0)
        {
            tempArraySoln[][]
        }*/
        return  null;
    }


    public static void main(String[] args) {
        Map<Integer , Integer> map=new HashMap<>();map.put( 1,1 ) ;map.put( 4,3 ) ;map.put( 5,4 ) ;map.put( 7,5 ) ;
        KnapsackProblem_0_1  knapsackProblem_0_1 =new KnapsackProblem_0_1(7 , map );
    }
}
