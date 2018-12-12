package com.wfs.devideConqur;

import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TowerOfHanoi {

    private int n;

    private Stack<Integer> sourceStack;

    private Stack<Integer> auxStack;

    private Stack<Integer> destStack;

    public TowerOfHanoi(int n) {
        this.n = n;
        this.sourceStack =new Stack<>();
        this.auxStack = new Stack<>();
        this.destStack =new Stack<>();
        for(int i=1;i<=n;i++)
            sourceStack.push(i);
    }

    private void move(Stack<Integer> source , Stack<Integer> dest ,String sourceTower,String destTower ){

        if(source.isEmpty()){
            source.push(dest.pop());
            print(destTower , sourceTower , source.peek());
        }else if(dest.isEmpty()) {
            dest.push(source.pop());
            print(sourceTower , destTower , dest.peek());
        }else if(source.peek()>dest.peek()){
            source.push(dest.pop());
            print(destTower  ,sourceTower  , source.peek());
        }else{
            dest.push(source.pop());
            print(sourceTower , destTower , dest.peek());
        }
    }

    public void move(){

    }

    private void print(String sourceTower,String destTower , int element){
        System.out.println("From "+sourceTower + " dest->"+destTower+ element);
    }
}
