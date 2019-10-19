package com.design.pattern.factory;

public class UFOEnemyShip implements EnemyShip {

    private String name ;

    private double cost ;

    @Override
    public String name() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public double cost() {
        return cost;
    }

    @Override
    public void setCost(double cost) {
        this.cost=cost;
    }
}
