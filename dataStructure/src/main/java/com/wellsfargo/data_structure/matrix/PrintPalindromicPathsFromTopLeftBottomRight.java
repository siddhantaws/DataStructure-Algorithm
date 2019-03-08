package com.wellsfargo.data_structure.matrix;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintPalindromicPathsFromTopLeftBottomRight {

    private char[][] charArray;

    private int N;

    private char ch[];

    public PrintPalindromicPathsFromTopLeftBottomRight(char[][] charArray) {
        this.charArray = charArray;
        this.N = charArray.length;
        this.ch = new char[N];
    }

    private void printPalimdrom(int i, int j, int l, char ch[], int lefthashCode, int rightHashCode) {
        if (i < N && j < N) {
            if (i == j && i == N - 1) {
                if (lefthashCode == rightHashCode)
                    printIfPalimdrom(i, j, l, ch);
            } else {
                ch[l] = charArray[i][j + 1];
                printPalimdrom(i, j + 1, l + 1, ch, getHashCode(l + 1, true ,ch ,lefthashCode ) ,  rightHashCode);
                ch[l] = charArray[i+1][j];
                printPalimdrom(i + 1, j, l + 1, ch, lefthashCode ,   getHashCode(l + 1, false ,ch ,lefthashCode));
            }
        }
    }

    private void printIfPalimdrom(int i, int j, int l, char ch[]) {
        for (int i1 = i, j1 = j; i1 != j1 && j1 > i1; i1++, j1++) {
            if (ch[i1] == ch[j1])
                continue;
            else
                return;
        }
        System.out.println(new String(ch, i, j - 1 + 1));
    }

    public void printPalimdrom(){
        ch[0] =charArray[0][0];
        printPalimdrom(0,0,1,ch,getHashCode( 1, true ,ch ,0) ,getHashCode( 1, false,ch ,0) );
    }

    private int getHashCode(int l , boolean left , char ch[] , int hashCode){
        if(left && l%2==0){
            hashCode =hashCode +ch[(l/2)-1]*31;
        }else if(!left && l%2==0){
            hashCode =hashCode - ch[l/2]*31 +ch[l-1]*31;
        }
        return hashCode;
    }

}
