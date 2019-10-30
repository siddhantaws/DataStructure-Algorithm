package com.amazon.question;

import java.util.HashMap;
import java.util.Map;

public class FractionRecurringDecimal {
    private int numerator;

    private int denominator;

    public FractionRecurringDecimal(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public String fractionToDecimal() {
        StringBuilder builder =new StringBuilder();
        if((numerator<0 && denominator>0) || (numerator>0 && denominator<0 ))
            builder.append("-");

        long divisor =Math.abs(numerator);
        long dividend =Math.abs(denominator);
        long reminder = divisor%dividend;

        builder.append(divisor/dividend);

        if(reminder==0)
            return builder.toString();
        builder.append(".");
        Map<Long ,Integer > integerMap =new HashMap<>();
        while(reminder!=0){
            if(integerMap.containsKey(reminder)){
                builder.insert(integerMap.get(reminder),"(");
                builder.append(")");
                break;
            }
            integerMap.put(reminder,builder.length());
            reminder*=10;
            builder.append(reminder/dividend);
            reminder%=dividend;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        FractionRecurringDecimal recurringDecimal =new FractionRecurringDecimal(2,3);
        System.out.println(recurringDecimal.fractionToDecimal());
    }
}
