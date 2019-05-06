package com.wellsfargo.data_structure.stack;

import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RemoveBracketsFromAlgebraicStringContainingPlusMinusOperators {

    private String str;


    public RemoveBracketsFromAlgebraicStringContainingPlusMinusOperators(String str) {
        this.str = str;
    }

    public String simplify(){
        int len= str.length();

        // resultant string of max length equal to length of input string
        char res[] = new char[len];
        int index = 0, i = 0;

        Stack<Integer> s = new Stack<Integer> ();
        s.push(0);
        while (i < len) {
            if (str.charAt(i) == '+') {
                // If top is 1, flip the operator
                if (s.peek() == 1)
                    res[index++] = '-';
                // If top is 0, append the same operator
                if (s.peek() == 0)
                    res[index++] = '+';
            } else if (str.charAt(i) == '-') {
                if (s.peek() == 1)
                    res[index++] = '+';
                else if (s.peek() == 0)
                    res[index++] = '-';
            } else if (str.charAt(i) == '(' && i > 0) {
                if (str.charAt(i - 1) == '-') {
                    // x is opposite to the top of stack
                    int x = (s.peek() == 1) ? 0 : 1;
                    s.push(x);
                }
                // push value equal to top of the stack
                else if (str.charAt(i - 1) == '+')
                    s.push(s.peek());
            }
            // If closing parentheses pop the stack once
            else if (str.charAt(i) == ')')
                s.pop();
                // copy the character to the result
            else
                res[index++] = str.charAt(i);
            i++;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        RemoveBracketsFromAlgebraicStringContainingPlusMinusOperators plusMinusOperators =new
                RemoveBracketsFromAlgebraicStringContainingPlusMinusOperators("a-(b+c)");
        System.out.println(plusMinusOperators.simplify());
    }
}
