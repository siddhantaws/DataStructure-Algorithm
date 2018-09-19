package com.wellsfargo.data_structure.stack;

import java.util.Stack;
/**
 *
 *
 * Input :  Postfix : AB+CD-*
 Output : Prefix :  *+AB-CD
 Explanation : Postfix to Infix : (A+B) * (C-D)
 Infix to Prefix :  *+AB-CD

 Input :  Postfix : ABC/-AK/L-*
 Output : Prefix :  *-A/BC-/AKL
 Explanation : Postfix to Infix : A-(B/C)*(A/K)-L
 Infix to Prefix :  *-A/BC-/AKL
 */

public class Postfix_Prefix {
    private String postFix;

    public Postfix_Prefix(String postFix) {
        this.postFix = postFix;
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

    private String postToPre() {
        Stack<String> s=null;

        // length of expression
        int length = postFix.length();

        // reading from right to left
        for (int i = 0; i < length; i++) {

            // check if symbol is operator
            if (isOperator(postFix.charAt(i))) {

                // pop two operands from stack
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                // concat the operands and operator
                String temp =postFix.charAt(i) + op2 + op1;

                // Push string temp back to stack
                s.push(temp);
            }

            // if symbol is an operand
            else {

                // push the operand to the stack
                s.push(postFix.charAt(i)+"");
            }
        }

        // stack[0] contains the Prefix expression
        return s.peek();
    }
}
