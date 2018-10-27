package com.wellsfargo.data_structure.graph;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Maximum_Flow_Ford_Fulkerson_Algorithm<K, V extends Comparable> {

    private Graph<K, V> graph;

    private Integer maxFlow = 0;

    private Set<K> visitedSet;

    private Map<K, K> pathMap;

    private K sourceVertex;

    private K destVertex;

    private Map<ResidualCapacity<K>, Integer> residualCapacityIntegerMap;

    public Maximum_Flow_Ford_Fulkerson_Algorithm(Graph<K, V> graph, K sourceVertex, K destVertex) {
        this.graph = graph;
        this.visitedSet = new HashSet<>();
        this.pathMap = new HashMap<>();
        this.sourceVertex = sourceVertex;
        this.destVertex = destVertex;
        this.residualCapacityIntegerMap = new HashMap<>();
        for (Graph.Edge<K, V> edge : graph.getAllEdges()) {
            residualCapacityIntegerMap.put(new ResidualCapacity(edge.getV1(), edge.getV2()), (Integer) edge.getWeight());
        }
    }


    private Integer getMaxFlow() {
        Queue<K> kQueue = new ArrayDeque<>();
        boolean foundAugmentedPath =false;
        kQueue.add(sourceVertex);
        K ver = kQueue.peek();
        while (!kQueue.isEmpty() || foundAugmentedPath) {
            Graph.Vertex<K> vertex = graph.getVertex(ver);
            for (Graph.Vertex<K> vertex1 : vertex.getAdjecentVertex()) {
                if (!visitedSet.contains(vertex1.getData()) && residualCapacityIntegerMap.get(new ResidualCapacity(vertex.getData(), vertex1.getData())).intValue() > 0) {
                    pathMap.put(vertex1.getData(), vertex.getData());
                    if (!vertex1.getData().equals(destVertex)) {
                        visitedSet.add(vertex1.getData());
                        pathMap.put(vertex1.getData(), vertex.getData());
                        kQueue.add(vertex1.getData());
                    } else {
                        maxFlow = maxFlow + findMinimumEdge();
                        foundAugmentedPath =true ;
                        return maxFlow;
                    }
                }
            }
        }
        return maxFlow;
    }

    private int findMinimumEdge() {
        int min = Integer.MAX_VALUE;
        K sVertex = destVertex;
        while (!sVertex.equals(sourceVertex)) {
            K vertex = pathMap.get(sVertex);
            min = Math.min(min, (Integer) graph.getEdge(sVertex, vertex).getWeight());
            sVertex = vertex;
        }
        sVertex = destVertex;
        while (!sVertex.equals(sourceVertex)) {
            K vertex = pathMap.get(sVertex);
            ResidualCapacity residualCapacity = new ResidualCapacity<>(vertex, sVertex);
            residualCapacityIntegerMap.put(residualCapacity, residualCapacityIntegerMap.get(residualCapacityIntegerMap).intValue() - min);
            sVertex = vertex;
        }
        return min;
    }


    static class ResidualCapacity<K> {
        K v1 ; K v2;

        public ResidualCapacity(K v1, K v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ResidualCapacity<?> that = (ResidualCapacity<?>) o;
            return Objects.equals(v1, that.v1) &&
                    Objects.equals(v2, that.v2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(v1, v2);
        }
    }
}
