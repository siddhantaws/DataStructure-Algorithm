package com.wellsfargo.algo.mathematics;

public class TowerOfHanoi {
    private int n;

    public TowerOfHanoi(int n) {
        this.n = n;
    }

    public void towerOfHanoi(){
        towerOfHanoi(n ,"A" ,"C" ,"B");
    }

    private void towerOfHanoi(int n , String from_rod , String to_rod , String aux_rod  ){
        if(n==1){
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod);
            return;
        }
        towerOfHanoi(n-1 , from_rod  , aux_rod ,to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        TowerOfHanoi tower =new TowerOfHanoi(3);
        tower.towerOfHanoi();
    }
}
