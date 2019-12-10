package main.java.com.six.patterns.strategy;

/**
 * @author hellenxu
 * @date 2017-08-15
 * Copyright 2017 Six. All rights reserved.
 */
public class IntSortHandler implements SortHandler {
    private int[] array = null;

    public IntSortHandler(int[] array) {
        this.array = array;
    }

    @Override
    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    @Override
    public boolean outOfOrder(int index) {
        return array[index] > array[index + 1];
    }

    @Override
    public int getLength() {
        return array.length;
    }

    @Override
    public void setArray(Object array) {
        this.array = (int[]) array;
    }
}
