package com.amazon.question;

import java.util.*;

public class RandomizedSet {

    private Map<Integer,Integer> integerMap ;

    private List<Integer> integerList;

    Random r ;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.integerMap =new HashMap<>();
        this.integerList =new ArrayList<>();
        this.r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(integerMap.containsKey(val))
            return false;
        integerList.add(val);
        integerMap.put(val,integerList.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(integerList.size()==0)
            return false;
        if(!integerMap.containsKey(val))
            return false;
        int index =integerMap.remove(val);
        if(integerMap.size()==0){
            integerList.remove(integerList.size()-1);
            return true;
        }
        if(index== integerList.size()-1) {
            integerList.remove(integerList.size()-1);
            return true;
        }
        Collections.swap(integerList, index , integerList.size()-1);
        integerList.remove(integerList.size()-1);
        integerMap.put(integerList.get(index) , index);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return integerList.get(r.nextInt(integerList.size()) );
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet =new RandomizedSet();
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(3));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.remove(0));
    }
}
