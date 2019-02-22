/*
package com.wellsfargo.graph.algo;


import com.wellsfargo.data_structure.graph.DisJointSet;

import java.util.*;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class KargerAlgorithmForMinimumCut {

    private Graph<String> graph;
    private DisJointSet<String> disjointSet;
    private List<Graph.Vertex<String>> vertexList ;

    public KargerAlgorithmForMinimumCut(Graph<String> graph) {
        this.graph = graph;
        List<String> stringList =new ArrayList<>();
        Iterator<Graph.Vertex<String>> vertexIterator= graph.getAllVertex().iterator();
        while(vertexIterator.hasNext()){
            vertexList.add(vertexIterator.next());
        }
        for(Graph.Vertex vertex :graph.getAllVertex())
            stringList.add(vertex.getData().toString());
        this.disjointSet =new DisJointSet(stringList);
    }

    public int getKargerMinCut(){
        int vertexCount = graph.getAllVertex().size();
        int totalEdges =graph .getAllEdges().size();
        while (vertexCount > 2) {
            // Pick a random edge
            int i = (int)Math.random() % totalEdges ;
            //disjointSet.findSet(graph.getAllVertex())
            String s1 = disjointSet.findSetElement(vertexList.get(i).getData());
            String s2 = disjointSet.findSetElement(vertexList.get(i).getAdjacentVertexes().get(0).getData());

            // If two corners belong to same subset, then no point considering this edge
            if(s1==s2)
                continue;
            // Else contract the edge (or combine the corners of edge into one vertex)
            else {
                System.out.println("Contracting edge " +vertexList.get(i).getData()+"-"+ vertexList.get(i).getAdjacentVertexes().get(0).getData());
                vertexCount--;
                Union(subsets, subset1, subset2);
            }
        }
        return 0;
    }

    // A function that does union of two sets of x and y  (uses union by rank)
    private void Union( String x, String y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high
        // rank tree (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and
            // increment its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }


        public static void main(String[] args) {
        Graph<String> graph = new Graph();
        */
/* Let us create following unweighted graph
        0------1
        | \    |
        |   \  |
        |     \|
        2------3   *//*

        graph.addEdge("0","1",10);
        graph.addEdge("1","3",10);
        graph.addEdge("0","2",10);
        graph.addEdge("2","3",10);
        graph.addEdge("0","3",10);
        KargerAlgorithmForMinimumCut algorithm =new KargerAlgorithmForMinimumCut(graph);

    }
}
*/
