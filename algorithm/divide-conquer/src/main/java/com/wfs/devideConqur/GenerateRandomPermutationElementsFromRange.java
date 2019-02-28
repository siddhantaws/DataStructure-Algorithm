package com.wfs.devideConqur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GenerateRandomPermutationElementsFromRange {
    private int L ;
    private int R ;
    private List<Integer> integers ;

    public GenerateRandomPermutationElementsFromRange(int l, int r) {
        L = l;
        R = r;
        integers =new ArrayList<>();
    }

    public void generateRandom(){
        generateRandom(L,R);
    }

    private void generateRandom(int l , int r){

        if(l>r)
            return;

        int rand =give_random_number(l,r);
        integers.add(rand);
        generateRandom(l,rand-1);
        generateRandom(rand+1,r);
    }

    private int give_random_number(int l, int r) {
        Random random =new Random();
        return  (random.nextInt() % (r-l+1) ) +l;
    }
}
