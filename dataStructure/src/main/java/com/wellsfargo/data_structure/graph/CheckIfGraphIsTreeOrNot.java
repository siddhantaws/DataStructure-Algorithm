package com.wellsfargo.data_structure.graph;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckIfGraphIsTreeOrNot<K> {
    private Graph<K> graph;
    private CycleInUnDirectedGraph<K> cycleInUnDirectedGraph;
    private GraphConnected<K> graphConnected;

    public CheckIfGraphIsTreeOrNot(Graph<K> graph) {
        this.graph = graph;
        this.cycleInUnDirectedGraph =new CycleInUnDirectedGraph<>(graph);
        this.graphConnected =new GraphConnected<>(graph);

    }

    public boolean isTree(){
        return !cycleInUnDirectedGraph.hasContainCycle() &&  graphConnected.isConnected();
    }

    public static void main(String[] args) {
        Graph<String> graph =new Graph<>();
        graph.add("A","B", 1);graph.add("A","C", 1);
        graph.add("B","G", 1);graph.add("C","I", 1);
        graph.add("B","E", 1);graph.add("C","F", 1);
        CheckIfGraphIsTreeOrNot checkIfGraphIsTreeOrNot=new CheckIfGraphIsTreeOrNot(graph);
        System.out.println(checkIfGraphIsTreeOrNot.isTree());
    }
}
