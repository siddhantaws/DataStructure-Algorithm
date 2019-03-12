package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindTherePairInRoot2LeafPathWithSumEqualRootData {

    private Node root;

    public FindTherePairInRoot2LeafPathWithSumEqualRootData(Node root) {
        this.root = root;
    }




    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
