package com.wellsfargo.data_structure.stack;

import java.util.Stack;

/**
 *
 * Input :  Prefix :  *+AB-CD
  Output : Infix : ((A+B)*(C-D))

 Input :  Prefix :  *-A/BC-/AKL
 Output : Infix : ((A-(B/C))*((A/K)-L))
 */

public class Prefix_Infix {
    private String prefix;

    public Prefix_Infix(String prefix) {
        this.prefix = prefix;
    }

    boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public String preToInfix() {
        Stack<String> s=new Stack<>();

        // length of expression
        int length = prefix.length();

        // reading from right to left
        for (int i = length - 1; i >= 0; i--) {

            // check if symbol is operator
            if (isOperator(prefix.charAt(i))) {

                // pop two operands from stack
                String op1 = s.peek();   s.pop();
                String op2 = s.peek();   s.pop();

                // concat the operands and operator
                String temp = "(" + op1 + prefix.charAt(i) + op2 + ")";

                // Push string temp back to stack
                s.push(temp);
            }

            // if symbol is an operand
            else {

                // push the operand to the stack
                s.push(prefix.charAt(i)+"");
            }
        }

        // Stack now contains the Infix expression
        return s.peek();
    }
}
