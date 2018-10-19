package com.wellsfargo.data_structure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<K> {

	private Map<K, Vertex<K>> mapOfVertex = new HashMap<>();
	private List<Edge<K>> edges = new ArrayList<>();
	private boolean isDirected = false;

	public Graph() {
		this(false);
	}
	
	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void add(K k1, K k2, int weight) {
		Edge<K> edge = new Edge<>(addVertex(k1), addVertex(k2), isDirected, weight);
		edges.add(edge);
		edge.v1.addAdjecentVertex(edge.v2);
		if(!isDirected)
			edge.v2.addAdjecentVertex(edge.v1);
	}

	public List<Edge<K>> getAllEdges(){
		return edges;
	}

	public Vertex<K> getVertex(K k){
		Vertex<K> vertex = mapOfVertex.get(k);
		return vertex;
	}


	public List<Vertex<K>> getAllVertices(){
		List<Vertex<K>> list=new ArrayList<>();
		for(Map.Entry<K ,Vertex<K>>  entry:mapOfVertex.entrySet())
			list.add(entry.getValue());
		return list;
	}

	public Vertex<K> addVertex(K k) {
		Vertex<K> vertex = mapOfVertex.get(k);
		if (vertex == null)
			mapOfVertex.put(k, vertex = new Vertex<>(k));
		return vertex;
	}
	public void setVisited(K k){
		Vertex<K> vertex = mapOfVertex.get(k);
		vertex.isVisited = true;
	}

	public boolean isVisited(K k){
		return mapOfVertex.get(k).isVisited;
	}

	static class Vertex<K> {

		private K k;

		private boolean isVisited =false ;
		public Vertex(K k) {
			this.k = k;
		}

		private List<Edge<K>> edges = new ArrayList<>();

		private List<Vertex<K>> connectedVertex = new ArrayList<>();

		public void addEdge(Edge<K> edge) {
			this.edges.add(edge);
		}
		
		public List<Edge<K>> getEdges(){
			return edges;
		}

		public void addAdjecentVertex(Vertex<K> v1) {
			this.connectedVertex.add(v1);
		}

		public List<Vertex<K>> getAdjecentVertex(){
			return connectedVertex;
		}

		public K getData(){
			return  k;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((connectedVertex == null) ? 0 : connectedVertex.size() * prime);
			result = prime * result + ((edges == null) ? 0 : edges.size()*prime);
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
			return k+"";
		}
	}

	static class Edge<K> {

		private Vertex<K> v1;

		private Vertex<K> v2;

		private int weight;

		private boolean isDirected = false;

		public Edge(Vertex<K> v1, Vertex<K> v2, int weight) {
			this(v1, v2, false, weight);
		}

		public Edge(Vertex<K> v1, Vertex<K> v2, boolean isDirected, int weight) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.isDirected = isDirected;
			this.weight = weight;
		}

		public Vertex<K> getV1() {
			return v1;
		}

		public Vertex<K> getV2() {
			return v2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (isDirected ? 1231 : 1237);
			result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
			result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
			result = prime * result + weight;
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
			return isDirected ? v1+"<==="+weight+" ===>"+v2  : v1+"=== "+weight+" ===>"+v2;
		}
	}
}
