package com.wellsfargo.data_structure.graph;

public class Graph_Matrix {
	
	private int[][]matrix ;
	
	private int numberOfVertices ;

	private boolean isDirected;
	
	public Graph_Matrix(int numberOfVertices) {
		this(numberOfVertices , true);
	}
	public Graph_Matrix(int numberOfVertices ,boolean isDirected ) {
		this.numberOfVertices = numberOfVertices;
		this.isDirected=isDirected;
		matrix=new int[numberOfVertices][numberOfVertices];
	} 
	
	public void setEdge(int start,int end) {
		if(!isDirected)
			matrix[end][start]=1;	
		matrix[start][end]=1;
		
	}
	
	public int getEdge(int start, int end) {
		return matrix[start][end];
	}
	

	public static void main(String[] args) {
		int numberOfVertices = 5;
		Graph_Matrix matrix =new Graph_Matrix(numberOfVertices);
	}
}
