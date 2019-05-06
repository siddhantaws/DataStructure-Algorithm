package com.wellsfargo.data_structure.stack;

import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CountNaturalNumbersWhosePermutationGreaterThanNumber {
    private int num;

    public CountNaturalNumbersWhosePermutationGreaterThanNumber(int num) {
        this.num = num;
    }

    public int countNumber(){
        int result = 0;
        // Pushing 1 to 9 because all number from 1 to 9 have this propert.
        for (int i = 1; i <= 9; i++) {
            Stack<Integer> s = new Stack<>();
            if (i <= num) {
                s.push(i);
                result++;
            }
            while (!s.empty()) {// take a number from stack and add a digit smaller than last digit of it.
                int tp = s.peek();
                s.pop();
                for (int j = tp % 10; j <= 9; j++) {
                    int x = tp * 10 + j;
                    if (x <= num) {
                        s.push(x);
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountNaturalNumbersWhosePermutationGreaterThanNumber number =new CountNaturalNumbersWhosePermutationGreaterThanNumber(14);
        System.out.println(number.countNumber());
    }
}
