package com.wellsfargo.data_structure.array;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ArrangeNumbersFormBiggestNumber {

    private int arr[];

    public ArrangeNumbersFormBiggestNumber(int[] arr) {
        this.arr = arr;
    }

    public void printLargest(){
        List<String> stringList =new ArrayList<>();
        for(int i:arr)
            stringList.add(i+"");
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1= o1+o2;
                String s2= o2+o1;
                return s2.compareTo(s1);
            }
        });
        for(int i=0;i<stringList.size()-1;i++)
            System.out.print(stringList.get(i));
    }

    public static void main(String[] args) {
        int arr[]={1, 34, 3, 98, 9, 76, 45, 4};
        ArrangeNumbersFormBiggestNumber formBiggestNumber =new ArrangeNumbersFormBiggestNumber(arr);
        formBiggestNumber.printLargest();
    }
}
