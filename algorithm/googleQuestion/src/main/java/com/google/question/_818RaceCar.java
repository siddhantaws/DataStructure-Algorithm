package com.google.question;

import java.util.*;

public class _818RaceCar {
    public static void main(String[] args) {
        _818RaceCar raceCar =new _818RaceCar();
        System.out.println(raceCar.racecar(3));
    }

    public int racecar(int target) {
        Queue<int[] > queue = new LinkedList<>();
        queue.add(new int[]{ 0, 1});

        final Set<String> setOfVisistedTaget = new HashSet<>();
        setOfVisistedTaget.add(0+"$"+1);
        int shortestSequence = 0 ;
        while(queue.size()>0){
            int size  = queue.size();
            for(int i=0;i<size;i++) {
                final int[] polledTarget = queue.poll();
                int pos = polledTarget[0];
                int speed = polledTarget[1];
                if(pos == target)
                    return shortestSequence;
                int forward = pos + speed;
                int forwardSpeed= speed*2;
                final String forwardStr = new String (forward+"$"+forwardSpeed);
                if(!setOfVisistedTaget.contains(forwardStr) && forward>0 &&  forward<(2*target)){
                    setOfVisistedTaget.add(forwardStr);
                    queue.add(new int[]{ forward, forwardSpeed});
                }

                int reverse = pos;
                int reverseSpeed= speed>0 ? -1 : 1;
                final String reverseStr = new String (reverse+"$"+reverseSpeed);
                if(!setOfVisistedTaget.contains(reverseStr) && reverse>0 &&  reverse<( 2*target)){
                    setOfVisistedTaget.add(reverseStr);
                    queue.add(new int[]{ reverse, reverseSpeed});
                }
            }
            shortestSequence++;
        }
        return -1;
    }

}
