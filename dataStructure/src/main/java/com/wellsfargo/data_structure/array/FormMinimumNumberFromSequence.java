package com.wellsfargo.data_structure.array;

import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FormMinimumNumberFromSequence {

    private String seq;

    public FormMinimumNumberFromSequence(String seq) {
        this.seq = seq;
    }

    // Function to decode the given sequence to construct minimum number without repeated digits
    void PrintMinNumberForPattern() {
        // result store output string
        String result = "";

        // create an empty stack of integers
        Stack<Integer> stk = new Stack<Integer>();

        // run n+1 times where n is length of input sequence
        for (int i = 0; i <= seq.length(); i++) {
            // push number i+1 into the stack
            stk.push(i + 1);
            // if all characters of the input sequence are processed or current character is 'I' (increasing)
            if (i == seq.length() || seq.charAt(i) == 'I') {
                // run till stack is empty
                while (!stk.empty()) {
                    // remove top element from the stack and add it to solution
                    result += String.valueOf(stk.peek());
                    result += " ";
                    stk.pop();
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        FormMinimumNumberFromSequence number =new FormMinimumNumberFromSequence("D");
        number.PrintMinNumberForPattern();
    }
}
