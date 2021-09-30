package com.hjk.hjkbookstore_backend.utils;

import java.util.concurrent.atomic.AtomicLong;

public class VisitorCounter {
    private final AtomicLong visitorNumber=new AtomicLong(0);

    public void increaseCounter(){visitorNumber.incrementAndGet();}

    public Long getCounter(){return visitorNumber.get();}

}
