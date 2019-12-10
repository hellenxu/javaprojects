package main.java.com.six.patterns.strategy;

/**
 * @author hellenxu
 * @date 2017-08-15
 * Copyright 2017 Six. All rights reserved.
 */
public interface SortHandler {
    void swap(int index);
    boolean outOfOrder(int index);
    int getLength();
    void setArray(Object array);
}
