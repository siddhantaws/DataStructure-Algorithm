package com.google.dsalgo.question;

public class Single_RowKeyboard {
    private String keyboard;
    private String word;

    public Single_RowKeyboard(String keyboard, String word) {
        this.keyboard = keyboard;
        this.word = word;
    }

    public int calculateTime() {
        int totalMove =0; char wordChar[] =word.toCharArray();
        int lastPos=0;
        for(int i=0;i<wordChar.length;i++){
            totalMove += (Math.abs( lastPos- (wordChar[i]-'a')));
            lastPos = wordChar[i]-'a';
        }
        return totalMove;
    }

    public static void main(String[] args) {
        Single_RowKeyboard rowKeyboard =new Single_RowKeyboard("abcdefghijklmnopqrstuvwxyz","cba");
        System.out.println(rowKeyboard.calculateTime());
    }
}
