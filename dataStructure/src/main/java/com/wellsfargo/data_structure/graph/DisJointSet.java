package com.wellsfargo.data_structure.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class DisJointSet<K> {

    private List<K> disjointSet;
    private Map<K , Node<K>> nodeMap ;

    public DisJointSet(){
        this.nodeMap =new HashMap<>();
    }

    public DisJointSet(List<K> disjointSet) {
        this();
        this.disjointSet = disjointSet;
        for(K k:disjointSet)
            makeSet(k);
    }

    public void makeSet(K k){
        Node node=new Node(k);
        node.parent=node;
        nodeMap.put(k, node);
    }


    public Node<K> findSet(K k){
        return findSet(nodeMap.get(k));
    }

    private Node<K> findSet(Node<K> node){
        if(node == node.parent)
            return node;
        else {
            node.parent = findSet(node.parent);
            return node.parent;
        }
    }


    public boolean union(K k1, K k2){
        Node<K> n1= findSet(k1);
        Node<K> n2= findSet(k2);

        if(n1==n2)
            return false;

        if(n1.degree >=n2.degree) {
            n1.degree = n1.degree ==n2.degree ? n1.degree+1 : n1.degree;
            n2.parent =n1;
        }else {
            n1.parent=n2;
        }
        return true;
    }


    static class Node<K>{
        K k ;
        Node<K> parent ;
        int degree ;

        public Node(K k) {
            this.k = k;
        }

        @Override
        public String toString() {
            return "Data->"+k+" parent->"+parent.k;
        }
    }


}
