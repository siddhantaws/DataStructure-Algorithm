package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindTwoNonRepeatingElementsInArrayRepeatingElement {

    private int arr[];

    private Integer a;

    private Integer b;

    public FindTwoNonRepeatingElementsInArrayRepeatingElement(int[] arr) {
        this.arr = arr;
    }

    public void getTwoNonRepeatingElement() {
        int x = arr[0];
        for (int i = 1; i < arr.length; i++)
            x = x ^ arr[i];
        int pos = getRightMostSetBit(x);
        for (int i = 0; i < arr.length; i++) {
            if (  (arr[i] &  ( 1<< pos-1) ) >0) {
                if (a == null)
                    a = arr[i];
                else
                    a = a ^ arr[i];
            } else {
                if (b == null)
                    b = arr[i];
                else
                    b = b^ arr[i];
            }
        }

    }

    private boolean isSetBit(int x, int pos) {
        return (x & 1 << pos-1) == x;
    }

    private int getRightMostSetBit(int x) {
        int count = 0;
        int num = x;
        while (x > 0) {
            count++;
            if ((x & 1) > 0)
                return count;
            x = x >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        FindTwoNonRepeatingElementsInArrayRepeatingElement elements = new FindTwoNonRepeatingElementsInArrayRepeatingElement(new int[]{2, 3, 7, 9, 11, 2, 3, 11});
        elements.getTwoNonRepeatingElement();
        System.out.println(elements.a + "\t" + elements.b);
        System.out.println(9 & 2);
    }
}
