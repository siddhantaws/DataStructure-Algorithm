package com.wellsfargo.data_structure.tree;

import java.util.Arrays;

public class NumberElementsLessThanEqualToGivenNumberInSubarray {

    private Element[] inputArray;

    private Query[] inputQuery;

    private int[] bitArray;

    private int[] ans;

    public NumberElementsLessThanEqualToGivenNumberInSubarray(Element[] inputArray, Query[] inputQuery) {
        this.inputArray = inputArray;
        this.inputQuery = inputQuery;
        this.bitArray =new int[inputArray.length+1];
        this.ans=new int[inputQuery.length];
    }

    // updating the bit array
    private void update(int bit[], int idx, int val, int n)
    {
        for (; idx<=n; idx +=idx&-idx)
            bit[idx] += val;
    }

    public void answerQuries(){
        Arrays.sort(inputArray);
        Arrays.sort(inputQuery);

        // current index of array
        int curr = 0;

        for(int i=0;i<ans.length;i++){
            while (inputArray[curr].value <= inputQuery[i].x && curr<inputArray.length)
            {
                // updating the bit array for the array index
                update(bitArray, inputArray[curr].idx+1, 1, inputArray.length);
                curr++;
            }

            // Answer for each Query will be number of
            // values less than equal to x upto r minus
            // number of values less than equal to x
            // upto l-1
            ans[inputQuery[i].idx] = query(bitArray, inputQuery[i].r+1, inputArray.length) -
                                     query(bitArray, inputQuery[i].l, inputArray.length);
        }

        // printing answer for each Query
        for (int i=0 ; i<inputQuery.length; i++)
            System.out.println("ans =>"+i +"\t"+ans[i]);
    }

    // querying the bit array
    int query(int bit[], int idx, int n)
    {
        int sum = 0;
        for (; idx > 0; idx -= idx&-idx)
            sum += bit[idx];
        return sum;
    }

    public static void main(String[] args) {
        Element[] inputArray =new Element[7];
        inputArray[0]=new Element(2,0);
        inputArray[1]=new Element(6,1);
        inputArray[2]=new Element(4,2);
        inputArray[3]=new Element(7,3);
        inputArray[4]=new Element(5,4);
        inputArray[5]=new Element(7,5);
        inputArray[6]=new Element(4,6);
        Query[] inputQuery=new Query[1];
        inputQuery[0] =new Query(0,3,5 ,0);
        //inputQuery[1] =new Query(2,5,5 ,4);
        //inputQuery[1] =new Query(0,2,2 ,1);
        NumberElementsLessThanEqualToGivenNumberInSubarray toGivenNumberInSubarray =new NumberElementsLessThanEqualToGivenNumberInSubarray(inputArray,inputQuery );
        toGivenNumberInSubarray.answerQuries();
    }

}
class Query implements Comparable{
    int l, r, x, idx;

    public Query(int l, int r, int x, int idx) {
        this.l = l;
        this.r = r;
        this.x = x;
        this.idx = idx;
    }
    @Override
    public int compareTo(Object o) {
        return this.x-((Query)o).x  ;
    }

    @Override
    public String toString() {
        return "left->"+l+" "+"right->"+r+" "+ "x->"+x +" "+ "idx->"+idx;
    }
}

class Element implements Comparable<Element> {
    int value, idx;

    public Element(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }

    @Override
    public int compareTo(Element o) {
        return this.value - o.value ;
    }

    @Override
    public String toString() {
        return "value->"+value+" idx->"+idx;
    }
}