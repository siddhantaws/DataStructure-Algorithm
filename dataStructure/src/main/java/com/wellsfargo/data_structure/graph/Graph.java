package com.wellsfargo.data_structure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<K ,V extends Comparable> {

    private Map<K, Vertex<K>> mapOfVertex = new HashMap<>();
    private List<K> allVertices = new ArrayList<>();
    private List<Edge<K,V>> edges = new ArrayList<>();
    private boolean isDirected = false;

    public Graph() {
        this(false);
    }

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }


    public Edge<K,V> getEdge(K v1 , K v2){
        Vertex<K> vertex =mapOfVertex.get(v1);
        if(vertex !=null)
            return vertex.getEdge().get(mapOfVertex.get(v2));
        throw new NullPointerException();
    }

    public void add(K k1, K k2, V weight) {
        Edge<K,V> edge = new Edge<>(addVertex(k1), addVertex(k2), isDirected, weight);
        edges.add(edge);
        edge.v1.addAdjecentVertex(edge.v2);
        if (!isDirected)
            edge.v2.addAdjecentVertex(edge.v1);
    }

    public List<Edge<K,V>> getAllEdges() {
        return edges;
    }

    public Vertex<K> getVertex(K k) {
        Vertex<K> vertex = mapOfVertex.get(k);
        return vertex;
    }


    public List<Vertex<K>> getAllVertices() {
        List<Vertex<K>> list = new ArrayList<>();
        for (Map.Entry<K, Vertex<K>> entry : mapOfVertex.entrySet())
            list.add(entry.getValue());
        return list;
    }

    public Vertex<K> addVertex(K k) {
        Vertex<K> vertex = mapOfVertex.get(k);
        if (vertex == null) {
            mapOfVertex.put(k, vertex = new Vertex<>(k));
            allVertices.add(k);
        }

        return vertex;
    }

    public List<K> getVertices(){
        return allVertices;
    }

    public void setVisited(K k) {
        Vertex<K> vertex = mapOfVertex.get(k);
        vertex.isVisited = true;
    }

    public boolean isVisited(K k) {
        return mapOfVertex.get(k).isVisited;
    }

    static class Vertex<K> {

        private K k;

        private boolean isVisited = false;

        public Vertex(K k) {
            this.k = k;
        }

        private List<Edge> edges = new ArrayList<>();

        private Map<Vertex<K> , Edge> edge =new HashMap();

        private List<Vertex<K>> connectedVertex = new ArrayList<>();

        public Map<Vertex<K>, Edge> getEdge() {
            return edge;
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
            this.edge.put(edge.getV1() == this ? edge.getV1() : edge.v2, edge);
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void addAdjecentVertex(Vertex<K> v1) {
            this.connectedVertex.add(v1);
        }

        public List<Vertex<K>> getAdjecentVertex() {
            return connectedVertex;
        }

        public K getData() {
            return k;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((connectedVertex == null) ? 0 : connectedVertex.size() * prime);
            result = prime * result + ((edges == null) ? 0 : edges.size() * prime);
            result = prime * result + ((k == null) ? 0 : k.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (connectedVertex == null) {
                if (other.connectedVertex != null)
                    return false;
            } else if (!connectedVertex.equals(other.connectedVertex))
                return false;
            if (edges == null) {
                if (other.edges != null)
                    return false;
            } else if (!edges.equals(other.edges))
                return false;
            if (k == null) {
                if (other.k != null)
                    return false;
            } else if (!k.equals(other.k))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return k + "";
        }
    }

    static class Edge<K ,V> {

        private Vertex<K> v1;

        private Vertex<K> v2;

        private V weight;

        private boolean isDirected = false;

        public Edge(Vertex<K> v1, Vertex<K> v2, V v) {
            this(v1, v2, false, v);
        }

        public Edge(Vertex<K> v1, Vertex<K> v2, boolean isDirected, V weight) {
            super();
            this.v1 = v1;
            this.v2 = v2;
            this.v1.addEdge(this);
            this.v2.addEdge(this);
            this.isDirected = isDirected;
            this.weight = weight;
        }

        public Vertex<K> getV1() {
            return v1;
        }

        public Vertex<K> getV2() {
            return v2;
        }

        public V getWeight() {
            return weight;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (isDirected ? 1231 : 1237);
            result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
            result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
            result = prime * result + weight.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Edge other = (Edge) obj;
            if (isDirected != other.isDirected)
                return false;
            if (v1 == null) {
                if (other.v1 != null)
                    return false;
            } else if (!v1.equals(other.v1))
                return false;
            if (v2 == null) {
                if (other.v2 != null)
                    return false;
            } else if (!v2.equals(other.v2))
                return false;
            if (weight != other.weight)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return isDirected ? v1 + "<===" + weight + " ===>" + v2 : v1 + "=== " + weight + " ===>" + v2;
        }
    }
}
