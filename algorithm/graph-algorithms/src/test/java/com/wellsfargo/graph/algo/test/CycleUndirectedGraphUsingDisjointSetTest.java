package com.wellsfargo.graph.algo.test;

import com.wellsfargo.graph.algo.CycleUndirectedGraphUsingDisjointSet;
import com.wellsfargo.graph.algo.Graph;
import org.junit.Assert;
import org.junit.Test;


public class CycleUndirectedGraphUsingDisjointSetTest {

    @Test
   public void testCycleInUndirectedGraph()
   {
       Graph<String> graph = new Graph<String>(false);
       graph.addEdge("A" , "B" , 10);
       graph.addEdge("B" , "C" , 20);
       graph.addEdge("C" , "D" , 30);
       graph.addEdge("D" , "E" , 20);
       graph.addEdge("E" , "F" , 10);
       graph.addEdge("F" , "C" , 10);
       CycleUndirectedGraphUsingDisjointSet<String> cycleUndirectedGraphUsingDisjointSet=new CycleUndirectedGraphUsingDisjointSet(graph);
       Assert.assertTrue(cycleUndirectedGraphUsingDisjointSet.hasCycle());

       graph = new Graph<String>(false);
       graph.addEdge("A" , "B" , 10);
       graph.addEdge("B" , "C" , 20);
       graph.addEdge("C" , "D" , 30);
       graph.addEdge("C" , "E" , 20);
       graph.addEdge("C" , "J" , 10);
       graph.addEdge("J" , "G" , 10);
       graph.addEdge("G" , "I" , 10);
       graph.addEdge("G" , "H" , 10);

       cycleUndirectedGraphUsingDisjointSet=new CycleUndirectedGraphUsingDisjointSet(graph);
       Assert.assertFalse(cycleUndirectedGraphUsingDisjointSet.hasCycle());
   }


}
