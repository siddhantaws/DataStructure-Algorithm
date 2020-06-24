package com.wfs.amazon.greedy;

import java.util.Stack;

public class _224BasicCalculator {
    private String str;

    public _224BasicCalculator(String str) {
        this.str = str.trim();
    }

    public int calculate() {
        Stack<Integer> stackOfOperand =new Stack();
        Stack<String> stackOfOperator =new Stack();
        int operand =0;
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                operand = operand*10+ (int)str.charAt(i)-'0';
            }else if(str.charAt(i)=='('){
                stackOfOperator.push("(");
                if(operand!=0)
                    stackOfOperand .push(operand);
                operand =0;
            }else if(str.charAt(i)=='+' || str.charAt(i)=='-'){
                stackOfOperator.push(str.charAt(i)+"");
                if(operand!=0)
                    stackOfOperand .push(operand);
                operand =0;
            }else if(str.charAt(i)==')'){
                if(operand!=0)
                    stackOfOperand .push(operand);
                operand =0;
                stackOfOperand.push(performOperation(stackOfOperand.pop(),stackOfOperand.pop(),stackOfOperator.pop()));
            }
        }
        if(operand!=0)
            stackOfOperand .push(operand);
        while(!stackOfOperator.isEmpty()){
            String operator = stackOfOperator.pop();
            if(stackOfOperator.equals(")")){
                while(!stackOfOperator.peek().equals("(")){
                    stackOfOperand.push(performOperation(stackOfOperand.pop() *  ( (stackOfOperator.size()==0 ||stackOfOperator.peek().equals("+") || stackOfOperator.peek().equals("(")) ? 1: -1 ),stackOfOperand.pop(),operator));
                }
                stackOfOperator.pop();
                continue;
            }
            stackOfOperand.push(performOperation(stackOfOperand.pop() *  ( (stackOfOperator.size()==0 ||stackOfOperator.peek().equals("+") || stackOfOperator.peek().equals("(")) ? 1: -1 ),stackOfOperand.pop(),operator));
        }
        return stackOfOperand.pop();
    }

    private int performOperation(Integer i1 ,Integer i2 , String operator){
        switch (operator){
            case "+":
                return i1+i2;
            case "-":
                return i2-i1;
        }
        return -1;
    }

    public static void main(String[] args) {
        _224BasicCalculator basicCalculator =new _224BasicCalculator("(1+(4+5+2)-3)+(6+8)");
        System.out.println(basicCalculator.calculate());
    }
}
