package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckIfNumberMultipleOf9UsingBitwiseOperators {
    private int num;

    public CheckIfNumberMultipleOf9UsingBitwiseOperators(int num) {
        this.num = num;
    }

    // Bitwise operator based function to check divisibility by 9
    public boolean isDivBy9(){
        return isDivBy9(num);
    }

    private  boolean isDivBy9(int n) {
        // Base cases
        if (n == 0 || n == 9)
            return true;
        if (n < 9)
            return false;

        int x = (int)(n >> 3) ;
        int y = (int)(n & 7) ;
        // If n is greater than 9, then recur for [floor(n/9) - n%8]
        return isDivBy9( x - y );
    }

    public static void main(String[] args) {
        CheckIfNumberMultipleOf9UsingBitwiseOperators multiple =new CheckIfNumberMultipleOf9UsingBitwiseOperators(18);
        System.out.println(multiple.isDivBy9());
    }
}
