package com.wellsfargo.algo.mathematics;

public class _2sComplement {
    private String str;

    public _2sComplement(String str) {
        this.str = str;
    }

    public String get2SComplement(){
        return get2SComplement(new StringBuffer(str));
    }

    private String get2SComplement(StringBuffer str){
        int n = str.length();
        int i;

        for (i = n-1 ; i >= 0 ; i--)
            if (str.charAt(i) == '1')
                break;

        // If there exists no '1' concat 1 at the
        // starting of string
        if (i == 0)
            return "1" + str;

        // Continue traversal after the position of
        // first '1'
        for (int k = i-1 ; k >= 0; k--)
        {
            //Just flip the values
            if (str.charAt(k) == '1')
                str.replace(k, k+1, "0");
            else
                str.replace(k, k+1, "1");
        }
    // return the modified string
        return str.toString();
    }

    public static void main(String[] args) {
        _2sComplement complement = new _2sComplement("1000100");
        System.out.println(complement.get2SComplement());
    }
}
