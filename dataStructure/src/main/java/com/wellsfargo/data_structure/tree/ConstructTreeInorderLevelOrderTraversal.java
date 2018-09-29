//package com.wellsfargo.data_structure.tree;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class ConstructTreeInorderLevelOrderTraversal {
//    private Integer[] inOrder ;
//    private Integer[] levelOrder ;
//
//    public ConstructTreeInorderLevelOrderTraversal(Integer[] inOrder, Integer[] levelOrder) {
//        this.inOrder = inOrder;
//        this.levelOrder = levelOrder;
//    }
//
//
//    Node makeNode(int data){
//        Node newNode = new Node(data);
//        newNode.right = newNode.right = null;
//        return newNode;
//    }
//
//    // levelorder and inorder
//    Node buildTree(int iStart, int iEnd, int n)
//    {
//        if (n <= 0)
//        return null;
//
//        // First node of level order is root
//        Node root = makeNode(levelOrder[0]);
//
//        // Search root in inorder
//        int index = -1;
//        for (int i=iStart; i<=iEnd; i++){
//            if (levelOrder[0] == inOrder[i]){
//                index = i;
//                break;
//            }
//        }
//
//        // Insert all left nodes in hash table
//        Set<Integer> set = new HashSet<>();
//        for (int i=iStart;i<index;i++)
//            set.add(inOrder[i]);
//
//        // Separate level order traversals
//        // of left and right subtrees.
//        int lLevel[] =new int[set.size()];  // Left
//        int rLevel[] =new int[iEnd-iStart-set.size()]; // Right
//        int li = 0, ri = 0;
//        for (int i=1;i<n;i++) {
//            if (set.get(levelOrder[i]) != s.end())
//                lLevel[li++] = levelOrder[i];
//            else
//                rLevel[ri++] = levelOrder[i];
//        }
//
//        // Recursively build left and right
//        // subtrees and return root.
//        root.left = buildTree(iStart, index-1, index-iStart);
//        root.right = buildTree(index+1, iEnd, iEnd-index);
//        return root;
//
//    }
//    static class Node {
//        int key;
//       Node left, right;
//
//        Node(int item)
//        {
//            key = item;
//            left = right = null;
//        }
//
//        @Override
//        public String toString() {
//            return key+"";
//        }
//    }
//}
//
