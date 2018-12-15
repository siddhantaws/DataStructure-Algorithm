package com.wellsfargo.algo.bit_algorithm;

public class BinaryRepresentationNumberPalindrome {
    private int x;

    public BinaryRepresentationNumberPalindrome(int x) {
        this.x = x;
    }
    // This function returns true if k'th bit in x is set (or 1).  For example if x (0010) is 2 and k is 2, then it returns true
    private boolean isKthBitSet(int x, int k) {
        return ((x & (1 << (k - 1))) != 0) ? true : false;
    }
    public boolean isPalindrome() {
        int l = 1; // Initialize left position
        int r = getLeftMostSetBit(); // initialize right position
        // One by one compare bits
        while (l < r) {
            if (isKthBitSet(x, l) != isKthBitSet(x, r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private int getLeftMostSetBit(){
        int k =x,count=1;
        while(k>0) {
            count++;
            k= k>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryRepresentationNumberPalindrome palindrome =new BinaryRepresentationNumberPalindrome(10);
        System.out.println(palindrome.isPalindrome());
    }
}
