package com.amazon.question;

public class EditDistance {
    private char[] word1;

    private char[] word2;


    private int minDistance[][];

    public EditDistance(String word1, String word2) {
        this.word1 = word1.toCharArray();
        this.word2 = word2.toCharArray();
        this.minDistance =new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<minDistance[0].length;i++)
            minDistance[0][i]=i;
        for(int i=0;i<minDistance.length;i++)
            minDistance[i][0]=i;
    }

    public int minDistance() {
        for(int i=0;i<word1.length;i++)
            for(int j=0;j<word2.length;j++){
                int x=i+1;int y=j+1;
                if(i==j){
                    if(word1[i]==word2[j])
                        minDistance[x][y] =minDistance[x-1][y-1];
                    else
                        minDistance[x][y] = Math.min(Math.min(minDistance[x-1][y-1] , minDistance[x-1][y]), minDistance[x][y-1]) +1;
                }else if(i>j){
                    if(word1[i]==word2[j]){
                        minDistance[x][y] =minDistance[x-1][y-1];
                    }else{
                        minDistance[x][y] = Math.min(Math.min(minDistance[x-1][y-1] , minDistance[x-1][y]), minDistance[x][y-1]) +1;
                    }
                }else{
                    if(word1[i]==word2[j]){
                        minDistance[x][y] =minDistance[x-1][y-1];
                    }else{
                        minDistance[x][y] = Math.min(Math.min(minDistance[x-1][y-1] , minDistance[x-1][y]), minDistance[x][y-1]) +1;
                    }
                }
            }
        return minDistance[minDistance.length-1][minDistance[0].length-1] ;
    }

    public static void main(String[] args) {
        EditDistance distance =new EditDistance("horse","ros");
        System.out.println(distance.minDistance());
    }

}
