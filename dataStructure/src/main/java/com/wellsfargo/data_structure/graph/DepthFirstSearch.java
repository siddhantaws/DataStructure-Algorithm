package com.wellsfargo.data_structure.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class DepthFirstSearch<K, V extends Comparable> {

    private Graph<K,V> graph;
    private List<K> dfsList;
    private K startVertex;
    Stack<K> stack;

    public DepthFirstSearch(Graph<K,V> graph, K startVertex) {
        this.graph = graph;
        this.startVertex = startVertex;
        this.dfsList = new ArrayList<>();
        this.stack = new Stack<>();
    }

    public void printDFS() {
        for (K k : dfsList)
            System.out.println(k);
    }

    public void dfs() {
        dfs(startVertex);
    }

    private void dfs(K startVertex) {
        stack.add(startVertex);
        graph.setVisited(startVertex);
        for (Graph.Vertex<K> vertex : graph.getVertex(stack.peek()).getAdjecentVertex()) {
            if (!graph.isVisited(vertex.getData()))
                dfs(vertex.getData());
        }
        dfsList.add(stack.pop());

    }

    public static void main(String[] args) {
        Graph<String,Integer> graph1 = new Graph<>();
        graph1.add("A", "B", 10);
        graph1.add("B", "C", 10);
        graph1.add("C", "F", 10);
        graph1.add("C", "D", 10);
        graph1.add("F", "D", 10);
        graph1.add("D", "E", 10);
        graph1.add("E", "A", 10);
        DepthFirstSearch<String,Integer> firstSearch = new DepthFirstSearch(graph1, "A");
        firstSearch.dfs();
        firstSearch.printDFS();
    }

}
