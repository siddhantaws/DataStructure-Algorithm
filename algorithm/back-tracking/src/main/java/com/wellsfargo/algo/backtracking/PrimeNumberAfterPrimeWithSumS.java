package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrimeNumberAfterPrimeWithSumS {

    private List<Integer> primeInt;
    private Stack<Integer> intStack;
    private int N;
    private int sum;

    public PrimeNumberAfterPrimeWithSumS(int N , int sum){
        this.N=N;
        this.sum=sum;
        this.intStack=new Stack<>();
        this.primeInt=new ArrayList<>();
    }

    private boolean isPrime(int num) {
        if (num == 1)
            return true;
        int sqrt = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private void getAllPrime(int start , int end){
        for(int i=start+1 ;i<end;i++)
            if(isPrime(i))
                primeInt.add(i);
    }

    public void generatePrimeSum(){
        getAllPrime(N,sum);
        generatePrimeSum(0 ,0);
    }
    private void generatePrimeSum(int currSum , int index){
        if(currSum==sum){
           flush();
           return;
        }
        if(currSum>sum || index> primeInt.size())
            return;
        for(int i=index;i<primeInt.size();i++){
            intStack.push(primeInt.get(i));
            generatePrimeSum(currSum+primeInt.get(i), i++);
            intStack.pop();
            generatePrimeSum(currSum, i++);
        }
    }

    private void flush(){
        for(int i=0;i<intStack.size();i++)
            System.out.println(intStack.get(i));
    }

    public static void main(String[] args) {
        PrimeNumberAfterPrimeWithSumS withSumS =new PrimeNumberAfterPrimeWithSumS(5 , 18);
        withSumS.generatePrimeSum();
    }
}
