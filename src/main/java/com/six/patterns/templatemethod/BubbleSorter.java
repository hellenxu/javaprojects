package com.six.patterns.templatemethod;

/**
 * @author hellenxu
 * @date 2017-08-15
 * Copyright 2017 Six. All rights reserved.
 */
public abstract class BubbleSorter {
    int length = 0;

    int sort() {
        int operations = 0;
        if (length <= 1) {
            return operations;
        }

        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--) {
            for (int index = 0; index <= nextToLast; index++) {
                if(outOfOrder(index)) {
                    swap(index);
                }
                operations++;
            }
        }
        return operations;
    }

    protected abstract void swap(int index);

    protected abstract boolean outOfOrder(int index);
}
