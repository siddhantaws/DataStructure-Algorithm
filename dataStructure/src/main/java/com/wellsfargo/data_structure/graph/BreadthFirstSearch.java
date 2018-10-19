package com.wellsfargo.data_structure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class BreadthFirstSearch<K> {
    private Graph<K> graph ;
    private  List<K> bfsList;
    private  K startVertex ;

    public BreadthFirstSearch(Graph<K> graph , K startVertex) {
        this.graph = graph;
        this.bfsList =new ArrayList<>();
        this.startVertex =startVertex;
    }

    public List<K> bfs(){
        Queue<K> kQueue =new ArrayDeque<>();
        kQueue.add(startVertex);
        graph.setVisited(startVertex);
        while(!kQueue.isEmpty()){
            K k = kQueue.poll();
            bfsList.add(k);
            for(Graph.Vertex<K> vertex :graph.getVertex(k).getAdjecentVertex()){
                if(!graph.isVisited(vertex.getData())){
                    kQueue.add(vertex.getData());
                    graph.setVisited(vertex.getData());
                }
            }
        }
        return  bfsList;
    }

    public void printBFS(){
        for(K k:bfsList)
            System.out.println(k);
    }

    public static void main(String[] args) {
        Graph<String> graph1=new Graph<>();
        graph1.add("A","B",10);
        graph1.add("B","C",10);
        graph1.add("C","F",10);
        graph1.add("C","D",10);
        graph1.add("F","D",10);
        graph1.add("D","E",10);
        graph1.add("E","A",10);
        BreadthFirstSearch<String> firstSearch =new BreadthFirstSearch(graph1 ,"A");
        firstSearch.bfs();
        firstSearch.printBFS();
    }
}
