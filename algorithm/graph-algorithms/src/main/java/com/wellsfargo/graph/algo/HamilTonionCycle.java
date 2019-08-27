package com.wellsfargo.graph.algo;

import java.util.*;

public class HamilTonionCycle {
    private int[][] arr;

    private MapAndStackDS<Integer> mapAndStackDS;

    private int V;

    public HamilTonionCycle(int[][] arr) {
        this.arr = arr;
        this.V=arr.length;
        this.mapAndStackDS=new MapAndStackDS<>();
    }


    public void hamiltonionCycle(){
        mapAndStackDS.add(0);
        hamiltonionCycle(0);
    }

    private void hamiltonionCycle(int vertex){
        if(mapAndStackDS.size()==V){
            if(arr[vertex][0]>0)
                flush();
            else
                return;
        }
        for(int i=0;i<V;i++){
            if(mapAndStackDS.contains(i))
                continue;
            else if(arr[vertex][i]>0){
                mapAndStackDS.add(i);
                hamiltonionCycle(i);
                mapAndStackDS.poll();
            }
        }
    }

    private void flush(){
        Iterator<Integer> eIterator =mapAndStackDS.getSet().iterator();
        while(eIterator.hasNext())
            System.out.print(eIterator.next()+" ");
        System.out.println("");
    }

    class MapAndStackDS<E>{
        private Stack<E> eStack=new Stack<>();
        private Set<E> set =new LinkedHashSet<>();

        public Set<E> getSet() {
            return set;
        }

        public void add(E e){
            eStack.push(e);
            set.add(e);
        }

        public boolean contains(E e){
            return set.contains(e);
        }

        public void poll(){
            set.remove(eStack.pop());
        }

        public E peek(){
            return eStack.peek();
        }

        public int size(){
            return  eStack.size();
        }
    }



}
