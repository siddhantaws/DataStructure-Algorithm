package com.amazon.question;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private MyLRUCache lruCache ;

    public LRUCache(int capacity) {
        this.lruCache =new MyLRUCache(capacity);
    }

    public int get(int key) {
        return this.lruCache.get(key);
    }

    public void put(int key, int value) {
        this.lruCache.put(key,value);
    }

    class MyLRUCache extends LinkedHashMap<Integer,Integer>{
        int capcacity;

        public MyLRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capcacity = capcacity;
        }

        @Override
        public Integer get(Object key) {
            Integer i =super.get(key);
            return i==null ? -1 : i;
        }

        @Override
        public Integer put(Integer key, Integer value) {
            return super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() >capcacity;
        }
    }

}
