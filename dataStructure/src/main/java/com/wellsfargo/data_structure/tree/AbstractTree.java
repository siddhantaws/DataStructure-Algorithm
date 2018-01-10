package com.wellsfargo.data_structure.tree;

import java.util.Objects;
import java.util.Set;

public abstract class  AbstractTree<K> implements Tree<K> {

    protected Entry<K> root ,  lastEntry;

    private int size ;

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public K get(Object key) {
        return null;
    }

    @Override
    public K add(K key) {
        size++;
        if(root==null)
            root =lastEntry =new Entry<>(key);
        else {
        }
        return key;
    }


    @Override
    public K remove(Object key) {
        return null;
    }

    @Override
    public Set<Tree.Entry<K>> entrySet() {
        return null;
    }

    static class Entry<K> implements  Tree.Entry<K>{

        private K key ;

        private Entry<K> left ;

        private Entry<K> right;

        private Entry<K> parent;

        public Entry(K key, Entry<K> parent) {
            this.key = key;
            this.parent = parent;
        }

        public void setLeft(Entry<K> left) {
            this.left = left;
        }

        public void setRight(Entry<K> right) {
            this.right = right;
        }

        public void setParent(Entry<K> parent) {
            this.parent = parent;
        }

        public Entry<K> getLeft() {
            return left;
        }

        public Entry<K> getRight() {
            return right;
        }

        public Entry<K> getParent() {
            return parent;
        }

        public Entry(K key) {

            this.key = key;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;
            Entry<?> entry = (Entry<?>) o;
            return Objects.equals(getKey(), entry.getKey());
        }

        @Override
        public int hashCode() {

            return Objects.hash(getKey());
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    '}';
        }
    }

}
