package com.google.question;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumNumberFlipsConvertBinaryMatrix2ZeroMatrix {
    private int[][] matrix;

    public MinimumNumberFlipsConvertBinaryMatrix2ZeroMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int minFlips(){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        // check the size
        int m = matrix.length;
        int n = matrix[0].length;
        // length of the bit
        int len = m * n;
        // queue for bfs
        Queue<Integer> queue = new LinkedList<>();
        // integer stands for the start node
        int start = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                start = (start << 1) | matrix[i][j];
            }
        }
        Set<Integer> visited = new HashSet<>();
        int step = 0;
        // init first node in bfs
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                if(cur == 0) return step;
                // still need to flip the number, there is len ways to flip it.
                for(int j = 0; j < len; j++) {
                    int next = flip(cur, j, m, n);
                    // if we ever got to the state, we skip it
                    if(!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private static int flip(int num, int idx, int m, int n) {
        // calculate the column and row from idx
        int i = idx / n;
        int j = idx % n;
        // reverse itself and 4 neighors if theres any
        num = num ^ (1 << idx);
        if(i > 0)
            num = num ^ (1 << ((i-1)*n + j));
        if(j > 0)
            num = num ^ (1 << (idx-1));
        if(i < m-1)
            num = num ^ (1 << ((i+1)*n + j));
        if(j < n-1)
            num = num ^ (1 << (idx+1));

        return num;
    }



    public static void main(String[] args) {
       /*int [][] mat = {{0,0},{0,1}};
        MinimumNumberFlipsConvertBinaryMatrix2ZeroMatrix matrix =new MinimumNumberFlipsConvertBinaryMatrix2ZeroMatrix(mat);
        System.out.println(matrix.minFlips());*/
        System.out.println(flip(1,0,2,2));
    }
}
