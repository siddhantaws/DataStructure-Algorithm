package com.wfs.amazon.tree;

import java.util.*;

public class _1172DinnerPlateStacks {


    private int capacity ;

    private LinkedHashMap<Integer , Stack<Integer>> integerQueueMap;

    private TreeSet<Integer> integerTreeSet ;

    private int lastEntry ;
    public _1172DinnerPlateStacks(int capacity) {
        this.capacity =capacity;
        this.integerQueueMap =new LinkedHashMap<>();
        integerQueueMap.put(0 , new Stack<>());
        this.lastEntry= 0;
        this.integerTreeSet =new TreeSet<>();
    }

    public void push(int val) {
        if(!integerTreeSet.isEmpty()){
            if(integerQueueMap.get(integerTreeSet.first()).size()<capacity){
                integerQueueMap.get(integerTreeSet.first()).push(val);
                if(integerQueueMap.get(integerTreeSet.first()).size()==capacity)
                    integerTreeSet.remove(integerTreeSet.first());
            }
            return;
        }
        if(integerQueueMap.get(lastEntry)!=null){
            if(integerQueueMap.get(lastEntry).size()< capacity){
                integerQueueMap.get(lastEntry).push(val);
            }else{
                integerQueueMap.put(++lastEntry , new Stack<>());
                integerQueueMap.get(lastEntry).add(val);
            }
        }
    }

    public int pop() {
        if(integerQueueMap.get(lastEntry)!=null){
            int returned  = integerQueueMap.get(lastEntry).pop();
            if(integerQueueMap.get(lastEntry).isEmpty()){
                integerQueueMap.remove(lastEntry);
                lastEntry=getLastEntry(lastEntry-1);
            }
            return returned;
        }
        return -1;
    }

    private int getLastEntry(int index){
        while(integerQueueMap.get(index)!=null &&  integerQueueMap.get(index).isEmpty())
            index--;
        return index==-1 ? 0 : index;
    }

    public int popAtStack(int index) {
        if(integerQueueMap.get(index)!=null && integerQueueMap.get(index).size()>0){
            int poppedElement  =integerQueueMap.get(index).pop();
            if(!integerTreeSet.contains(index))
                integerTreeSet.add(index);
            if(integerQueueMap.get(index).isEmpty() && index==lastEntry)
                lastEntry=getLastEntry(lastEntry-1);
            return poppedElement;
        }
        return -1;
    }

    public static void main(String[] args) {
       /* _1172DinnerPlateStacks plateStacks =new _1172DinnerPlateStacks(2);
        plateStacks.push(1);plateStacks.push(2);plateStacks.push(3);plateStacks.push(4);plateStacks.push(5);
        System.out.println(plateStacks.popAtStack(0));
        plateStacks.push(20);
        plateStacks.push(21);
        System.out.println(plateStacks.popAtStack(0));
        System.out.println(plateStacks.popAtStack(2));
        System.out.println(plateStacks.pop());

        System.out.println(plateStacks.pop());
        System.out.println(plateStacks.pop());
        System.out.println(plateStacks.pop());
        System.out.println(plateStacks.pop());*/

        _1172DinnerPlateStacks plateStacks =new _1172DinnerPlateStacks(1);
        plateStacks.push(1);plateStacks.push(2);plateStacks.push(3);
        System.out.println(plateStacks.popAtStack(1));
        System.out.println(plateStacks.pop());
        System.out.println(plateStacks.pop());

    }

}
