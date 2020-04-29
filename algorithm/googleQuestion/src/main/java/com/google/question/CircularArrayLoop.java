package com.google.question;

import java.util.Vector;

public class CircularArrayLoop {

    // A simple Graph DFS based recursive function
    // to check if there is cycle in graph with
    // vertex v as root of DFS. Refer below article for details.
    // https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    static boolean isCycleRec(int v, Vector<Integer>[] adj,
                              Vector<Boolean> visited,
                              Vector<Boolean> recur)
    {
        visited.set(v, true);
        recur.set(v, true);

        for (int i = 0; i < adj[v].size(); i++)
        {
            if (visited.elementAt(adj[v].elementAt(i)) == false)
            {
                if (isCycleRec(adj[v].elementAt(i),
                        adj, visited, recur))
                    return true;
            }

            // There is a cycle if an adjacent is visited
            // and present in recursion call stack recur[]
            else if (visited.elementAt(adj[v].elementAt(i)) == true &&
                    recur.elementAt(adj[v].elementAt(i)) == true)
                return true;
        }
        recur.set(v, false);
        return false;
    }

    // Returns true if arr[] has cycle
    @SuppressWarnings("unchecked")
    static boolean isCycle(int[] arr, int n)
    {

        // Create a graph using given moves in arr[]
        Vector<Integer>[] adj = new Vector[n];
        for (int i = 0; i < n; i++)
            if (i != (i + arr[i] + n) % n &&
                    adj[i] != null)
                adj[i].add((i + arr[i] + n) % n);

        // Do DFS traversal of graph to detect cycle
        Vector<Boolean> visited = new Vector<>();
        for (int i = 0; i < n; i++)
            visited.add(true);
        Vector<Boolean> recur = new Vector<>();
        for (int i = 0; i < n; i++)
            recur.add(true);

        for (int i = 0; i < n; i++)
            if (visited.elementAt(i) == false)
                if (isCycleRec(i, adj, visited, recur))
                    return true;
        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = { -2,1,-1,-2,-2};
        int n = arr.length;
        if (isCycle(arr, n) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
