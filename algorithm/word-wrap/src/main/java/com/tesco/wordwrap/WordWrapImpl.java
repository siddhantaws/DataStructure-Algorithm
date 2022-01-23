package com.tesco.wordwrap;

public class WordWrapImpl implements  WordWrap{

    private static int DEFAULT_WORD_WIDTH = 8;

    private int maxWordLength ;

    private char[] tempCharArray;

    private OutputStream<String> outputStream ;

    /*private ThreadLocal<OutputStream<String>> outputStreamThreadLocal = new ThreadLocal<OutputStream<String>>(

    ) ;*/

    public WordWrapImpl(int maxWordLength , OutputStream<String> outputStream){
        this.maxWordLength=maxWordLength;
        this.tempCharArray = new char[maxWordLength];
        this.outputStream = outputStream;
    }

    public WordWrapImpl(int maxWordLength){

    }


    public WordWrapImpl(){
        this(DEFAULT_WORD_WIDTH);
    }

    @Override
    public void wrapWord(String str) {
        char charSeq []= str.toCharArray();
        int i =0;
        while(i<charSeq.length){
               System.arraycopy(charSeq ,i ,tempCharArray ,  0 , tempCharArray.length);
               if(i<charSeq.length && (charSeq[i-1]==' '  || charSeq[i+1]==' ')){
                   if( charSeq[i+1]==' '){
                       i++;
                       outputStream.flush(new String(charSeq , 0 , charSeq.length));
                       continue;
                   }
               }
               else if(i<charSeq.length){
                   int k = i;
                   while(' '!=charSeq[k])
                    k--;
                   outputStream.flush(new String(charSeq , 0 , k+1));
                   i=k;
               }
        }
    }
}
