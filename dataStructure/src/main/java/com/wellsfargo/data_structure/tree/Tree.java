package com.wellsfargo.data_structure.tree;


import java.util.Set;

public interface Tree<K> {

    int size();

    boolean isEmpty();

    int height();

    boolean containsKey(Object key);

    K get(Object key);

    K add(K key);

    K remove(Object key);

    Set<Entry<K>> entrySet();

    interface Entry<K>{
        K getKey();

        boolean equals(Object o);

        int hashCode();

    }
}
