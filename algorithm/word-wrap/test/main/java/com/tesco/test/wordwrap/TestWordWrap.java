package com.tesco.test.wordwrap;

import com.tesco.wordwrap.OutputStream;
import com.tesco.wordwrap.StringOutputStream;
import com.tesco.wordwrap.WordWrap;
import com.tesco.wordwrap.WordWrapImpl;
import org.junit.Before;
import org.junit.Test;

public class TestWordWrap {
    private WordWrap wordWrap ;
    OutputStream<String> outputStream ;
    @Before
    public void initialize(){
        outputStream = new StringOutputStream();
        this.wordWrap =new WordWrapImpl(16 , outputStream);
    }

    @Test
    public void test1(){
        String str ="InterviewCamp.io has hours of system design content. They also do live system design discussions every week. They break down interview prep into fundamental building blocks. Try out their platform. " +
                "Scrapinghub is hiring a Senior Software Engineer (Big Data/AI). You will be designing and implementing distributed systems: large-scale web crawling platform, integrating Deep Learning based web data extraction components, working on queue algorithms, large datasets, creating a development platform for other company departments, etc. - this is going to be a challenging journey for any backend engineer! Please apply here.";

        wordWrap.wrapWord(str);
        System.out.println(outputStream.getStreamData());
    }
}
