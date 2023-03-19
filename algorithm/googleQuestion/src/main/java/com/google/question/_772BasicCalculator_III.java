package com.google.question;

import java.util.Stack;

public class _772BasicCalculator_III {
    private String str ;
    public _772BasicCalculator_III(final String str ) {
        this.str = str;
    }

    public static void main(String[] args) {
        _772BasicCalculator_III calculator_iii =new _772BasicCalculator_III("2*(5+5*2)/3+(6/2+8)");
        System.out.println(calculator_iii.calculate());
    }

    public int calculate(){
        final Stack<Integer> operand = new Stack<>();
        final Stack<String> operator = new Stack();
        String currOperator= "+";
        for(int i=0;i<str.length();i++){
            int digit =0;
            if(Character.isDigit(str.charAt(i))){
                while(i<str.length() && Character.isDigit(str.charAt(i)) )
                    digit = digit*10 + ( str.charAt(i++) -'0');
                i--;
                operand.push(evaluate(digit , currOperator , operand ));
            }else if(str.charAt(i)==' '){
                continue;
            }else if(str.charAt(i)=='('){
                operator.push(currOperator);
                currOperator="+";
                operand.push(Integer.MAX_VALUE);
            }else if (str.charAt(i)==')'){
                int num =0;
                while(operand.peek()!=Integer.MAX_VALUE)
                    num+= operand.pop();
                operand.pop();
                operand.push(evaluate(num , operator.pop() , operand ));
            }else {
                currOperator = str.charAt(i)+"";
            }
        }
        int num = operand.pop();
        while(!operand.isEmpty())
            num+=operand.pop();
        return num;
    }

    private int evaluate(int num ,String operator ,  Stack<Integer> operand){
        if(operator=="+")
            return num;
        else if(operator=="-")
            return num * -1;
        else if(operator=="/")
            return num / operand.pop();
        else if(operator=="*")
            return num * operand.pop();
        return 0;
    }
}
