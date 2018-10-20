package com.wellsfargo.data_structure.graph;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckIfGraphIsTreeOrNot<K,V extends Comparable> {
    private Graph<K,V> graph;
    private CycleInUnDirectedGraph<K,V> cycleInUnDirectedGraph;
    private GraphConnected<K,V> graphConnected;

    public CheckIfGraphIsTreeOrNot(Graph<K,V> graph) {
        this.graph = graph;
        this.cycleInUnDirectedGraph =new CycleInUnDirectedGraph<>(graph);
        this.graphConnected =new GraphConnected<>(graph);

    }

    public boolean isTree(){
        return !cycleInUnDirectedGraph.hasContainCycle() &&  graphConnected.isConnected();
    }

    public static void main(String[] args) {
        Graph<String,Integer> graph =new Graph<>();
        graph.add("A","B", 1);graph.add("A","C", 1);
        graph.add("B","G", 1);graph.add("C","I", 1);
        graph.add("B","E", 1);graph.add("C","F", 1);
        CheckIfGraphIsTreeOrNot checkIfGraphIsTreeOrNot=new CheckIfGraphIsTreeOrNot(graph);
        System.out.println(checkIfGraphIsTreeOrNot.isTree());
    }
}
