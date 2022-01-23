package com.tesco.wordwrap;

public class StringOutputStream implements OutputStream<String>{

    private StringBuilder streamBuilder;

    public StringOutputStream(){
        this.streamBuilder =new StringBuilder("");
    }

    @Override
    public void flush(String s) {
        if(s!=null && !s.isEmpty())
                streamBuilder.append(s).append("\n");
    }

    @Override
    public String getStreamData() {
        return streamBuilder.toString();
    }

    @Override
    public void close() throws Exception {
        streamBuilder.delete(0 , streamBuilder.length());
    }
}
