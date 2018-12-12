package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GenerateNBitGrayCodes {

    private int digitNo;

    private List<Integer> integers;

    public GenerateNBitGrayCodes(int digitNo) {
        this.digitNo = digitNo;
        this.integers =new ArrayList<>();
    }
    /* we have 2 choices for each of the n bits either we can include i.e invert the bit or we can exclude the bit i.e we can leave the number as it is. */
    void grayCodeUtil(List<Integer> integers, int n, RefObject<Integer> targetNum) {
        // base case when we run out bits to process we simply include it in gray code sequence.
        if (n == 0) {
            integers.add(targetNum.value);
            return;
        }
        // ignore the bit.
        grayCodeUtil(integers, n - 1, targetNum);
        // invert the bit.
        targetNum.value = targetNum.value ^ (1 << (n - 1));
        grayCodeUtil(integers, n - 1, targetNum);
    }
    // returns the vector containing the gray code sequence of n bits.
    private List<Integer> grayCodes()
    {
        // num is passed by reference to keep track of current code.
        int num = 0;
        RefObject<Integer> tempRef_num = new RefObject<Integer>(num);
        grayCodeUtil(integers, digitNo, tempRef_num);
        return integers;
    }

    public static void main(String[] args) {
        GenerateNBitGrayCodes bitGrayCodes =new GenerateNBitGrayCodes(3);
        for(Integer integer:bitGrayCodes.grayCodes())
            System.out.println(integer);
    }
}
class RefObject<T>
{
    public T value;
    public RefObject(T refArg) {
        value = refArg;
    }

    @Override
    public String toString() {
        return value+"";
    }
}

