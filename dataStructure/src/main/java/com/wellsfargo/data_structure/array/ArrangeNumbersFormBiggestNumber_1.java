package com.wellsfargo.data_structure.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ArrangeNumbersFormBiggestNumber_1 {

    private int arr[];

    public ArrangeNumbersFormBiggestNumber_1(int[] arr) {
        this.arr = arr;
    }


    public String largestNumber() {
        List<Integer> list =new ArrayList<>();
        for(int i:arr)
            list.add(i);
        // finding number of digits in maximum element
        // present in array
        int n = Collections.max(list).toString().length();

        ArrayList<ExtendedNum> en =
                new ArrayList<ExtendedNum>();
        for (int i = 0 ; i < list.size(); i++)
            en.add(new ExtendedNum(list.get(i), n));

        // sort based on modified value
        Collections.sort(en, (p1, p2) ->
                (int)(p2.modifiedValue - p1.modifiedValue));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < en.size(); i++)
            sb.append(new StringBuilder (Long.toString(en.get(i).originalValue)));

        // To remove any zeroes at head.
        BigInteger bi = new BigInteger(sb.toString());

        return bi.toString();
    }

    public static void main(String[] args) {
        int arr[]={1, 34, 3, 98, 9, 76, 45, 4, 12, 121};
        ArrangeNumbersFormBiggestNumber_1 formBiggestNumber1 =new ArrangeNumbersFormBiggestNumber_1(arr);
        System.out.println(formBiggestNumber1.largestNumber());
    }

    static class ExtendedNum {// A utility class to generate new value
        int originalValue;
        long modifiedValue;

        public ExtendedNum(int originalValue, int n) {
            this.originalValue = originalValue;
            String s = Integer.toString(originalValue);
            StringBuilder sb = new StringBuilder(s);
            StringBuilder ans = new StringBuilder();
            while (ans.length() <= n + 1)
                ans.append(sb);
            s = ans.toString().substring(0, n + 1);
            modifiedValue = Long.parseLong(s);
        }

        public String toString() {
            return "[" + modifiedValue +
                    ", " + originalValue + "]";
        }
    }
}
