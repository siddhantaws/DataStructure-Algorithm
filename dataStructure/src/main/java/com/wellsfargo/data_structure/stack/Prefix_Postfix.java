package com.wellsfargo.data_structure.stack;

import java.util.Stack;

/**
 *
 * Input :  Prefix :  *+AB-CD
 Output : Postfix : AB+CD-*
 Explanation : Prefix to Infix :  (A+B) * (C-D)
 Infix to Postfix :  AB+CD-*

 Input :  Prefix :  *-A/BC-/AKL
 Output : Postfix : ABC/-AK/L-*
 Explanation : Prefix to Infix :  A-(B/C)*(A/K)-L
 Infix to Postfix : ABC/-AK/L-*
 */

public class Prefix_Postfix {
    private String prefix;

    public Prefix_Postfix(String prefix) {
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

    // Convert prefix to Postfix expression
    public String preToPost() {

        Stack<String> s=new Stack<>();

        // length of expression
        int length = prefix.length();

        // reading from right to left
        for (int i = length - 1; i >= 0; i--) {

            // check if symbol is operator
            if (isOperator(prefix.charAt(i))) {

                // pop two operands from stack
                String op1 = s.peek(); s.pop();
                String op2 = s.peek(); s.pop();

                // concat the operands and operator
                String temp = op1 + op2 + prefix.charAt(i);

                // Push string temp back to stack
                s.push(temp);
            }

            // if symbol is an operand
            else {

                // push the operand to the stack
                s.push(prefix.charAt(i)+"");
            }
        }

        // stack contains only the Postfix expression
        return s.peek();
    }
}
