package com.wfs.amazon.tree;

import java.util.TreeMap;

public class _715RangeModule {
    private TreeMap<Integer,Integer> mapOfIntegers;

    public _715RangeModule() {
        this.mapOfIntegers =new TreeMap<Integer,Integer>();
    }

    public void addRange(int left, int right) {
        if(mapOfIntegers.isEmpty()){
            mapOfIntegers.put(left,right);
            return ;
        }
        if(mapOfIntegers.get(mapOfIntegers.lastKey())<left ){
            mapOfIntegers.put(left,right);
            return;
        }
        Integer ceilLeft = mapOfIntegers.floorKey(left);
        if(ceilLeft==null){
            ceilLeft =mapOfIntegers.ceilingKey(left);
        }
        int value = mapOfIntegers.get(ceilLeft);
        mapOfIntegers.remove(ceilLeft);
        if(ceilLeft<=left)
            left =ceilLeft;
        while(mapOfIntegers.ceilingKey(ceilLeft)!=null && mapOfIntegers.get(mapOfIntegers.ceilingKey(ceilLeft))<=right){
            int key = mapOfIntegers.ceilingKey(ceilLeft);
            mapOfIntegers.remove(key);
            ceilLeft =key;
        }
        ceilLeft = mapOfIntegers.ceilingKey(ceilLeft);
        if(ceilLeft==null || ceilLeft> right)
            mapOfIntegers.put(left ,right );
        else{
            mapOfIntegers.put(left,right);
            mapOfIntegers.put(right+1, mapOfIntegers.remove(ceilLeft));
        }
    }

    public boolean queryRange(int left, int right) {
        Integer ceilKey =mapOfIntegers.floorKey(left);
        if(ceilKey!=null){
            return ceilKey<= left && mapOfIntegers.get(ceilKey)>=right;
        }
        return false;
    }

    public void removeRange(int left, int right) {

    }

    public static void main(String[] args) {
        _715RangeModule module =new _715RangeModule();
        module.addRange(10,20);
        module.addRange(15,25);
        module.addRange(30,35);
        module.addRange(40,45);
        module.addRange(42,43);
    }
}
