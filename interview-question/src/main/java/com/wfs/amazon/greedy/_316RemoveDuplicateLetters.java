package com.wfs.amazon.greedy;

import java.util.*;

public class _316RemoveDuplicateLetters {

    private String s;

    public _316RemoveDuplicateLetters(String s) {
        this.s = s;
    }

    public String removeDuplicateLetters() {
        Map<Character,Integer> mapOfCharacterToPos =new HashMap<>();
        for(int i=0;i<s.toCharArray().length;i++)
            mapOfCharacterToPos.put(s.charAt(i) ,i);
        Stack<Integer> stack =new Stack();
        Set<Character> sets=new HashSet<>();
        stack.push(0);sets.add(s.charAt(0));
        for(int i=1;i<s.toCharArray().length;i++){
            if(s.charAt(stack.peek())>s.charAt(i)){
                while(!stack.isEmpty() && mapOfCharacterToPos.get(s.charAt(stack.peek()))>i){
                    sets.remove(s.charAt(stack.pop()));
                }
            }
            if(sets.contains(s.charAt(i))){
                continue;
            }
            sets.add(s.charAt(i));
            stack.push(i);
        }
        char ch[]=new char[stack.size()];
        for(int i =stack.size()-1;i>=0;i--)
            ch[i]= s.charAt(stack.pop());
        return new String(ch);
    }

    public static void main(String[] args) {
        _316RemoveDuplicateLetters letters =new _316RemoveDuplicateLetters("cbacdcbc");
        System.out.println(letters.removeDuplicateLetters());
    }
}
