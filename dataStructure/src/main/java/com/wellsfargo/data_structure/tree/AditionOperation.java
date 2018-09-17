package com.wellsfargo.data_structure.tree;

public class AditionOperation implements Operation {

    @Override
    public Comparable performOperation(Comparable k1, Comparable val) {
        return (Integer)k1+(Integer)val;
    }
}
