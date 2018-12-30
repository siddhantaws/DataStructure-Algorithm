package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GenerateIntegerFrom1To7WithEqualProbability {

    int foo() {
        return 0;
    }

    public int my_rand() {
        int i;
        i = 5*foo() + foo() - 5;
        if (i < 22)
            return i%7 + 1;
        return my_rand();
    }
}
