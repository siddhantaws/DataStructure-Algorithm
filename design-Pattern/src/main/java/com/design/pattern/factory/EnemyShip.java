package com.design.pattern.factory;

public interface EnemyShip {
    public String name();
    public void setName(String name);
    public double  cost();
    public void setCost(double cost);

    public default void printDetail(){
        System.out.println("Enemey Ship name is "+name()+" ad cost "+cost());
    }
}
