package com.wellsfargo.data_structure.graph;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ArticulationPointsGraphAlgorithm<K> {

    private Graph<K> graph;

    private Set<K> visitedSet;

    private List<K> articulationPoint;

    private Map<K , DfsAndLowTime> map;

    static class DfsAndLowTime{
        int travelTime ;
        int lowTime;
        public DfsAndLowTime(int travelTime, int lowTime) {
            this.travelTime = travelTime;
            this.lowTime = lowTime;
        }
    }

    public ArticulationPointsGraphAlgorithm(Graph<K> graph) {
        this.graph = graph;
        this.visitedSet = new HashSet<>();
        this.map = new HashMap<>();
        this.articulationPoint = new ArrayList<>();
    }

    public List<K> getArticulationPoint(K source){
        map.put(source,new DfsAndLowTime(0 , 0));
        visitedSet.add(source);
        for(Graph.Vertex<K> vertex: graph.getVertex(source).getAdjecentVertex()){
            if(!visitedSet.contains(vertex.getData())){
                visitedSet.add(vertex.getData());
                map.put(vertex.getData(), new DfsAndLowTime(map.get(source).travelTime+1 , map.get(source).travelTime+1));
                getArticulationPoint(source , vertex.getData());
            }
        }
        return articulationPoint;
    }

    private void getArticulationPoint(K source , K current){
        for(Graph.Vertex<K> vertex :graph.getVertex(current).getAdjecentVertex()){
            if(!source.equals(vertex.getData()) &&  !visitedSet.contains(vertex.getData())){
                map.put(vertex.getData(), new DfsAndLowTime( map.get(current).travelTime+1 , map.get(current).travelTime+1 ));
                visitedSet.add(current);
                getArticulationPoint(current , vertex.getData());
            }else if(!source.equals(vertex.getData()) && visitedSet.contains(vertex.getData())) {
                int visitedTimeOfCurrent = map.get(current).travelTime;
                int lowTimeOfAdjVertex = map.get(vertex.getData()).lowTime;
                if(visitedTimeOfCurrent<=lowTimeOfAdjVertex)
                    articulationPoint.add(current);
                else
                    map.get(vertex.getData()).lowTime =lowTimeOfAdjVertex;
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> graph =new Graph<>();
        graph.add("A","B", 1);graph.add("A","C", 1);graph.add("D","E", 1);
        graph.add("B","C", 1);graph.add("C","D", 1);graph.add("G","E", 1);
        graph.add("G","F", 1);graph.add("F","E", 1);graph.add("H","F", 1);
        ArticulationPointsGraphAlgorithm<String> pointsGraphAlgorithm =new ArticulationPointsGraphAlgorithm(graph);
        for(String s:pointsGraphAlgorithm.getArticulationPoint("D")){
            System.out.println(s);
        }
    }
}
