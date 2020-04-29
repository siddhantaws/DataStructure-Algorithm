package com.google.question;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic_Number_II {
    public static char mapping[][] = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if (n < 1) {return result;}
        char []cls = new char[n];
        helper(cls, result, 0, n-1);
        return result;
    }

    private static void helper(char cls[], List<String> result, int low, int high) {

        if(low>high) {
            if(cls.length == 1 || cls[0] != '0')
                result.add(String.valueOf(cls));

            return;
        }

        for(char map[] : mapping) {

            if(low == high && map[0] != map[1]) continue;

            cls[low]    = map[0];
            cls[high]  = map[1];
            helper(cls, result, low+1, high-1);
        }
    }

    public static void main(String[] args) {
        Strobogrammatic_Number_II number_ii =new Strobogrammatic_Number_II();
        for(String s : number_ii.findStrobogrammatic(3))
            System.out.println(s);
    }
}
