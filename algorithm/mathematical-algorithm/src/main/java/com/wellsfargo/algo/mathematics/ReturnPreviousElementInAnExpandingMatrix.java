package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ReturnPreviousElementInAnExpandingMatrix {

    private String str;

    public ReturnPreviousElementInAnExpandingMatrix(String str) {
        this.str = str;
    }

    public String findLeft(){
        return findLeft(new StringBuilder(str));
    }

    private String findLeft(StringBuilder str) {
        int n = str.length();
        // Start from rightmost position
        while (n > 0) {
            n--;
            // If the current character is b or d, change to a or c respectively and  break the loop
            if (str.charAt(n) == 'd') {
                str.setCharAt(n,'c');
                break;
            }
            if (str.charAt(n) == 'b') {
                str.setCharAt(n,'a');
                break;
            }
            // If the current character is a or c, change it to b or d respectively
            if (str.charAt(n) == 'a')
                str.setCharAt(n,'b');
            else if (str.charAt(n) == 'c')
                str.setCharAt(n,'d');
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ReturnPreviousElementInAnExpandingMatrix element =new ReturnPreviousElementInAnExpandingMatrix("ab");
        System.out.println(element.findLeft());
    }
}
