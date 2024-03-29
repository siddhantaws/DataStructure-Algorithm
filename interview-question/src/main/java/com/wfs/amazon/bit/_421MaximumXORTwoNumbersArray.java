package com.wfs.amazon.bit;

import java.util.HashMap;

public class _421MaximumXORTwoNumbersArray {
    private int nums[];

    public _421MaximumXORTwoNumbersArray(int[] arr) {
        this.nums = arr;
    }

    public int findMaximumXOR() {
        int maxNum = nums[0];
        for(int num : nums)
            maxNum = Math.max(maxNum, num);
        int L = (Integer.toBinaryString(maxNum)).length();

        // zero left-padding to ensure L bits for each number
        int n = nums.length, bitmask = 1 << L;
        String [] strNums = new String[n];
        for(int i = 0; i < n; ++i) {
            strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
        }
        TrieNode trie = new TrieNode();
        int maxXor = 0;
        for (String num : strNums) {
            TrieNode node = trie, xorNode = trie;
            int currXor = 0;
            for (Character bit : num.toCharArray()) {
                // insert new number in trie
                if (node.children.containsKey(bit)) {
                    node = node.children.get(bit);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(bit, newNode);
                    node = newNode;
                }
                // compute max xor of that new number with all previously inserted
                Character toggledBit = bit == '1' ? '0' : '1';
                if (xorNode.children.containsKey(toggledBit)) {
                    currXor = (currXor << 1) | 1;
                    xorNode = xorNode.children.get(toggledBit);
                } else {
                    currXor = currXor << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        public TrieNode() {}
    }


    public static void main(String[] args) {
        _421MaximumXORTwoNumbersArray numbersArray =new _421MaximumXORTwoNumbersArray(new int[]{3, 10, 5, 25, 2, 8});
        System.out.println(numbersArray.findMaximumXOR());
    }
}
