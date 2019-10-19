package com.design.pattern.factory;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        EnemyShip  enemyShip = EnemyShipFactory.getEnemyShip(EnemyShipType.UFO);
    }
}
