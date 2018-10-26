package com.six.patterns.observer;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author hellenxu
 * @date 2017-09-18
 * Copyright 2017 Six. All rights reserved.
 */
public class TestClockDriver {
    private MockTimeSource source;
    private MockTimeSink sink;

    @Before
    public void setUp(){
        source = new MockTimeSource();
        sink = new MockTimeSink(source);
        source.registerObserver(sink);
    }

    private void assertSinkEquals(MockTimeSink sink, int hours, int minutes, int seconds){
        assertEquals(sink.getHours(), hours);
        assertEquals(sink.getMinutes(), minutes);
        assertEquals(sink.getSeconds(), seconds);
    }

    @Test
    public void testTimeChange(){
        source.setTime(3, 4, 5);
        assertSinkEquals(sink, 3, 4, 5);
    }

    @Test
    public void testMultipleObserver(){
        MockTimeSink sink1 = new MockTimeSink(source);
        source.registerObserver(sink1);

        source.setTime(6, 9, 30);
        assertSinkEquals(sink, 6, 9, 30);
        assertSinkEquals(sink1, 6, 9, 30);
    }
}
