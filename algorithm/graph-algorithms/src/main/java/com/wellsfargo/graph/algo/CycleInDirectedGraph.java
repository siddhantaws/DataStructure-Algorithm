package com.wellsfargo.graph.algo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class CycleInDirectedGraph<E> {

    private Graph<E>  graph;

    private Map<E , E>  map=new HashMap<>();

    private StackPlusMapDataStructure<Graph.Vertex<E>> stackPlusMapDataStructure ;

    public CycleInDirectedGraph(Graph<E> graph) {
        this.graph = graph;
        this.stackPlusMapDataStructure=new StackPlusMapDataStructure();
        Iterator<Graph.Vertex<E>> iterator = graph.getAllVertex().iterator();
        while(iterator.hasNext())
            stackPlusMapDataStructure.push(iterator.next());
    }
}
class StackPlusMapDataStructure<E> extends Stack<E>{

    private Map<E ,E > map;

    public StackPlusMapDataStructure()
    {
        this.map=new HashMap<>();
    }

    public boolean contain(E e)
    {
        return map.containsKey(e);
    }

    @Override
    public E push(E item) {

        E e =super.push(item);
        map.put(e ,e);
        return e;
    }

    @Override
    public synchronized E pop() {
        E e =super.pop();
        map.remove(e);
        return e;
    }
}