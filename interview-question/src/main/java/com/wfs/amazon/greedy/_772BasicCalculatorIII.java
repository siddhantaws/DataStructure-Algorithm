package com.wfs.amazon.greedy;

import java.util.Stack;

public class _772BasicCalculatorIII {


    public _772BasicCalculatorIII() {
    }

    public int calculate(String s) {
        Stack<Integer> operand =new Stack();
        Stack<Character> operator =new Stack();
        char sign ='+';
        for(int i=0;i<s.length();i++){
            int digit =0;
            if(Character.isDigit(s.charAt(i)) ) {
                while( i<s.length() && Character.isDigit(s.charAt(i)) )
                    digit = 10*digit +  (s.charAt(i++)-'0');
                i--;
                operand.push(evalulate(digit , operand , sign));
            } else if(s.charAt(i)==' '){
                continue;
            }else if(s.charAt(i)=='('){
                operator.push(sign);
                sign ='+';
                operand.push(Integer.MIN_VALUE);
            }else if(s.charAt(i)==')'){
                int num =0;
                while(operand.peek()!=Integer.MIN_VALUE)
                    num+=operand.pop();
                operand.pop();
                operand.push(evalulate(num ,operand ,operator.pop()) );
            }else{
                sign =s.charAt(i);
            }
        }

        int num =operand.pop();
        while(!operand.isEmpty())
            num+= operand.pop();

        return num;
    }

    private int evalulate(int num , Stack<Integer> operand , char operation){
        switch(operation){
            case '+':
                return num;
            case '-':
                return num*-1;
            case '*':
                return num*operand.pop();
            case '/':
                return operand.pop()/num;

        }
        return 0;
    }

    public static void main(String[] args) {
        _772BasicCalculatorIII calculatorIII =new _772BasicCalculatorIII();
        System.out.println(calculatorIII.calculate("(10+2*5)"));
    }
}
