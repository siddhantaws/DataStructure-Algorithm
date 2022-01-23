package com.wfs.amazon.dynamicprograming;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _465OptimalAccountBalancing {
    private int[][] transactions;

    private int minTransaction = Integer.MAX_VALUE;

    public _465OptimalAccountBalancing(int[][] transactions) {
        this.transactions = transactions;
    }
    public int minTransfers() {
        Map<Integer,Integer> mapOfSettelement =new HashMap<>();
        for(int i=0;i<transactions.length;i++){
            mapOfSettelement.put(transactions[i][0] , mapOfSettelement.getOrDefault(transactions[i][0] , 0)-transactions[i][2] );
            mapOfSettelement.put(transactions[i][1] , mapOfSettelement.getOrDefault(transactions[i][1] , 0)+transactions[i][2] );
        }
        Stack<Integer> stackOfPositiveElement = new Stack<>();
        Stack<Integer> stackOfNegetiveElement = new Stack<>();
        for(Map.Entry<Integer, Integer> entry :mapOfSettelement.entrySet()){
            if(entry.getValue()>0)
                stackOfPositiveElement.push(entry.getValue());
            else
                stackOfNegetiveElement.push(entry.getValue());
        }

        return minimumTrasaction(stackOfPositiveElement,stackOfNegetiveElement);
    }

    private int minimumTrasaction(Stack<Integer> stackOfPositiveElement , Stack<Integer> stackOfNegetiveElement){
        if(stackOfNegetiveElement.isEmpty())
            return 0;
        while(!stackOfPositiveElement.isEmpty()){
            int lastPositive = stackOfPositiveElement.pop();
            int lastNegetive = stackOfNegetiveElement.pop();
            if(-1*lastNegetive==lastPositive){
                minTransaction =Math.min(minTransaction , 1+minimumTrasaction(stackOfPositiveElement ,stackOfNegetiveElement));
            }else if (-1*lastNegetive<lastPositive){
                stackOfPositiveElement.push(lastPositive +lastNegetive);
                minTransaction =Math.min(minTransaction , 1+minimumTrasaction(stackOfPositiveElement ,stackOfNegetiveElement));
            }else{
                stackOfNegetiveElement.push(lastPositive +lastNegetive);
                minTransaction =Math.min(minTransaction , 1+minimumTrasaction(stackOfPositiveElement ,stackOfNegetiveElement));
            }
            stackOfPositiveElement.push(lastPositive);
            stackOfPositiveElement.push(lastNegetive);
        }
        return minTransaction;
    }

    public static void main(String[] args) {
        int arr[][] = {{0,1,10}, {2,0,5}};
        _465OptimalAccountBalancing accountBalancing =new _465OptimalAccountBalancing(arr);
        System.out.println(accountBalancing.minTransfers());
    }
}
