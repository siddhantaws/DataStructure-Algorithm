package com.wellsfargo.algo.pattern_matching;

import com.wellsfargo.data_structure.Tries;

import java.util.List;

public class Aho_Corasick_Algo{

    private Tries tries;

    private List<String> listOfPatterns;

    private String text ;

    public Aho_Corasick_Algo(List<String> listOfPatterns ,String text ) {
        this.tries = new Tries();
        this.text=text;
        this.listOfPatterns=listOfPatterns;
    }

    public void init()
    {
        //Build Tries for all pattern
        for(String pattern:listOfPatterns)
            tries.add(pattern);
        //Construct failure node
        //tries.getRootNode().getCharacterNodeMap();
    }

    private void constructFailureNode()
    {

    }
}
