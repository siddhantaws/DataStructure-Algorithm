package com.wellsfargo.data_structure.tree;

import java.util.ArrayList;
import java.util.List;

public class FenwickTree<K extends Comparable> {

    private Operation operation;
    private List<K> binaryIndexedTree;
    /**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
    private int getParent(int index){
        return index - (index & -index);
    }

    /**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */
    private int getNext(int index){
        return index + (index & -index);
    }

    /**
     * Creating tree is like updating Fenwick tree for every value in array
     */
    public List<K> createTree(K input[]){
        binaryIndexedTree= new ArrayList<>(input.length+1);
        for(int i=1; i <= input.length; i++){
            updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i);
        }
        return binaryIndexedTree;
    }

    /**
     * Start from index+1 if you updating index in original array. Keep adding this value
     * for next node till you reach outside range of tree
     */
    public void updateBinaryIndexedTree(List<K> binaryIndexedTree, K val, int index){
        while(index < binaryIndexedTree.size()){
            binaryIndexedTree.set(index,(K)operation.performOperation(binaryIndexedTree.get(index) , val));
            index = getNext(index);
        }
    }
}
