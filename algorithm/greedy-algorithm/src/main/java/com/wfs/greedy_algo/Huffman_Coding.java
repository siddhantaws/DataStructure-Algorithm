package com.wfs.greedy_algo;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Huffman_Coding {

    private String text;

    private PriorityQueue<HuffmanNode> huffmanNodes;
    private Map<String,String> huffmanEncoding ;

    public Huffman_Coding(String text) {
        this.text = text;
        this.huffmanNodes = new PriorityQueue<>();
        this.huffmanEncoding =new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (map.containsKey(c + ""))
                map.put(c + "", map.get(c + "") + 1);
            else
                map.put(c + "", 1);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            huffmanNodes.add(new HuffmanNode(entry.getKey() , entry.getValue()));
        }
    }


    public HuffmanNode  constructHuffmanTree(){
        while(huffmanNodes.size()>1){
            HuffmanNode node1 = huffmanNodes.poll();
            HuffmanNode node2 = huffmanNodes.poll();
            HuffmanNode huffmanNode = null;
            if(node1.frequency > node2.frequency){
                huffmanNode  = new HuffmanNode("-" , node1.frequency +node2.frequency ,node2 , node1 );
            }else {
                huffmanNode  = new HuffmanNode("-" , node1.frequency +node2.frequency ,node1 , node2 );
            }
            node1.parent =node2.parent =huffmanNode;
            huffmanNodes.add(huffmanNode);
        }
        return huffmanNodes.poll();
    }

    public Map<String ,String> getHuffmanEncoding(){
        HuffmanNode node = constructHuffmanTree();
        StringBuffer sb=new StringBuffer();
        getHuffmanEncoding(sb ,node) ;
        return huffmanEncoding;
    }

    private void getHuffmanEncoding(StringBuffer sb ,HuffmanNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            huffmanEncoding.put(node.str, sb.toString());
        } else {
            getHuffmanEncoding(sb.append("0"), node.left);
            sb.deleteCharAt(sb.length() - 1);
            getHuffmanEncoding(sb.append("1"), node.right);
        }
    }

    static class HuffmanNode implements Comparable<HuffmanNode> {

        private String str;

        private int frequency;

        private HuffmanNode parent;

        private HuffmanNode left;

        private HuffmanNode right;

        public HuffmanNode(String str, int frequency) {
            this.str = str;
            this.frequency = frequency;
        }

        public HuffmanNode(String str, int frequency, HuffmanNode left, HuffmanNode right) {
            this.str = str;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(HuffmanNode o) {
            return  this.frequency - o.frequency ;
        }

        public int getFrequency() {
            return frequency;
        }

        public HuffmanNode getLeft() {
            return left;
        }

        public HuffmanNode getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "data->"+str+" freq"+frequency;
        }
    }

    public static void main(String[] args) {
        String str ="I am good boy, I am Ram, IIIIIIIIIIIIIIIIIIIIIIII am Ram";
        Huffman_Coding coding =new Huffman_Coding(str);
        for(Map.Entry<String,String> entry : coding.getHuffmanEncoding().entrySet()){
            System.out.println(entry.getKey() +"\t"+entry.getValue());
        }
    }
}
