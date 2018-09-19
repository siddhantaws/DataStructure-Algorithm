package com.wellsfargo.data_structure.stack;

import java.util.Stack;

/**
 *
 * Input : abc++
 Output : (a + (b + c))

 Input  : ab*c+
 Output : ((a*b)+c)
 */

public class Postfix_Infix {
    private String postFix;

    public Postfix_Infix(String postFix) {
        this.postFix = postFix;
    }

    boolean isOperand(char x)
    {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }
    String getInfix()
    {
        Stack<String> s=new Stack<>();

        for (int i=0; postFix.charAt(i)!='\0'; i++)
        {
            // Push operands
            if (isOperand(postFix.charAt(i)))
            {
                s.push(postFix.charAt(i)+"");
            }

            // We assume that input is
            // a valid postfix and expect
            // an operator.
            else
            {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + postFix.charAt(i)+
                        op1 + ")");
            }
        }

        // There must be a single element
        // in stack now which is the required
        // infix.
        return s.peek();
    }
}
