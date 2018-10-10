package com.wellsfargo.data_structure.tree;

public class HeightOfGenericTreeFromParentArray {
    private static int[] parent;
    private static int visited[];
    private static int height[];

    public HeightOfGenericTreeFromParentArray(int[] parent) {
        this.parent = parent;
        this.visited = new int[parent.length];
        this.height = new int[parent.length];
    }

    // Recur For Ancestors of node and  store height of node at last
    static int fillHeight(int p[], int node, int visited[], int height[]) {
        // If root node
        if (p[node] == -1) {

            // mark root node as visited
            visited[node] = 1;
            return 0;
        }

        // If node is already visited
        if (visited[node] == 1)
            return height[node];

        // Visit node and calculate its height
        visited[node] = 1;

        // recur for the parent node
        height[node] = 1 + fillHeight(p, p[node],
                visited, height);

        // return calculated height for node
        return height[node];
    }

    static int findHeight( int n) {
        // To store max height
        int ma = 0;
        for (int i = 0; i < n; i++) {

            // If not visited before
            if (visited[i] != 1)
                height[i] = fillHeight(parent, i,
                        visited, height);

            // store maximum height so far
            ma = Math.max(ma, height[i]);
        }
        return ma;
    }

    public static void main(String[] args) {
        int parent[] = { -1, 0, 0, 0, 3, 1, 1, 2 };
        HeightOfGenericTreeFromParentArray height =new HeightOfGenericTreeFromParentArray(parent);
        System.out.println("Height of N-ary Tree = "+findHeight(parent.length));
    }
}
