package com.amazon.question;

import com.wellsfargo.data_structure.matrix.Point;

import java.util.*;

public class ReorganizeString {

    private String str;

    private Queue<Pair> queue;

    public ReorganizeString(String str) {
        this.str = str;
        this.queue =new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count-o1.count;
            }
        });
        String s[] = str.split("");
        Map<String ,Integer> map =new HashMap<>();
        for(String s1:s)
            map.put(s1, map.getOrDefault(s1,0)+1);
        for(Map.Entry<String ,Integer> entry:map.entrySet())
            queue.add(new Pair(entry.getKey(),entry.getValue()));
    }


    class Pair {
        String s;
        int count;
        public Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }

    public String reorganizeString() {
        StringBuilder sb =new StringBuilder("");
        while(queue.size()>1){
            Pair first= queue.poll();
            Pair second = queue.poll();
            sb.append(first.s).append(second.s);
            first.count--;second.count--;
            if(first.count>0)
                queue.add(first);
            if(second.count>0)
            queue.add(second);
        }
        if(queue.size()==1){
            Pair p = queue.poll();
            if(p.count==1)
                sb.append(p.s);
            else
                return "";
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        ReorganizeString reorganizeString =new ReorganizeString("aaab");
        System.out.println(reorganizeString.reorganizeString());
    }
}
