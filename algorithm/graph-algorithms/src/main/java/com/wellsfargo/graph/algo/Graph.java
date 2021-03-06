package com.wellsfargo.graph.algo;

import java.util.*;

public class Graph<T> {

    private List<Edge<T>> allEdges;

    private Map<T,Vertex<T>> allVertex;

    boolean isDirected = false;

    public Graph(){
        this(false);
    }

    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<>();
        this.isDirected = isDirected;
    }

    public void addEdge(T id1, T id2){
        addEdge(id1,id2,0);
    }

    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(Vertex<T> vertex){
        if(allVertex.containsKey(vertex)){
            return;
        }
        allVertex.put(vertex.getData(), vertex);
        for(Edge<T> edge : vertex.getEdges()){
            allEdges.add(edge);
        }
    }

    public Vertex<T> addSingleVertex(T id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }

    public Vertex<T> getVertex(T id){
        return allVertex.get(id);
    }

    public void addEdge(T id1,T id2, int weight){
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }

    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }

    public void setDataForVertex(long id, T data){
        if(allVertex.containsKey(id)){
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public static class Vertex<T> {

        private T data;

        private boolean visited =false;

        private List<Edge<T>> edges = new ArrayList<>();

        private List<Vertex<T>> adjacentVertex = new ArrayList<>();

        public Vertex(T data) {
            this.data = data;
        }

        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }

        public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
            edges.add(e);
            adjacentVertex.add(v);
        }

        public String toString(){
            return data.toString();
        }

        public List<Vertex<T>> getAdjacentVertexes(){
            return adjacentVertex;
        }

        public List<Edge<T>> getEdges(){
            return edges;
        }

        public int getDegree(){
            return edges.size();
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (data.hashCode() ^ (data.hashCode() >>> 32));
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
            if (!data.equals(other.data))
                return false;
            return true;
        }
    }

    public static class Edge<T>{

        private boolean isDirected = false;

        private Vertex<T> vertex1;

        private Vertex<T> vertex2;

        private int weight;

        Edge(Vertex<T> vertex1, Vertex<T> vertex2){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
            this.isDirected = isDirected;
        }

        Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.isDirected = isDirected;
        }

        public Vertex<T> getVertex1(){
            return vertex1;
        }

        public Vertex<T> getVertex2(){
            return vertex2;
        }

        public int getWeight(){
            return weight;
        }

        public boolean isDirected(){
            return isDirected;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
            result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
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
            if (vertex1 == null) {
                if (other.vertex1 != null)
                    return false;
            } else if (!vertex1.equals(other.vertex1))
                return false;
            if (vertex2 == null) {
                if (other.vertex2 != null)
                    return false;
            } else if (!vertex2.equals(other.vertex2))
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        Graph<String> graph =new Graph();
        graph.addEdge("A" , "B" , 10);
        graph.addEdge("B" , "D" , 30);
        graph.addEdge("D" , "F" , 50);
        graph.addEdge("F" , "E" , 60);
        graph.addEdge("E" , "C" , 40);
        graph.addEdge("C" , "A" , 20);
        System.out.println("graph = " + graph);
        for(Graph.Vertex vertex:  graph.getAllVertex())
            System.out.println(vertex.data);
    }
}
