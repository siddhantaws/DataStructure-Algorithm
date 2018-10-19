/*
package com.wellsfargo.data_structure.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class LongestPathInDirectedAcyclicGraph<K> {

    private Graph<K> graph ;

    private TopoLogicalSort<K> kTopoLogicalSort;

    private List<K> kList;

    private Map<K , Integer> map ;

    public LongestPathInDirectedAcyclicGraph(Graph<K> graph){
        this.graph = graph;
        this.kTopoLogicalSort =new TopoLogicalSort<>(graph);
        this .kList= kTopoLogicalSort.topologicalSortedVertex();
        this.map=new HashMap<>();
    }

    public Map<K, Integer> getAllLongestpath(){
        for(K k:kList){
            for(Graph.Vertex<K> vertex :graph.getVertex(k).getAdjecentVertex()){
                if(map.containsKey(vertex.getData())){
                    map.get(vertex.getData())
                }else{
                    map.put(vertex.getData() , )
                }
            }
        }
    }

}
*/
