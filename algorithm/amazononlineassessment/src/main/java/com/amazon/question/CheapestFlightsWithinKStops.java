package com.amazon.question;

public class CheapestFlightsWithinKStops {

    private int[][] flights;

    private int src;
    private  int dst;
    private  int K ;

    public CheapestFlightsWithinKStops(int[][] flights, int src, int dst, int k) {
        this.flights = flights;
        this.src = src;
        this.dst = dst;
        K = k;
    }
}
