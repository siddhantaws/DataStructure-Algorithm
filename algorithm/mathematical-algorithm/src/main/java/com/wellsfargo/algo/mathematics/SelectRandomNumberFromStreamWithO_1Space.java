package com.wellsfargo.algo.mathematics;

import java.util.Random;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SelectRandomNumberFromStreamWithO_1Space {

    private int arr[];
    private int count = 0;
    private int res = 0;

    public SelectRandomNumberFromStreamWithO_1Space(int[] arr) {
        this.arr = arr;
    }

    //A method to randomly select a item from stream[0], stream[1], .. stream[i-1]
    public int selectRandom(int x) {
        count++; // increment count of numbers seen so far

        // If this is the first element from stream, return it
        if (count == 1)
            res = x;
        else {
            // Generate a random number from 0 to count - 1
            Random r = new Random();
            int i = r.nextInt(count);

            // Replace the prev random number with new number with 1/count probability
            if (i == count - 1)
                res = x;
        }
        return res;
    }

    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4};
        SelectRandomNumberFromStreamWithO_1Space _1Space =new SelectRandomNumberFromStreamWithO_1Space(stream);
        for(int i = 0; i < stream.length; i++)
            System.out.println("Random number from first " + (i+1) +
                    " numbers is " + _1Space.selectRandom(stream[i]));
    }
}
