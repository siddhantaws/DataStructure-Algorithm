package com.wellsfargo.data_structure.graph;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphColoring_Greedy {

    class Graph{
         private int v;
         private LinkedList<Integer> linkedList[];

        Graph(int v){
            this.v=v;
            this.linkedList=new LinkedList[v];
            for(int i=0;i<v;i++)
                linkedList[i]=new LinkedList<>();
        }

        public void addEdge(int u , int v){
            linkedList[u].add(v);
            linkedList[v].add(u);
        }

        void greedyColoring(){
            int result[]=new int[v];

            Arrays.fill(result,-1);

            result[0] =0;

            boolean available[] =new boolean[v];

            Arrays.fill(available , true);

            for(int u=1;u<v;u++){

                Iterator<Integer> iterators = linkedList[u].iterator();
                while(iterators.hasNext()){
                    int i= iterators.next();
                    if(result[i]!=-1)
                        available[result[i]]=false;
                }

                int cr=0;
                for(cr=0;cr<v;cr++)
                    if(available[cr])
                        break;

                result[u] =cr;

                iterators = linkedList[u].iterator();
                while(iterators.hasNext()){
                    int i= iterators.next();
                    if(result[i]!=-1)
                        available[result[i]]=true;
                }

            }
            // print the result
            for (int u = 0; u < v; u++)
                System.out.println("Vertex " + u + " --->  Color " + result[u]);
        }
    }


    public static void main(String[] args) {
        GraphColoring_Greedy.Graph g1 = new GraphColoring_Greedy().new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();
    }
}
