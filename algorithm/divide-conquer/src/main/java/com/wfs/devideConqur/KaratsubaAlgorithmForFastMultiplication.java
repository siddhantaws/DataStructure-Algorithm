package com.wfs.devideConqur;

public class KaratsubaAlgorithmForFastMultiplication {
    private Long digit1;
    private Long digit2;

    public KaratsubaAlgorithmForFastMultiplication(Long digit1, Long digit2) {
        this.digit1 = digit1;
        this.digit2 = digit2;
    }

    public int getSize(long num) {
        int ctr = 0;
        while (num != 0) {
            ctr++;
            num /= 10;
        }
        return ctr;
    }

    public long multiply(){
        return multiply(digit1,digit2);
    }
    private long multiply(long x, long y)
    {
        int size1 = getSize(x);
        int size2 = getSize(y);
        /** Maximum of lengths of number **/
        int N = Math.max(size1, size2);
        /** for small values directly multiply **/
        if (N < 3)
            return x * y;
        /** max length divided, rounded up **/
        N = (N / 2) + (N % 2);
        /** multiplier **/
        long m = (long)Math.pow(10, N);

        /** compute sub expressions **/
        long b = x / m;
        long a = x - (b * m);
        long d = y / m;
        long c = y - (d * m);
        /** compute sub expressions **/
        long z0 = multiply(a, c);
        long z1 = multiply(a + b, c + d);
        long z2 = multiply(b, d);

        return z0 + ((z1 - z0 - z2) * m) + (z2 * (long)(Math.pow(10, 2 * N)));
    }

    public static void main(String[] args) {
        KaratsubaAlgorithmForFastMultiplication karatsubaAlgorithmForFastMultiplication =new KaratsubaAlgorithmForFastMultiplication(95689l ,12349l);
        System.out.println(karatsubaAlgorithmForFastMultiplication.multiply());
    }

}
