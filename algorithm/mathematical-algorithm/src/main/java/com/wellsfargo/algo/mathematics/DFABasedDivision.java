package com.wellsfargo.algo.mathematics;

public class DFABasedDivision {

    private int num;

    private int k;

    private int stateArr[][];

    public DFABasedDivision(int num, int k) {
        this.num = num;
        this.k = k;
        this.stateArr = new int[k][2];
        preprocess();
    }

    private void preprocess() {
        int trans0, trans1;
        // The following loop calculates the two transitions for each state,
        // starting from state 0
        for (int state = 0; state < k; ++state) {
            // Calculate next state for bit 0
            trans0 = state << 1;
            stateArr[state][0] = (trans0 < k) ? trans0 : trans0 - k;

            // Calculate next state for bit 1
            trans1 = (state << 1) + 1;
            stateArr[state][1] = (trans1 < k) ? trans1 : trans1 - k;
        }
    }

    private int isDivisibleUtil(int num  ,int state) {
        int st1=state;
        // process "num" bit by bit from MSB to LSB
        if (num != 0) {
            isDivisibleUtil(num>>1 ,state);
            st1 = stateArr[state][num & 1];
        }
        return st1;
    }

    public boolean isDivisible(){
        int state = 0;
        state = isDivisibleUtil(num, state);
        return state == 0 ? true : false;
    }

    public static void main(String[] args) {
        DFABasedDivision dfaBasedDivision =new DFABasedDivision(45 , 3);
        System.out.println(dfaBasedDivision.isDivisible());
    }
}
