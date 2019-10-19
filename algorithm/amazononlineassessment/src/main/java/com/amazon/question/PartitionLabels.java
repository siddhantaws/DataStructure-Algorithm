package com.amazon.question;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    private String str;

    public PartitionLabels(String str) {
        this.str = str;
    }

    public List<Integer> partitionLabels() {
        char ch[] =new char[26];
        for(int i=0;i<str.length();i++)
            ch[str.charAt(i)-'a']= (char) i;
        List<Integer> list =new ArrayList<>();
        int star =0;int end =0;
        for(int i=0;i<str.length();i++){
            end=Math.max(end ,ch[str.charAt(i)-'a'] );
            if(end==i){
                list.add(end-star+1);
                star=end+1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PartitionLabels labels =new PartitionLabels("ababcbacadefegdehijhklij");
        System.out.println(labels.partitionLabels());
    }
}
