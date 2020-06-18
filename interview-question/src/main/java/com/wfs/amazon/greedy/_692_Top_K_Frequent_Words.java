package com.wfs.amazon.greedy;

import java.util.*;

public class _692_Top_K_Frequent_Words {
    private String[] words;
    private int k;

    public _692_Top_K_Frequent_Words(String[] words, int k) {
        this.words = words;
        this.k = k;
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String , WordToCountFrequency> frequenceyMap =new HashMap();
        Queue<WordToCountFrequency> queue =new PriorityQueue<>();
        for(String word:words)
            if(frequenceyMap.containsKey(word))
                frequenceyMap.get(word).frequency++;
            else
                frequenceyMap.put(word , new WordToCountFrequency(word , 1));


        for(Map.Entry<String,WordToCountFrequency> entryOfWords : frequenceyMap.entrySet()){
            if(queue.size()>4)
                queue.poll();
            queue.add(entryOfWords.getValue());
        }
        List<String> ans = new ArrayList();
        while (!queue.isEmpty())
            ans.add(queue.poll().word);
        Collections.reverse(ans);
        return ans;
    }

    static class WordToCountFrequency implements Comparable<WordToCountFrequency>{
        String word;

        int frequency;

        WordToCountFrequency(String word ,int frequency ){
            this.word =word;
            this.frequency =frequency;
        }

        public int compareTo(WordToCountFrequency countFrequency){
            return this.frequency - countFrequency.frequency;
        }
    }
}
