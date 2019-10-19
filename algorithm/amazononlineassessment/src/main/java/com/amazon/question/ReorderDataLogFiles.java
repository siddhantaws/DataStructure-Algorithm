package com.amazon.question;

import java.util.Arrays;
import java.util.Comparator;
//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderDataLogFiles {
    private String logs[];

    public ReorderDataLogFiles(String[] logs) {
        this.logs = logs;
    }

    public String[] reorderLogFiles() {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1[] = o1.split(" ",2);
                String s2[] = o2.split(" ",2);
                boolean ch1= Character.isDigit(s1[1].charAt(0));
                boolean ch2= Character.isDigit(s2[1].charAt(0));
                if(!ch1 && !ch2){
                    if(s1[1].compareTo(s2[1])==0)
                        return s1[0].compareTo(s2[0]);
                    else
                        return s1[1].compareTo(s2[1]);
                }

                if(ch1 && ch2)
                    return 0;
                else if(ch1 && !ch2)
                    return 1;
                else //if(!ch1 && ch2)
                    return -1;
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String s[] ={"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        ReorderDataLogFiles dataLogFiles =new ReorderDataLogFiles(s);
        for(String s1: dataLogFiles.reorderLogFiles())
            System.out.println(s1);
    }
}
