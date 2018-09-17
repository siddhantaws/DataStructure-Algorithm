package com.wellsfargo.data_structure.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyMain {

    public static void main(String[] args) {
        System.out.println(1<<-1);
        int a =1,b=2, c =3;
        Map m = new HashMap();
        m.put(a,10);
        m.put(b,20);
        m.put(c,30);

        System.out.println(m.get(3));
       /* int x =0;
        for(int i=1;i<11;i++)
            x = x ^ i;
        x=x^5; x=x^6;
        System.out.println(x);*/
    }
}
