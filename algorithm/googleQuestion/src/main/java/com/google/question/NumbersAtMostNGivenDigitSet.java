package com.google.question;

import java.util.*;

public class NumbersAtMostNGivenDigitSet {
    private String strArr[];

    private int N;

    private TreeSet<Integer> treeSet;

    private Map<Integer , TreeMap<Integer,Integer>> mapOfDigitCount;

    public NumbersAtMostNGivenDigitSet(String[] strArr, int n) {
        this.strArr = strArr;
        this.treeSet =new TreeSet();
        for(String s :strArr)
            treeSet.add(new Integer(s));
        N = n;
        this.mapOfDigitCount= new HashMap<>();
        init();
    }

    private void init(){
        TreeMap<Integer,Integer> integerMap =new TreeMap();
        for(int x :treeSet){
            Map.Entry<Integer,Integer>  entry =integerMap.headMap(x,false).lastEntry();
            if(entry!=null)
                integerMap.put(x, integerMap.get(entry.getKey())+1);
            else
                integerMap.put(x, 1);
        }
        mapOfDigitCount.put(1 , integerMap);
    }

    public int atMostNGivenDigitSet() {
        int num=N;int count =0;
        while(num>0){
            num =num/10;
            count++;
        }
        for(int i=2;i<=count;i++){
            TreeMap<Integer,Integer> integerMap =new TreeMap();
            TreeMap<Integer,Integer> prevIntegerMap =(TreeMap<Integer,Integer>) mapOfDigitCount.get(i-1);
            for(int x :treeSet){
                Map.Entry<Integer,Integer>  entry =prevIntegerMap.headMap(x,false).lastEntry();
                if(entry!=null)
                    integerMap.put(x , prevIntegerMap.get(prevIntegerMap.lastKey())+integerMap.get(entry.getKey()));
                 else
                    integerMap.put(x , 2*prevIntegerMap.get(prevIntegerMap.lastKey()));
            }
            mapOfDigitCount.put(i , integerMap);
        }
        int totalCount =0;num=N;
        while(num>0){
            int lastNum = (int) (num / Math.pow(10,count-1));
            if (count>1)
                totalCount+=mapOfDigitCount.get(count-1).get(mapOfDigitCount.get(count-1).lastKey());
            SortedMap<Integer,Integer> lastKeyExclusive = mapOfDigitCount.get(count).headMap(lastNum,false);
            SortedMap<Integer,Integer> lastKeyInclusive = mapOfDigitCount.get(count).headMap(lastNum,true);
            if(!lastKeyExclusive.isEmpty())
                totalCount+= mapOfDigitCount.get(count).get(lastKeyExclusive.lastKey());
             num -= Math.pow(10,--count)*(lastKeyInclusive.isEmpty() ? 1 : lastKeyInclusive.lastKey());
        }
        return totalCount;
    }

    public static void main(String[] args) {
        String str[]={"1","3","5","7"};
        NumbersAtMostNGivenDigitSet givenDigitSet =new NumbersAtMostNGivenDigitSet(str , 100);
        System.out.println(givenDigitSet.atMostNGivenDigitSet());
    }
}
