package com.six.patterns.templatemethod;

/**
 * @author hellenxu
 * @date 2017-08-15
 * Copyright 2017 Six. All rights reserved.
 */
public class IntBubbleSorter extends BubbleSorter {
    private  int[] array = null;

    public int doSort(int[] array) {
        this.array = array;
        length = array.length;
        return sort();
    }

    @Override
    protected void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return array[index] > array[index + 1];
    }
}
