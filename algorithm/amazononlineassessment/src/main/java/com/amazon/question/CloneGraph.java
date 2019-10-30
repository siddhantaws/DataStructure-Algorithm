package com.amazon.question;

import java.util.List;
import java.util.Map;

public class CloneGraph {

    private Node node;

    private Node cloneNode;

    private Map<Integer ,Node> nodeMap;

    public CloneGraph(Node node) {
        this.node = node;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val =val;
        }

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph() {
        return cloneGraph(node);
    }

    private Node cloneGraph(Node node){
        if(node==null)
            return null;
        else{
            Node node1 =nodeMap.getOrDefault(nodeMap.get(node.val) , new Node(node.val));
            for(Node n : node.neighbors){
                
            }
            return node1;
        }
    }
}
