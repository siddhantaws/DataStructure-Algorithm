package com.wellsfargo.data_structure.graph;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TopoLogicalSort<K, V extends Comparable> {

    private Graph<K,V> graph;

    private Set<K> visitedSet;

    private Stack<K> sortedStack;

    private List<K> topologicallySortedList;

    public TopoLogicalSort(Graph<K,V> graph) {
        this.graph = graph;
        this.visitedSet=new HashSet<>();
        this.sortedStack=new Stack<>();
        this.topologicallySortedList =new ArrayList<>();
    }

    public List<K> topologicalSortedVertex(){
        for(Graph.Vertex<K> vertex: graph.getAllVertices()){
            if(visitedSet.contains(vertex.getData()))
                continue;
            visitedSet.add(vertex.getData());
            dfs(vertex);
        }
        while(sortedStack.isEmpty()){
            topologicallySortedList.add(sortedStack.pop());
        }
        return  topologicallySortedList;
    }

    private void  dfs(Graph.Vertex<K> vertex){
        for(Graph.Vertex<K> vertex1 :vertex.getAdjecentVertex()){
            if(visitedSet.contains(vertex.getData()))
                continue;
            dfs(vertex1);
        }
        sortedStack.add(vertex.getData());
    }

    public static void main(String[] args) {
        Graph<String,Integer> graph1=new Graph<>();
        graph1.add("A","B",10);
        graph1.add("B","C",10);
        graph1.add("F","C",10);
        graph1.add("C","D",10);
        graph1.add("F","D",10);
        graph1.add("D","E",10);
        graph1.add("E","A",10);
        TopoLogicalSort<String,Integer> logicalSort =new TopoLogicalSort<>(graph1);
        System.out.println(logicalSort.topologicalSortedVertex());
    }
}
