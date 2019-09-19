package com.wellsfargo.data_structure.heap;

import java.util.PriorityQueue;

public class KMostFrequentWordsFromFile {


    public class TrieNode {
        public boolean isEnd; // indicates end of word
        public int frequency; // the number of occurrences of a word
        public int indexMinHeap; // the index of the word in minHeap
        public TrieNode[] child = new TrieNode[26];

    }

    public class MinHeapNode {
        public TrieNode root; // indicates the leaf node of TRIE
        public int frequency; //  number of occurrences
        public String word; // the actual word stored
    }

    TrieNode newTrieNode() {
        // Allocate memory for Trie Node
        TrieNode trieNode = new TrieNode();
        // Initialize values for new node
        trieNode.isEnd = false;
        trieNode.frequency = 0;
        trieNode.indexMinHeap = -1;
        return trieNode;
    }

    PriorityQueue<MinHeapNode> createMinHeap(int capacity) {
        PriorityQueue<MinHeapNode> queue = new PriorityQueue(capacity);
        // Allocate memory for array of min heap nodes
        return queue;
    }

    // A utility function to swap two min heap nodes. This function is needed in minHeapify
    void swapMinHeapNodes(MinHeapNode a, MinHeapNode b) {
        MinHeapNode temp = a;
        a = b;
        b = temp;
    }


}
