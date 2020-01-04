package com.amazon.question;

import java.util.*;

public class RearrangeStringKDistanceApart {

    private String str;

    private int k;

    public RearrangeStringKDistanceApart(String str, int k) {
        this.str = str;
        this.k = k;
    }

    public String rearrangeString() {
        char charArray[] =new char [26];

        for(int i=0; i<str.length();i++)
            charArray[str.charAt(i)-'a']++;

        PriorityQueue<int[]> queue =new PriorityQueue<>((int a[], int b[])->{
            if(a[1]==b[1])
                return a[0]-b[0];
            return a[1]-b[1];
        });
        for(int i=0;i<charArray.length;i++)
            if(charArray[i]>0)
            queue.add(new int[]{i,charArray[i]});

        StringBuffer sb =new StringBuffer();
        while(!queue.isEmpty()){
            int i=0;
            List<int[]> l =new ArrayList<>();

            while(i<k && !queue.isEmpty()){
                int [] a = queue.poll();
                sb.append((char)(a[0]+'a'));
                a[1]--;
                i++;
                if(a[1]!=0)
                    l.add(a);

            }

            for(int a[]:l)
                queue.add(a);
        }

    return sb.toString();
    }

    public static void main(String[] args) {
        RearrangeStringKDistanceApart apart =new RearrangeStringKDistanceApart("aaadbbcc",2);
        System.out.println(apart.rearrangeString());
    }
}
