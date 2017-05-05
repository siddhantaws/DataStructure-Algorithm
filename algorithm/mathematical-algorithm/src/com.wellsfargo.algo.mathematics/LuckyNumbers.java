package com.wellsfargo.algo.mathematics;

/**
 * Created by Suryasnata on 4/26/2017.
 */
public class LuckyNumbers {
    static int counter = 2;

    boolean isLucky(int n) {

        /*variable next_position is just for readability of
         the program we can remove it and use n only */
        int next_position = n;
        if (counter > n)
            return true;
        if (n % counter == 0)
            return false;

        /*calculate next position of input no*/
        next_position -= next_position / counter;

        counter++;
        return isLucky(next_position);
    }

    public static void main(String[] args) {
        int x = 13;
        if( new LuckyNumbers().isLucky(x) )
            System.out.println("Magic Number :"+x);
        else
            System.out.println("Not a Magic Number :"+x);
    }
}
