package com.design.pattern.factory;

public class EnemyShipFactory {

    public static EnemyShip getEnemyShip(EnemyShipType enemyShipType){
        if(enemyShipType==EnemyShipType.UFO)
            return new UFOEnemyShip();
        return null;
    }
}
