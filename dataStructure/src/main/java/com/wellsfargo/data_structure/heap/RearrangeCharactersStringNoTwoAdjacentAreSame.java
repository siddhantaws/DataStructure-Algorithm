package com.wellsfargo.data_structure.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeCharactersStringNoTwoAdjacentAreSame {
    private char ch[];

    private PriorityQueue<Entry> entryPriorityQueue;

    private Entry[] entries;

    private char newCh[];

    public RearrangeCharactersStringNoTwoAdjacentAreSame(String s) {
        this.ch = s.toCharArray();
        this.newCh=new char[ch.length];
        this.entryPriorityQueue =new PriorityQueue<>(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o2.count-o1.count ;
            }
        });
        init();

    }

    public void init(){
        this.entries =new Entry[26];
        for(int i=0;i<entries.length;i++)
            entries[i] =new Entry((char)(i+'a'));
        for(int i=0;i<ch.length;i++)
            entries[ch[i]-'a'].count++;
        for(int i=0;i<entries.length;i++)
            entryPriorityQueue.add(entries[i]);
    }


    public String getString(){
        int i=0;Entry prev =null;
        while(entryPriorityQueue.isEmpty()){
            Entry entry = entryPriorityQueue.poll();
            newCh[i]=entry.ch;
            entry.count--;
            if(prev!=null && prev.count>0)
                entryPriorityQueue.add(prev);
            prev =entry;
        }
        return new String(newCh);
    }


    class Entry{
        char ch;
        int count;
        public Entry(char ch){this.ch=ch;}
        public Entry(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

    }
}
