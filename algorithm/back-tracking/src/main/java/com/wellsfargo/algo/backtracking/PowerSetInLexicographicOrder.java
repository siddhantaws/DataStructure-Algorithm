package com.wellsfargo.algo.backtracking;

import java.util.Arrays;
import java.util.Collections;

public class PowerSetInLexicographicOrder {

    private String name ;


    public PowerSetInLexicographicOrder(String name) {
        this.name = name;
    }

    public void genLexicoGraphOrder(){
        char[] chs=name.toCharArray();
        Arrays.sort(chs);
        name= new String(chs);
        permuteRec(name , name.length() , -1 ,"");
    }

    private void permuteRec(String str , int n ,int index ,String curr){
        if(index ==n)
            return;
        System.out.println(curr);

        for(int i=index+1;i<n;i++){
            curr +=str.toCharArray()[i]+"";
            permuteRec(str,n , i ,curr);
            curr = curr.substring(0 ,curr.length()-1 );
        }
    }

    public static void main(String[] args) {
        PowerSetInLexicographicOrder set =new PowerSetInLexicographicOrder("abc");
        set.genLexicoGraphOrder();
    }
}
