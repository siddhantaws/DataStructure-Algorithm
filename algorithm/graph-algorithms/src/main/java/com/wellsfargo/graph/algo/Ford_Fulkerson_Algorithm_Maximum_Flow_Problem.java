package com.wellsfargo.graph.algo;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ford_Fulkerson_Algorithm_Maximum_Flow_Problem {

    private int arr[][];

    private int tempArr[][];

    private boolean[] visitedVertex;

    private int [] parentVertex;

    private int source ;

    private  int sink;

    public Ford_Fulkerson_Algorithm_Maximum_Flow_Problem(int[][] arr, int source , int sink) {
        this.arr = arr;
        this.sink=sink;
        this.source=source;
        init();
    }

    public void init(){
        this.tempArr =new int[arr.length][arr[0].length];
        this.visitedVertex=new boolean[tempArr.length];
        this.parentVertex=new int[tempArr.length];
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                tempArr[i][j]=arr[i][j];
    }

    public void reset(){
        for( int i=0;i<visitedVertex.length;i++)
            visitedVertex[i]=false;
        for( int i=0;i<parentVertex.length;i++)
            parentVertex[i]=-1;
    }

    public boolean isBfs(){
        visitedVertex[source]=true;
        Queue<Integer> integers =new ArrayDeque<>();
        integers.add(source);

        while(integers.size()>0){
            int i =integers.poll();
            for(int k=0;k<tempArr[0].length;k++){
                if(tempArr[i][k]>0 && !visitedVertex[k]){
                    integers.add(k);
                    visitedVertex[k] =true;
                    parentVertex[k]=i;
                }
            }
        }
        return visitedVertex[sink];
    }

    public int fordFulkerson(){
        int max_flow = 0;  // There is no flow initially
        while(isBfs()){
            int pathFlow =Integer.MAX_VALUE;
            for(int v=sink;v!=source;v=parentVertex[v]){
                int u = parentVertex[v];
                pathFlow =Math.min(pathFlow ,tempArr[u][v]);
            }
            for(int v=sink;v!=source;v=parentVertex[v]){
                int u= parentVertex[v];
                tempArr[u][v]-=pathFlow;
                tempArr[v][u]+=pathFlow;
            }
            max_flow+=pathFlow;
            reset();
        }
        return max_flow;
    }


    public static void main(String[] args) {
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        Ford_Fulkerson_Algorithm_Maximum_Flow_Problem flowProblem =new Ford_Fulkerson_Algorithm_Maximum_Flow_Problem(graph, 0,5);
        System.out.println(flowProblem.fordFulkerson());
    }
}
