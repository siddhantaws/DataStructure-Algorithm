package com.wfs.amazon.dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class _343IntegerBreak {

    private int num;

    private Map<Integer,Integer> mapOfIntegertToProduct;

    public _343IntegerBreak(int num) {
        this.num = num;
        this.mapOfIntegertToProduct=new HashMap<>();
    }

    public int integerBreak(int n) {
        if(n==0)
            return 1;
        if(n<=3)
            return n;
        if(mapOfIntegertToProduct.containsKey(n))
            return mapOfIntegertToProduct.get(n);
        Integer maxProduct =Integer.MIN_VALUE;
        for(int i=1;i<n/2;i++)
            maxProduct = Math.max(maxProduct , integerBreak(i)* integerBreak(n-i));
        mapOfIntegertToProduct.put(n, maxProduct);
        return maxProduct;
    }
}
