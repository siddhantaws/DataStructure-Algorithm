//package com.wellsfargo.algo.bit_algorithm;
//
///**
// * @author Siddhanta Kumar Pattnaik
// */
//public class LongestSequenceOf1BinaryRepresentationOneFlip {
//    private int a ;
//
//    public LongestSequenceOf1BinaryRepresentationOneFlip(int num) {
//        this.a = num;
//    }
//    public int flipBit() {
//        /* If all bits are l, binary representation of 'a' has all 1s */
//        if (~a == 0) {
//            return 8 * sizeof();
//        }
//
//        int currLen = 0, prevLen = 0, maxLen = 0;
//        while (a != 0) {
//            // If Current bit is a 1 then increament currLen++
//            if ((a & 1) == 1) {
//                currLen++;
//            }
//            // If Current bit is a 0 then check next bit of a
//            else if ((a & 1) == 0) {
//                /* Update prevLen to 0 (if next bit is 0) or currLen (if next bit is 1). */
//                prevLen = (a & 2) == 0 ? 0 : currLen;
//                // If two consecutively bits are 0 then currLen also will be 0.
//                currLen = 0;
//            }
//            // Update maxLen if required
//            maxLen = Math.max(prevLen + currLen, maxLen);
//            // Remove last bit (Right shift)
//            a >>= 1;
//        }
//        // We can always have a sequence of at least one 1, this is fliped bit
//        return maxLen + 1;
//    }
//
//}
