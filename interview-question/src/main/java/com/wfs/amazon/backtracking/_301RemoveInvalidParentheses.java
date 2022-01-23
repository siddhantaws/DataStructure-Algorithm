package com.wfs.amazon.backtracking;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _301RemoveInvalidParentheses {
    private String str ;

    private Set<String> strings =new HashSet<>();
    private StringBuilder sb = new StringBuilder("");
    private int maxLength = Integer.MIN_VALUE;
    public _301RemoveInvalidParentheses(String str) {
        this.str = str;
    }

    public List<String> removeInvalidParentheses() {
        removeInvalidParentheses(str,sb , 0 , 0 ,0);
        return strings.stream().collect(Collectors.toList());
    }

    private void removeInvalidParentheses(String str ,StringBuilder sb,int lb,int rb,int index ){
        if(index >= str.length()){
            if (lb>0 && lb==rb){
                if(sb.toString().length()>maxLength){
                    strings.clear();
                    strings.add(sb.toString());
                    maxLength =sb.toString().length();
                }else if(maxLength == sb.toString().length())
                    strings.add(sb.toString());
            }
            return;
        }
        removeInvalidParentheses(str,sb,lb,rb,index+1);
        char c = str.charAt(index);
        if( (c==')' && lb>rb) || (c=='(')){
            removeInvalidParentheses(str,sb.append(c+""),c=='(' ? lb+1 : lb,c==')' ? rb+1 : rb,index+1);
            if(sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
        }else if (c!='(' && c!=')'){
            removeInvalidParentheses(str,sb.append(c+""),lb,rb,index+1);
            if(sb.length()>0)
                sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        _301RemoveInvalidParentheses invalidParentheses =new _301RemoveInvalidParentheses("()())()");
        for(String s :invalidParentheses.removeInvalidParentheses())
            System.out.println(s);
    }
}
