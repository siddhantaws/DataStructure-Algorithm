package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CountTotalSetBitsNumbersFrom1_N {
    private int n;

    public CountTotalSetBitsNumbersFrom1_N(int n) {
        this.n = n;
    }

    int countSetBits()
    {
        int i = 0;
        // ans store sum of set bits from 0 to n
        int ans = 0;
        // while n greater than equal to 2^i
        while ((1 << i) <= n) {
            // This k will get flipped after 2^i iterations
            boolean k = false;
            // change is iterator from 2^i to 1
            int change = 1 << i;
            // This will loop from 0 to n for every bit position
            for (int j = 0; j <= n; j++) {
                if (k == true)
                    ans += 1;
                else
                    ans += 0;
                if (change == 1) {
                    // When change = 1 flip the bit
                    k = !k;
                    // again set change to 2^i
                    change = 1 << i;
                }
                else {
                    change--;
                }
            }
            // increment the position
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        CountTotalSetBitsNumbersFrom1_N numbers =new CountTotalSetBitsNumbersFrom1_N(5);
        System.out.println(numbers.countSetBits());
    }
}
