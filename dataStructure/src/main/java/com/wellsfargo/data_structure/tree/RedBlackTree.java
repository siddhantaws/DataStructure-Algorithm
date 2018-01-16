package com.wellsfargo.data_structure.tree;

public class RedBlackTree<K> extends BinarySearchTree<K> {


    static class RBLNode<K> extends Entry{
        private static boolean RED =Boolean.TRUE;

        public RBLNode(K key, Entry<K> parent) {
            super(key, parent);
        }


    }
}
