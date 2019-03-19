package com.wellsfargo.data_structure.stack;

import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TowerOfHanoi {

    private Stack<Integer> sourceStack;

    private Stack<Integer> destStack;

    private Stack<Integer> auxStack;

    private String sourceTower ;

    private String destTower ;

    private String auxTower ;

    private int N ;

    public TowerOfHanoi(int n) {
        N = n;
        this.sourceStack =new Stack();
        this.auxStack =new Stack();
        this.destStack =new Stack();
        this.sourceTower="A";
        this.destTower="C";
        this.auxTower="B";
        for(int i=n;i>0;i++)
            sourceStack.push(i);
    }


    public void move(){
        int i=0;
        while(++i< (2 << N -1)){
            if(i%3==1){
                if(destStack.peek()>sourceStack.peek()){
                    destStack.push(sourceStack.pop());
                    print(sourceTower , destTower, destStack.peek());
                }else{
                    sourceStack.push(destStack.pop());
                    print(sourceTower , destTower, sourceStack.peek());
                }
            }else if(i%3 ==2){

            }else{

            }
        }

    }

    public void print(String sourceTower ,String destTower , int data) {
        System.out.println("Move "+data+" from "+sourceTower+" to "+destTower);
    }
}
