package com.wellsfargo.algo.pattern_matching;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ProgramToWishWomenDay {
    private int n ;

    private String[][] strings;
    private int row ;
    public ProgramToWishWomenDay(int n) {
        this.n = n;
        this.row=n + 2*((n/2)+1);
        this.strings=new String[row+3 ][row+17];
    }

    public void fill(){
        int start = (n/2)+1 , end = row - (n/2)+1;
        for(int i=start;i<=end;i++){
            strings[0][i]="$";
        }
        int start1 = start , end1 =end;
        int i=1;
        while(start>=0 && end1<=row){
            strings[i][--start]="$";
            strings[i][++end1]="$";
            i++;
        }
        start1=1;
        while(start1<n){
            strings[i][0]="$";
            strings[i][row]="$";
            i++;
        }


    }
}
