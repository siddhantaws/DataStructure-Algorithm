package com.wellsfargo.data_structure.stack;

import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class DesignStackGetMin_O_1_Time_O_1_ExtraSpace {

    private Stack<Integer> stack;

    private Integer minEle;

    public DesignStackGetMin_O_1_Time_O_1_ExtraSpace() {
        this.stack = new Stack<>();
        this.minEle = Integer.MAX_VALUE;
    }

    public void push(Integer num){
          if(stack.isEmpty()) {
              stack.push(num);
              minEle =num;
              return;
          }else if(stack.peek()<num){
              stack.push(num);
              return;
          }else {
              stack.push(2*num - minEle);
              minEle =num;
          }
    }

    public int getMinimum(){
        if(!stack.isEmpty())
            return minEle;
        throw new UnsupportedOperationException("Stack is empty");
    }

    public void pop(){
        if(!stack.isEmpty()){
            int x =stack.pop();
            if(x<minEle){
                System.out.println("Pop Element "+ x);
                minEle = 2*minEle-x;
                System.out.println("Minimum Element "+ minEle);
            }else{
                System.out.println("Minimum Element "+ minEle);
                System.out.println("Pop Element "+ x);
            }
        }
        throw new UnsupportedOperationException("Stack is empty");
    }

    public static void main(String[] args) {
        DesignStackGetMin_O_1_Time_O_1_ExtraSpace time_o_1_extraSpace =new DesignStackGetMin_O_1_Time_O_1_ExtraSpace();

    }
}
