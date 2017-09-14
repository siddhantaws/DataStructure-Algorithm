package com.wellsfargo.graph.algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DisjointSet<E> {

    private Map<E, Node<E>> map = new HashMap<>();

    /**
     * Create a set with only one element.
     */
    public void makeSet(E data) {
        Node<E> node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    /**
     * Finds the representative of this set
     */
    public E findSet(E data) {
        return findSet(map.get(data)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     */
    private Node<E> findSet(Node<E> node) {
        Node<E> parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    /**
     * Combines two sets together to one.
     * Does union by rank
     *
     * @return true if data1 and data2 are in different set before union else false.
     */
    public boolean union(E data1, E data2) {

        Node<E> node1 = map.get(data1);
        Node<E> node2 = map.get(data2);

        Node<E> parent1 = findSet(node1);
        Node<E> parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.data == parent2.data) {
            return false;
        }

        //else whoever's rank is higher becomes parent of other
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    private static class Node<E> {
        E data;
        Node<E> parent;
        int rank;
    }
    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);


        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
    }

}
