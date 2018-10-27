package com.wfs.greedy_algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class JobSequencingProblem_DisJointSet {

    private static List<Job> jobList;
    private DisJointSet dsu;

    public JobSequencingProblem_DisJointSet(List<Job> jobList) {
        this.jobList = jobList;
        Collections.sort(this.jobList);
        int maxDeadline = findMaxDeadline();
        dsu = new DisJointSet(maxDeadline);
    }

    public static int findMaxDeadline() {
        int ans = Integer.MIN_VALUE;
        for (Job temp : jobList)
            ans = Math.max(temp.deadLine, ans);
        return ans;
    }

    static class Job implements Comparable<Job> {
        String id;
        int deadLine;
        int profit;

        public Job(String id, int deadLine, int profit) {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return o.profit - this.profit;
        }
    }

    static class DisJointSet {
        int parent[];

        DisJointSet(int n) {
            parent = new int[n + 1];

            // Every node is a parent of itself
            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }

        // Path Compression
        int find(int s) {
        /* Make the parent of the nodes in the path
           from u--> parent[u] point to parent[u] */
            if (s == parent[s])
                return s;
            return parent[s] = find(parent[s]);
        }

        // Makes u as parent of v.
        void merge(int u, int v) {
            //update the greatest available
            //free slot to u
            parent[v] = u;
        }
    }

    public void printJobScheduling() {

        for (Job temp : jobList) {
            // Find the maximum available free slot for
            // this job (corresponding to its deadline)
            int availableSlot = dsu.find(temp.deadLine);


            // If maximum available free slot is greater
            // than 0, then free slot available
            if (availableSlot > 0) {
                // This slot is taken by this job 'i'
                // so we need to update the greatest free
                // slot. Note that, in merge, we make
                // first parameter as parent of second
                // parameter.  So future queries for
                // availableSlot will return maximum slot
                // from set of "availableSlot - 1"
                dsu.merge(dsu.find(availableSlot - 1),
                        availableSlot);
                System.out.print(temp.id + " ");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Job> arr=new ArrayList<Job>();
        arr.add(new Job("a",2,100));
        arr.add(new Job("b",1,19));
        arr.add(new Job("c",2,27));
        arr.add(new Job("d",1,25));
        arr.add(new Job("e",3,15));
        JobSequencingProblem_DisJointSet disJointSet =new JobSequencingProblem_DisJointSet(arr);
        disJointSet.printJobScheduling();
    }

}
