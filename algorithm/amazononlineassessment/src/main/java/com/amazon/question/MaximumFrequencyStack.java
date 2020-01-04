package com.amazon.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class MaximumFrequencyStack {

    private Map<Integer,Integer> element2CountMap;
    private Map<Integer , Stack<Integer>> count2ElementStack;

    public MaximumFrequencyStack() {
        this.element2CountMap =new HashMap<>();
        this.count2ElementStack =new TreeMap<>();
    }

    public void push(int x) {
        if(element2CountMap.containsKey(x))
            element2CountMap.put(x, element2CountMap.get(x)+1);
        else
            element2CountMap.put(x, 1);

        if(!count2ElementStack.containsKey(element2CountMap.get(x))){
            Stack<Integer> stack =new Stack<>();
            stack.push(x);
            count2ElementStack.put(element2CountMap.get(x),stack);
        }else{
            count2ElementStack.get(element2CountMap.get(x)).push(x);
        }
    }

    public int pop() {
        Object key =((TreeMap)count2ElementStack).lastKey();
        if(key!=null){
            Stack<Integer> s =count2ElementStack.get((Integer) key);
            Integer x =s.pop();
            if(s.isEmpty())
                count2ElementStack.remove(key);
            if(element2CountMap.get(x)==1)
                element2CountMap.remove(x);
            else
                element2CountMap.put(x , element2CountMap.get(x)-1);
            return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack stack =new MaximumFrequencyStack();
        stack.push(5);stack.push(7);stack.push(5);stack.push(7);stack.push(4);stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
