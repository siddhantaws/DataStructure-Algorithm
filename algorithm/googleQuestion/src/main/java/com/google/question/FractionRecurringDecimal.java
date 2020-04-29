package com.google.question;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FractionRecurringDecimal {

    private int numerator ;

    private int denominator;

    public FractionRecurringDecimal(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String fractionToDecimal() {
        StringBuffer sb =new StringBuffer("");
        if(denominator==0)
            return Integer.MAX_VALUE+"";
        if(numerator<0 || denominator<0)
            sb.append("-");
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        if(numerator>denominator){
            sb.append(numerator/denominator);
        }
        int result =numerator%denominator;
        if(result==0)
            return sb.toString()+"";
        if(sb.length()==0)
            sb.append("0");
        sb.append(".");
        Map<Integer,Integer> integerMap = new LinkedHashMap<>();
        while(result!=0){
            while(numerator<denominator)
                numerator =numerator*10;
            if(integerMap.containsKey(numerator)){
                sb.append("(");
                sb.append(integerMap.get(numerator));
                sb.append(")");
                return sb.toString();
            }
            result = numerator%denominator;
            integerMap.put(numerator,numerator/denominator);
            if(result!=0){
                numerator =result;
            }
        }
        for(Integer in:integerMap.keySet())
            sb.append(integerMap.get(in));
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionRecurringDecimal decimal =new FractionRecurringDecimal(4,333);
        System.out.println(decimal.fractionToDecimal());
    }
}
