package com.wellsfargo.data_structure.tree;

public interface Operation<K extends Comparable> {
    public K performOperation(K k1 , K val);
}
