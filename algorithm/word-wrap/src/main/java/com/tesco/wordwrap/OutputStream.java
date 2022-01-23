package com.tesco.wordwrap;

public interface OutputStream<K> extends AutoCloseable{
    public void flush(K k);
    public K getStreamData();
}
