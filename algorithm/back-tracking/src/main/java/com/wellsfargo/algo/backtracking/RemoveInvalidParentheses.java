package com.wellsfargo.algo.backtracking;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {

    private String expression;

    public RemoveInvalidParentheses(String expression) {
        this.expression = expression;
    }

    private boolean isParenthesis(char c){
        return ((c == '(') || (c == ')'));
    }

    private boolean isValidString(String str){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    public void removeInvalidParenthesis(){
        removeInvalidParenthesis(expression);
    }
    private void removeInvalidParenthesis(String str){
        if (str.length()==0)
            return ;

        //  visit set to ignore already visited string
        Set<String> visit =new HashSet<>();
        //  queue to maintain BFS
        Queue<String> q =  new ArrayDeque<>();
        String temp;
        boolean level =false;

        q.add(str);
        visit.add(str);

        while (q.size()>0) {
            str = q.poll();

            if (isValidString(str))
            {
                System.out.println(str);

                // If answer is found, make level true
                // so that valid string of only that level
                // are processed.
                level = true;
            }
            if (level)
                continue;
            for (int i = 0; i < str.length(); i++) {
                if (!isParenthesis(str.charAt(i)))
                    continue;

                // Removing parenthesis from str and
                // pushing into queue,if not visited already
                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visit.contains(temp))
                {
                    q.offer(temp);
                    visit.add(temp);
                }
            }

        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses =new RemoveInvalidParentheses("()())()");
        removeInvalidParentheses.removeInvalidParenthesis();
    }
}
