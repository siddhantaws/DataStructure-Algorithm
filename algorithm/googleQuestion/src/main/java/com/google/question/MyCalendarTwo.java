package com.google.question;

import java.util.*;

class MyCalendarTwo {

    private TreeMap<Integer , List<Integer>> mapOfBookingTiming;
    
    public MyCalendarTwo() {
        this.mapOfBookingTiming =new  TreeMap();
    }
    
    public boolean book(int start, int end) {
        boolean isValidBooking =true;
        int count=0;
        for(Map.Entry<Integer,List<Integer>> lowerEntry: mapOfBookingTiming.headMap(start,true).entrySet()){
                for(int i : lowerEntry.getValue()){
                    if (i >start && i<end && (count++)>=1)
                        return false;
                }
        }
         for(Map.Entry<Integer,List<Integer>> lowerEntry: mapOfBookingTiming.tailMap(start,false).entrySet()){
            if (lowerEntry.getKey()<end){
                for(Integer i : lowerEntry.getValue()){
                    if (i>=end && count++>=1){
                        return false;
                    }     
                }
            }
        }
        mapOfBookingTiming.computeIfAbsent(start , k-> new ArrayList<>()).add(end);
        return isValidBooking;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo =new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10,20));
        System.out.println(myCalendarTwo.book(50, 60)); // returns true
        System.out.println(myCalendarTwo.book(10, 40)); // returns true
        System.out.println(myCalendarTwo.book(5, 15));// returns false
        System.out.println(myCalendarTwo.book(5, 10));// returns true
        System.out.println(myCalendarTwo.book(25, 55));
    }
}