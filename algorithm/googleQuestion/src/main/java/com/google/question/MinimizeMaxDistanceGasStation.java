package com.google.question;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceGasStation {
    private int[] stations;
    private int K;

    public MinimizeMaxDistanceGasStation(int[] stations, int k) {
        this.stations = stations;
        K = k;
    }

    public double minmaxGasDist() {
        double lo = 0, hi = stations[stations.length-1];
        while (hi - lo > 1e-6) {
            double mi = (lo + hi) / 2.0;
            if (possible(mi, stations, K))
                hi = mi;
            else
                lo = mi;
        }
        return lo;
    }

    public double minmaxGasDist(int[] stations, int K) {
        int N = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                (double)b[0]/b[1] < (double)a[0]/a[1] ? -1 : 1);
        for (int i = 0; i < N-1; ++i)
            pq.add(new int[]{stations[i+1] - stations[i], 1});

        for (int k = 0; k < K; ++k) {
            int[] node = pq.poll();
            node[1]++;
            pq.add(node);
        }

        int[] node = pq.poll();
        return (double)node[0] / node[1];
    }

    public boolean possible(double D, int[] stations, int K) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; ++i)
            used += (int) ((stations[i+1] - stations[i]) / D);
        return used <= K;
    }

    public static void main(String[] args) {
        MinimizeMaxDistanceGasStation gasStation =new MinimizeMaxDistanceGasStation(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},9);
        System.out.println(gasStation.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},9));
    }
}
