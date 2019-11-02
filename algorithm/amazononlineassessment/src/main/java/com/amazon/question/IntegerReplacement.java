package com.amazon.question;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    private int num;

    private Map<Integer,Integer> map;

    public IntegerReplacement(int num) {
        this.num = num;
        this.map =new HashMap<>();
    }

    public  int integerReplacement(){
        return integerReplacement(num);
    }

    private  int integerReplacement(int n) {
        if(n==1)
            return 0;
        else{
            if(map.containsKey(n))
                return map.get(n);
            if(n%2==0){
                int count = 1+ integerReplacement(n/2);
                map.put(n,count);
                return count;
            }else{
                int count = Math.min(1+ integerReplacement(n+1) ,1+integerReplacement(n-1) );
                map.put(n,count);
                return count;
            }
        }
    }


    public static void main(String[] args) {
        IntegerReplacement replacement =new IntegerReplacement(2147483647);
        System.out.println(replacement.integerReplacement());
    }
}
