package com.wfs.amazon.greedy;

import java.util.Stack;

public class _227BasicCalculatorII {

    private String s;

    public _227BasicCalculatorII(String str) {
        this.s = str.trim();
    }

    public int calculate() {
        Stack<Integer> operandStack = new Stack();
        Stack<String> operatorStack = new Stack();
        int i = 0;
        char currentCharacter = ' ';
        while (i < s.length()) {
            currentCharacter = s.charAt(i);
            StringBuilder operand = new StringBuilder("");
            while (i < s.length() && currentCharacter >= '0' && currentCharacter <= '9') {
                operand.append(currentCharacter + "");
                if (i < s.length() - 1)
                    currentCharacter = s.charAt(++i);
                else
                    break;
            }
            if (operand.length() > 0)
                operandStack.push(new Integer(operand.toString()));
            String operator = null;
            if (currentCharacter == '+' || currentCharacter == '*' || currentCharacter == '/' || currentCharacter == '-') {
                operator = currentCharacter + "";
                if (!operatorStack.isEmpty() && (operator.equals("+") || operator.equals("-")) && (operatorStack.peek().equals("*") || operatorStack.peek().equals("/"))) {
                    String topOperator = operatorStack.pop();
                    operandStack.push(evaluateExpression(topOperator, operandStack.pop(), operandStack.pop()));
                }
                operatorStack.push(operator);
            }
            i++;
        }
        while (!operatorStack.isEmpty()) {
            operandStack.push(evaluateExpression(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
        }
        return operandStack.pop();
    }

    public int evaluateExpression(String operator, Integer one, Integer two) {
        int result = -1;
        switch (operator) {
            case "+":
                result =  two+one ;
                break;
            case "-":
                result = two -one ;
                break;
            case "*":
                result = one * two;
                break;
            case "/":
                result = two/one;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        _227BasicCalculatorII calculatorII = new _227BasicCalculatorII("2*3+4");
        System.out.println(calculatorII.calculate());
    }
}
