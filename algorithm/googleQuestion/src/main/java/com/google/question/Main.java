package com.google.question;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static int countRoutes(int fuel, List<Integer> cities) {
        // Write your code here
        int count =0;
        for(int i=0;i<cities.size()-1;i++)
            count+=generateRoutes(i , fuel,i+1, cities);
        return count ;
    }

    private static int generateRoutes(int prevIndex, int remainingFuel ,int currentIndex , List<Integer> cities){
        if(prevIndex==cities.size()-1 || currentIndex>=cities.size() || cities.get(prevIndex)==cities.get(currentIndex))
            return 0;
        else if (Math.abs(cities.get(prevIndex) - cities.get(currentIndex))> remainingFuel)
         return generateRoutes(prevIndex , remainingFuel , currentIndex+1 , cities);
        else
            return   1+ generateRoutes(currentIndex , remainingFuel -Math.abs(cities.get(prevIndex) - cities.get(currentIndex)) ,currentIndex+1 ,  cities );
    }

    public static void main(String[] args) {
        List<Integer> integers =new ArrayList<>();
        integers.add(2);integers.add(6);integers.add(2);integers.add(3);integers.add(4);integers.add(8);

        System.out.println(Main.countRoutes(5 , integers ));
    }
}
