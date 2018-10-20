package com.wellsfargo.data_structure.graph;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumSpanningTree_Prims<K, V extends  Comparable> {
    private Graph<K,V> graph;

    private PriorityQueue<Node<K, V>> vertexPqueue;
    private Map<K, Node<K, V>> nodeMap;
    private Map<K, Graph.Edge<K,V>> mapOfVertexToEdge;


    public MinimumSpanningTree_Prims(Graph<K,V> graph) {
        this.graph = graph;
        this.vertexPqueue = new PriorityQueue(new Comparator<Node<K, Integer>>() {
            @Override
            public int compare(Node<K, Integer> o1, Node<K, Integer> o2) {
                return o1.v.compareTo(o2.v);
            }
        });
        this.nodeMap = new HashMap<>();
        boolean flag = true;
        this.mapOfVertexToEdge = new HashMap<>();
        for (K vertex : graph.getVertices()) {
            if (flag) {
                Node<K, V> node = new Node(vertex, 0);
                vertexPqueue.add(node);
                nodeMap.put(vertex, node);
                flag = false;
            } else {
                Node<K, V> node = new Node(vertex, Integer.MAX_VALUE);
                vertexPqueue.add(node);
                nodeMap.put(vertex, node);
            }
        }
    }

    public List<Graph.Edge<K,V>> getMinimumSpanningTree() {
        while (!vertexPqueue.isEmpty()) {
            Node<K, V> node = vertexPqueue.poll();
            for (Graph.Edge<K,V> edge : graph.getVertex(node.k).getEdges()) {
                K k1;
                if (edge.getV2().getData() == node.k)
                    k1 = edge.getV1().getData();
                else
                    k1 = edge.getV2().getData();
                Node<K, V> node1 = nodeMap.get(k1);
                if (node1.v.compareTo((Integer) edge.getWeight()) > 0) {
                    nodeMap.remove(k1);
                    vertexPqueue.remove(node1);
                    node1.v = edge.getWeight();
                    nodeMap.put(k1, node1);
                    vertexPqueue.add(node1);
                    mapOfVertexToEdge.put(k1, edge);
                }
            }
        }
        Iterator<Graph.Edge<K,V>> edgeIterator = mapOfVertexToEdge.values().iterator();
        List<Graph.Edge<K,V>> list = new ArrayList<>();
        while(edgeIterator.hasNext())
            list.add(edgeIterator.next());
        return list;
    }


    static class Node<K, V extends Comparable> {

        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Graph<String,Integer> graph =new Graph<>();
        graph.add("A","D",1);graph.add("A","B",3);graph.add("B","D",3);graph.add("B","C",1);
        graph.add("D","C",1);graph.add("C","F",4);graph.add("D","E",6);graph.add("C","E",5);
        graph.add("E","F",2);
        MinimumSpanningTree_Prims<String,Integer> spanningTree_prims =new MinimumSpanningTree_Prims(graph);
        for(Graph.Edge<String,Integer> edge : spanningTree_prims.getMinimumSpanningTree())
            System.out.println(edge.getV1().getData()+"==="+edge.getV2().getData());
    }
}
