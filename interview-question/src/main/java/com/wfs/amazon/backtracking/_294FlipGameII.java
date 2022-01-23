package com.wfs.amazon.backtracking;

public class _294FlipGameII {
    private String str;

    public _294FlipGameII(String str) {
        this.str = str;
    }
    public boolean canWin(String s) {
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='+' && s.charAt(i-1)=='+'){
                char ch [] = s.toCharArray();
                ch[i]='-';ch[i-1]='-';
                if(!canWin(new String(ch ,0 ,ch.length)))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _294FlipGameII gameII =new _294FlipGameII("++");
        System.out.println(gameII.canWin("++++"));
    }
}
