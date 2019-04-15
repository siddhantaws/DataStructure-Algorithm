package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class QueriesOnXORGreatestOddDivisorRange {

    private int arr[];
    private int preXOR[];
    private int n;

    public QueriesOnXORGreatestOddDivisorRange(int[] arr) {
        this.arr = arr;
        this.n=arr.length;
        this.preXOR =new int[arr.length];
        prefixXOR();
    }

    // Precompute the prefix XOR of greatest odd divisor
    void prefixXOR() {
        // Finding the Greatest Odd divisor
        for (int i = 0; i < n; i++) {
            while (arr[i] % 2 != 1)
                arr[i] /= 2;

            preXOR[i] = arr[i];
        }
        // Finding prefix XOR
        for (int i = 1; i < n; i++)
            preXOR[i] = preXOR[i - 1] ^ preXOR[i];
    }

    // Return XOR of the range
    int query(int l, int r) {
        if (l == 0)
            return preXOR[r];
        else
            return preXOR[r] ^ preXOR[l - 1];
    }

    public static void main(String[] args) {
        QueriesOnXORGreatestOddDivisorRange queries =new QueriesOnXORGreatestOddDivisorRange(new int[]{4,5,6,7,8});
        System.out.println(queries.query(0,2));
    }
}
