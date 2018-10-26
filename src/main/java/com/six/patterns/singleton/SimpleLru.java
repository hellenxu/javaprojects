package com.six.patterns.singleton;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Simple Version of Lru
 * Created by hellenxu on 2017-02-17.
 */
public class SimpleLru extends LinkedHashMap{
    private int capacity;
    public SimpleLru(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        final int size = size();
        return size > capacity;
    }
}
