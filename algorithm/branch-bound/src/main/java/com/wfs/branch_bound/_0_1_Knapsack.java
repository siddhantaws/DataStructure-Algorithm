package com.wfs.branch_bound;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class _0_1_Knapsack {

    private Item[] items;
    private int W;
    private int n;

    public _0_1_Knapsack(Item[] items, int w) {
        this.items = items;
        W = w;
        this.n=items.length;
    }

    static class Item implements Comparable<Item>{

        private int weight ;

        private int profit ;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }

        @Override
        public int compareTo(Item o) {
            return (this.profit/this.weight)-(o.profit/o.weight) ;
        }
    }
    static class Node{
        // level  --> Level of node in decision tree (or index in arr[]
        // profit --> Profit of nodes on path from root to this node (including this node)
        // bound ---> Upper bound of maximum profit in subtree of this node/
        int level, profit, bound;
        float weight;
        public Node(){}
        public Node(int level, int profit, float weight) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
        }
    }

    // Returns bound of profit in subtree rooted with u.  This function mainly uses Greedy solution to find an upper bound on maximum profit.
    private int bound(Node u) {
        // if weight overcomes the knapsack capacity, return 0 as expected bound
        if (u.weight >= W)
            return 0;
        // initialize bound on profit by current profit
        int profit_bound = u.profit;
        // start including items from index 1 more to current item index
        int j = u.level + 1;
        int totweight =(int) u.weight;
        // checking index condition and knapsack capacity condition
        while ((j < n) && (totweight + items[j].weight <= W)) {
            totweight    += items[j].weight;
            profit_bound += items[j].profit;
            j++;
        }
        // If k is not n, include last item partially for upper bound on profit
        if (j < n)
            profit_bound += (W - totweight) * items[j].profit /items[j].weight;
        return profit_bound;
    }

    // Returns maximum profit we can get with capacity W
    public int knapsack() {
        // sorting Item on basis of value per unit weight.
        Arrays.sort(items);
        // make a queue for traversing the node
        Queue<Node> Q =new ArrayDeque<>();
        Node u, v=new Node();
        // dummy node at starting
        u =new Node(-1,0, 0);
        ((ArrayDeque<Node>) Q).push(u);
        // One by one extract an item from decision tree compute profit of
        // all children of extracted item and keep saving maxProfit
        int maxProfit = 0;
        while (!Q.isEmpty()) {
            // Dequeue a node
            u = Q.peek();
            Q.poll();
            // If it is starting node, assign level 0
            if (u.level == -1)
                v.level = 0;
            // If there is nothing on next level
            if (u.level == n-1)
                continue;
            // Else if not last node, then increment level, and compute profit of children nodes.
            v.level = u.level + 1;
          v.weight = u.weight + items[v.level].weight;
            v.profit = u.profit + items[v.level].profit;
            // If cumulated weight is less than W and profit is greater than previous profit, update maxprofit
            if (v.weight <= W && v.profit > maxProfit)
                maxProfit = v.profit;
            // Get the upper bound on profit to decide whether to add v to Q or not.
            v.bound = bound(v);
            // If bound value is greater than profit, then only push into queue for further consideration
            if (v.bound > maxProfit)
                ((ArrayDeque<Node>) Q).push(v);
            // Do the same thing,  but Without taking the item in knapsack
            v.weight = u.weight;
            v.profit = u.profit;
            v.bound = bound(v);
            if (v.bound > maxProfit)
                ((ArrayDeque<Node>) Q).push(v);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Item arr[] = { new Item(2, 10),  new Item(4, 10),  new Item(6, 12),
            new Item(9, 18)};
        int W = 15;
        _0_1_Knapsack knapsack=new _0_1_Knapsack(arr, W );
        System.out.println(knapsack.knapsack());
    }
}
