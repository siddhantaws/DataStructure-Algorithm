package com.wfs.concurrent.test;

import com.wfs.concurrent.ConcurrentSkipListMap;

public class Main {

    public static void main(String[] args) {
        ConcurrentSkipListMap<String,String> map =new ConcurrentSkipListMap<>();
        map.put("A","A");
        System.out.println(1);
    }
}
